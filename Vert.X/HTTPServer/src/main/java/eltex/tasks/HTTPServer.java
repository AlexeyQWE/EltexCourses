package eltex.tasks;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;

public class HTTPServer {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков
        vertx.createHttpServer().requestHandler(request -> {
            System.out.println(request.uri()); // что было вызвано
            request.response()
                    .putHeader("Content-Type", "application/json")
                    .end("{\"text\":\"Hello\""); // завершение и отправка данных
        }).listen(8081);

        EventBus eb = vertx.eventBus();
        MessageConsumer<String> consumer = eb.consumer("news.uk.sport");
        consumer.handler(message -> {
            System.out.println("I have received a message: " + message.body());
        });
        eb.send("news.uk.sport", "Hello");
    }
}

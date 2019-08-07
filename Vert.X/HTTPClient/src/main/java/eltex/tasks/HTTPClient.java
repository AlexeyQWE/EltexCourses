package eltex.tasks;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;

public class HTTPClient {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        HttpClientOptions options = new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true);
        HttpClient client = vertx.createHttpClient(options);
        client.requestAbs(HttpMethod.GET, "https://api.vk.com/method/users.get?user_ids=210700286&fields=bdate&access_token=533bacf01e11f55b536a565b57531ac114461ae8736d6506a3&v=5.101",
            result -> {
                System.out.println(result.statusCode());
                result.bodyHandler(body -> {
                    System.out.println(body.toString());
                });
            }).end();
    }
}

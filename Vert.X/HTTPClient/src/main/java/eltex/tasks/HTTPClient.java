package eltex.tasks;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import java.util.Scanner;

public class HTTPClient {

    public static void main(String[] args) { 

        Vertx vertx = Vertx.vertx();

        HttpClientOptions options = new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true);

        HttpClient client = vertx.createHttpClient(options);

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter user id: ");
        String id = scan.nextLine();

        System.out.print("Enter field: ");
        String field = scan.nextLine();

        client.requestAbs(HttpMethod.GET, "https://api.vk.com/method/users.get?user_ids=" + id + 
            "&fields=" + field + "&access_token=***&v=5.101",
            result -> {
                System.out.println(result.statusCode());
                result.bodyHandler(body -> {
                    System.out.println(body.toString());
                });
            }).end();
    }
}

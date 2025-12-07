package com.shubham.httpclient;

import io.netty.handler.codec.http.HttpResponseStatus;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserAPIClient {

    public static void main(String[] args) throws IOException {
        getUserById(1).subscribe(System.out::println);
        System.in.read();
    }

    private static Mono<String> getUserById(int id) {
        return HttpClientProvider.getHttpClient()
                .get()
                .uri("/users/" + id)
                .responseSingle((res, content) ->
                        content.asString()
                );
    }
}

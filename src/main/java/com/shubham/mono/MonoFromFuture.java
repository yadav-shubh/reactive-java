package com.shubham.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {
    private static final Logger log = LoggerFactory.getLogger(MonoFromFuture.class);

    static void main() throws IOException {
        Mono.fromFuture(() -> getUserInfo(8))
                        .subscribe(System.out::println);

        System.in.read();
    }

    private static CompletableFuture<String> getUserInfo(int id) {
        log.info("getUserInfo");
        return CompletableFuture.supplyAsync(() -> {
            if (id == 1) {
                return "User 1";
            } else {
                return "User 2";
            }
        });
    }
}
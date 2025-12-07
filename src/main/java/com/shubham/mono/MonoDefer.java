package com.shubham.mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(MonoDefer.class);

    static void main() throws IOException {
        Mono.defer(() -> createPublisher())
                .subscribe(System.out::println);
    }

    private static Mono<Integer> createPublisher() {
        log.info("createPublisher");
        List<Integer> list = List.of(1, 2, 3, 4);
        return Mono.fromSupplier(() -> sum(list));
    }

    private static Integer sum(List<Integer> list) {
        System.out.println("Summing");
        return list.stream().reduce(0, Integer::sum);
    }
}
package com.shubham.flux;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxFromIterable {
    static void main() {
        List<String> strings = List.of("Ram", "Mahesh");
        Flux<String> just = Flux.fromIterable(strings);
        just.subscribe(System.out::println);
    }
}

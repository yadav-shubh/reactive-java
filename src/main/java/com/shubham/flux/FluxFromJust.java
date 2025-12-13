package com.shubham.flux;

import reactor.core.publisher.Flux;

public class FluxFromJust {
    static void main() {
        Flux.just("Hello", "World").subscribe(System.out::println);

        System.out.println("Multiple values");
        Flux<String> just = Flux.just("H", "E");

        just.subscribe(System.out::println);
        just.subscribe(System.out::println);
    }
}

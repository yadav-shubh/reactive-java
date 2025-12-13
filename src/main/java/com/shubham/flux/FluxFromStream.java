package com.shubham.flux;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromStream {
    static void main() {
        var strings = Stream.of("Ram", "Mahesh");
        Flux<String> just = Flux.fromStream(strings);
        just.subscribe(System.out::println);
    }
}

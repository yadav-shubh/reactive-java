package com.shubham.flux;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class FluxFromRange {
    static void main() {
        Flux<Integer> just = Flux.range(1, 20);
        just.subscribe(System.out::println);

        Flux.range(1,10)
                .map(number -> Faker.instance().name().name())
                .subscribe(System.out::println);
    }
}

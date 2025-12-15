package com.shubham.flux;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FluxGenerate {
    static void main() {
        generate();
    }

    private static void generate() {
        var generator = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
                    System.out.println("generator: " + generator.get());
                    synchronousSink.next(generator.incrementAndGet());
        })
                .take(5)
                .subscribe(name -> {
            System.out.println("name: " + name);
        });
    }
}

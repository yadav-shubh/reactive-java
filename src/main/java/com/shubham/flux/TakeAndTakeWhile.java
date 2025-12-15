package com.shubham.flux;

import reactor.core.publisher.Flux;

public class TakeAndTakeWhile {
    static void main() throws InterruptedException {
//        take();
        takeWhile();
    }

    private static void take() {
        Flux.range(1, 10)
                .take(3)
                .subscribe(n -> System.out.println("received: " + n));
    }

    private static void takeWhile() {
        Flux.range(1, 10)
                .takeWhile(n -> n < 5)
                .subscribe(n -> System.out.println("received: " + n));
    }
}

package com.shubham.flux;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class ThreadSafety {
    static void main() throws InterruptedException {
//        runnableEx();
        fluxEx();
    }

    private static void runnableEx() throws InterruptedException {
        var list = new ArrayList<Integer>();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread.ofPlatform().start(runnable);
        }

        Thread.sleep(3000);
        System.out.println(list.size());
    }

    private static void fluxEx() throws InterruptedException {
        var list = new ArrayList<String>();
        Faker instance = Faker.instance();

        Flux<String> flux = Flux.create(fluxSink -> {
            list.add(instance.name().name());
        });
        flux.subscribe(list::add);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                flux.subscribe(list::add);
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }

        Thread.sleep(3000);
        System.out.println(list.size());
    }
}

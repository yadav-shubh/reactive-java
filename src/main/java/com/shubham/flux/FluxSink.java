package com.shubham.flux;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;


public class FluxSink {

    private static final Logger log = LogManager.getLogger(FluxSink.class);

    static void main() throws InterruptedException {
        produceEarly();
//        produceOnDemand();
    }

    static void produceOnDemand() throws InterruptedException {
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            fluxSink.onRequest(request -> {
                for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                    var name = Faker.instance().name().firstName();
                    System.out.println("generated: " + name);
                    fluxSink.next(name);
                }
            });
        }).subscribe(subscriber);


        Thread.sleep(2);
        subscriber.getSubscription().request(2);
        Thread.sleep(2);
        subscriber.getSubscription().request(2);
        Thread.sleep(2);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }

    static void produceEarly() throws InterruptedException {
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                var name = Faker.instance().name().firstName();
                System.out.println("generated: " + name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);


        Thread.sleep(2);
        subscriber.getSubscription().request(2);
        Thread.sleep(2);
        subscriber.getSubscription().request(2);
        Thread.sleep(2);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }
}

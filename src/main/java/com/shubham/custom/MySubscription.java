package com.shubham.custom;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

record MySubscription(List<String> items, Subscriber<? super String> subscriber) implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(MySubscription.class);

    @Override
    public void request(long n) {
        log.info("Request received: {}", n);
        for (int i = 0; i < n; i++) {
            log.info("Request requested: {}", i);
            subscriber.onNext(items.get(i));
        }
        subscriber.onComplete();
    }

    @Override
    public void cancel() {
        log.info("Subscription cancelled");
        subscriber.onComplete();
    }
}

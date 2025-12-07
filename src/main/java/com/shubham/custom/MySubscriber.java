package com.shubham.custom;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySubscriber implements Subscriber<String> {
    private static final Logger log = LoggerFactory.getLogger(MySubscriber.class);
    private final long count;
    private Subscription subscription;

    public MySubscriber(long count) {
        this.count = count;
    }

    @Override
    public void onSubscribe(Subscription s) {
        log.info("onSubscribe: {}", s);
        this.subscription = s;
        s.request(count);
    }

    @Override
    public void onNext(String s) {
        log.info("onNext: {}", s);
    }

    @Override
    public void onError(Throwable t) {
       log.info("onError: {}", t.getLocalizedMessage());
    }

    @Override
    public void onComplete() {
        log.info("onComplete the stream is completed");
    }

    public void cancel() {
        if (subscription != null) {
            subscription.cancel();
        }
    }
}

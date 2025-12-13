package com.shubham.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySubscriber implements Subscriber<String> {
    private static final Logger log = LogManager.getLogger(MySubscriber.class);
    private final long count;
    private Subscription subscription;

    public MySubscriber(long count) {
        this.count = count;
    }

    public void request(int n){
        subscription.request(n);
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

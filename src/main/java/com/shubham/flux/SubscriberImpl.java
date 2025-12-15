package com.shubham.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public class SubscriberImpl implements Subscriber<Object> {

    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(Object email) {
        System.out.println("received: "+email);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error: "+ throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("completed");
    }
}
package com.shubham.custom;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class MyPublisher implements Publisher<String> {

    private final List<String> items;
    private final long count;

    public MyPublisher(List<String> items) {
        this.items = items;
        this.count = items.size();
    }

    @Override
    public void subscribe(Subscriber<? super String> s) {
        if (s == null) throw new NullPointerException("Subscriber is null");
        s.onSubscribe(new MySubscription(items, s));
    }

    public long getCount() {
        return count;
    }
}

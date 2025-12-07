package com.shubham.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Runner {
    
    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    /**
     * A main method that publishes a list of strings to a subscriber.
     * The list contains the characters to spell out "HELLO WORLD".
     * The subscriber is created with a count equal to the number of items in the publisher.
     * The subscriber is then subscribed to the publisher.
     */
    static void main() throws IOException {
        MyPublisher publisher = new MyPublisher(List.of("H", "E", "L", "L", "O", "W", "O", "R", "L", "D"));
        MySubscriber subscriber = new MySubscriber(publisher.getCount());
        publisher.subscribe(subscriber);
        log.info("Main method completed");
    }
}

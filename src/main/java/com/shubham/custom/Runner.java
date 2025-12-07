package com.shubham.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Runner {
    
    private static final Logger log = LogManager.getLogger(Runner.class);
    /**
     * A main method that publishes a list of strings to a subscriber.
     * The list contains the characters to spell out "HELLO WORLD".
     * The subscriber is created with a count equal to the number of items in the publisher.
     * The subscriber is then subscribed to the publisher.
     */
    public static void main(String[] args) {
        MyPublisher publisher = new MyPublisher(List.of("H", "E", "L", "L", "O", "W", "O", "R", "L", "D"));
        MySubscriber subscriber = new MySubscriber(publisher.getCount());
        publisher.subscribe(subscriber);
        log.info("Main method completed");
    }
}

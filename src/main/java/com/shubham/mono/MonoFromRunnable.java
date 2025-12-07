package com.shubham.mono;

import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromRunnable {
    static void main() {
        Mono.fromRunnable(getUserInfo(2))
                .subscribe();
    }

    private static Runnable getUserInfo(int id) {
        if (id == 1) {
            return () -> {
                System.out.println("User 1");
            };
        } else {
            return () -> {
                System.out.println("User 2");
            };
        }
    }
}
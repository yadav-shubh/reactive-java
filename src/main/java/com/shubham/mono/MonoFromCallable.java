package com.shubham.mono;

import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromCallable {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 5, 3);
        Mono.fromCallable(() -> sum(list))
                .subscribe();
    }

    private static Integer sum(List<Integer> list) {
        System.out.println("Summing");
        return list.stream().reduce(0, Integer::sum);
    }
}

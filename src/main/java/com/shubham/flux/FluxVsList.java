package com.shubham.flux;

import com.github.javafaker.Faker;
import com.shubham.custom.MySubscriber;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FluxVsList {

    private static final Faker faker = Faker.instance();

    static void main() {

        generateNameFlux(10).subscribe(System.out::println);

        Flux.range(3, 5)
                .map(i -> i / (i - 4));



    }

    // 4743
//     6193


    private static List<String> generateName(int number) {
        return IntStream.rangeClosed(1, number).mapToObj(n ->{
            String name = faker.name().name();
            System.out.println("Generating name: " + name);
            return name;
        } ).toList();
    }

    private static Flux<String> generateNameFlux(int number) {
        return Flux.range(1, number + 1).map(n -> faker.name().name());
    }
}

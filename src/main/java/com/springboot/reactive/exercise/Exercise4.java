package com.springboot.reactive.exercise;

import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(integer -> System.out.println(integer));

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer block = ReactiveSources.intNumberMono().block();
        Integer block1 = ReactiveSources.intNumberMono().block(Duration.ofSeconds(5));
        Optional<Integer> blockOptional = ReactiveSources.intNumberMono().blockOptional();

        System.out.println("Press a key to end");
        System.in.read();
    }

}

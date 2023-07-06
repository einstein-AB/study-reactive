package com.springboot.reactive.exercise;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(integer -> System.out.println(integer),
                        throwable -> System.out.println("Error happened: " + throwable.getMessage()));

        ReactiveSources.intNumbersFluxWithException()
                .doOnError(throwable -> System.out.println("Error happened: " + throwable.getMessage()))
                .subscribe(integer -> System.out.println(integer));


        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((throwable, item) -> System.out.println("Error happened: " + item))
                .subscribe(integer -> System.out.println(integer));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(throwable -> Flux.just(-1, -2))
                .subscribe(integer -> System.out.println(integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
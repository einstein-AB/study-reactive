package com.springboot.reactive.exercise;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise10 {

    public static void main(String[] args) throws IOException {

        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();
        Flux<String> stringFlux = ReactiveSources.stringNumbersFlux();

        //Combine both the flux
        integerFlux.zipWith(stringFlux)
                .map(tuple -> tuple.getT1() + " || " +tuple.getT2())
                .subscribe(resultString -> System.out.println(resultString));

        System.out.println("Press a key to end");
        System.in.read();
    }
}

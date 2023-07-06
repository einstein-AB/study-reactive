package com.springboot.reactive.exercise;

import reactor.core.publisher.SignalType;

import java.io.IOException;

public class BonusExercise {

    public static void main(String[] args) throws IOException {

        ReactiveSources.intNumbersFluxWithException()
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_NEXT) {
                        System.out.println("On Next is happening...");
                    }
                    if (signalType == SignalType.ON_ERROR) {
                        System.out.println("=============Error happened==========");
                    }
                    if (signalType ==  SignalType.ON_COMPLETE) {
                        System.out.println("Completed Successfully");
                    }
                })
                .subscribe(integer -> System.out.println(integer));

        System.out.println("Press a key to end");
        System.in.read();
    }
}

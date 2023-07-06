package com.springboot.reactive.exercise;

import org.reactivestreams.Subscription;
import reactor.core.Exceptions;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .subscribe(integer -> System.out.println(integer),
                        error -> System.out.println("<<<<ERROR>>>>" + error.getMessage()),
                        () -> System.out.println("Flux emitting completed"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .subscribe(new MyBaseSubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MyBaseSubscriber<Integer> extends BaseSubscriber<Integer> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription happened");
        subscription.request(2);
        //subscription.request(9223372036854775807L);
    }

    public void hookOnNext(Integer value) {
        System.out.println(value + " received");
        request(5);
    }

    public void hookOnComplete() {
        System.out.println("Flux emitting completed");
    }

    public void hookOnError(Throwable error) {
        System.out.println("<<<<ERROR>>>>" + error.getMessage());
        //throw Exceptions.errorCallbackNotImplemented(throwable);
    }


}

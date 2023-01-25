package com.springboot.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void monoTest() {
        Mono<String> monoString = Mono.just("TestString").log();
        monoString.subscribe(consumedData-> System.out.println(consumedData));
    }

    @Test
    public void FluxTest() {
        Flux<String> fluxString = Flux.just("Spring", "SpringBoot", "Microservices", "AWS").log();
        fluxString.subscribe(consumedFlux-> System.out.println(consumedFlux));
    }
}

package com.springboot.reactive.functional.dao;

import com.springboot.reactive.functional.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class CustomerDaoFunctional {

    public Flux<Customer> getCustomersList(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(index-> System.out.println("processing stream count: "+index))
                .map(i-> new Customer(i, "StreamCustomer-"+i));
    }

    public Flux<Customer> getCustomersListStream(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(index-> System.out.println("processing stream count: "+index))
                .map(i-> new Customer(i, "StreamCustomer-"+i));
    }
}

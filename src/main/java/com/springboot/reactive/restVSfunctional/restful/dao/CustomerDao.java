package com.springboot.reactive.restVSfunctional.restful.dao;

import com.springboot.reactive.restVSfunctional.restful.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepThreadExecution() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1, 10)
                .peek(index -> System.out.println("processing count: "+index))
                .peek(index-> CustomerDao.sleepThreadExecution())
                .mapToObj(i-> new Customer(i, "Customer-"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1, 10)
                .doOnNext(index-> System.out.println("processing stream count: "+index))
                .delayElements(Duration.ofSeconds(1))
                .map(i-> new Customer(i, "StreamCustomer-"+i));
    }
}

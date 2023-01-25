package com.springboot.reactive.functional.handler;

import com.springboot.reactive.functional.dao.CustomerDaoFunctional;
import com.springboot.reactive.functional.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandlerFunctional {

    @Autowired
    CustomerDaoFunctional customerDaoFunctional;

    public Mono<ServerResponse> getCustomerListStream(ServerRequest serverRequest) {
        Flux<Customer> customersListStream = customerDaoFunctional.getCustomersListStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customersListStream, Customer.class);
    }
}

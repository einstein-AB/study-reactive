package com.springboot.reactive.functional.handler;

import com.springboot.reactive.functional.dao.CustomerDaoFunctional;
import com.springboot.reactive.functional.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDaoFunctional customerDaoFunctional;

    public Mono<ServerResponse> getCustomerList(ServerRequest serverRequest) {
        Flux<Customer> customersList = customerDaoFunctional.getCustomersList();
        return ServerResponse.ok()
                .body(customersList, Customer.class);
    }

}

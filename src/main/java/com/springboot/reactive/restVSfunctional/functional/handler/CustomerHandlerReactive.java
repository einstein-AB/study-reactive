package com.springboot.reactive.restVSfunctional.functional.handler;

import com.springboot.reactive.restVSfunctional.restful.dao.CustomerDao;
import com.springboot.reactive.restVSfunctional.restful.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandlerReactive {

    @Autowired
    CustomerDao customerDao;

    public Mono<ServerResponse> getCustomerListStream(ServerRequest serverRequest) {
        Flux<Customer> customersListStream = customerDao.getCustomersStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customersListStream, Customer.class);

        //Even if everything is reactive, content type can make a difference by providing valuable info to the server
        //If the content type is not specified as event_stream, then the server treats it as a collective response
    }
}

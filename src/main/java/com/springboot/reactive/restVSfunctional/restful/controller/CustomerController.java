package com.springboot.reactive.restVSfunctional.restful.controller;

import com.springboot.reactive.restVSfunctional.restful.dao.CustomerDao;
import com.springboot.reactive.restVSfunctional.restful.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping ("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/rest")
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @GetMapping (value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomersStream() {
        return customerDao.getCustomersStream();
    }
}

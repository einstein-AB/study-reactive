package com.springboot.reactive.restful.service;

import com.springboot.reactive.restful.dao.CustomerDao;
import com.springboot.reactive.restful.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();

        double total = end-start/1000;
        System.out.println("Total Execution time: "+ total);
        return customers;
    }

    public Flux<Customer> getCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();

        double total = end-start/1000;
        System.out.println("Total Execution time: "+ total);
        return customers;
    }
}

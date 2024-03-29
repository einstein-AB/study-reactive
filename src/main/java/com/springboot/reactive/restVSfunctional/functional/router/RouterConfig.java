package com.springboot.reactive.restVSfunctional.functional.router;

import com.springboot.reactive.restVSfunctional.functional.handler.CustomerHandlerReactive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandlerReactive customerHandlerReactive;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router/customers/stream", customerHandlerReactive::getCustomerListStream)
                .build();
    }
}

package com.springboot.reactive.functional.router;

import com.springboot.reactive.functional.handler.CustomerHandler;
import com.springboot.reactive.functional.handler.CustomerHandlerFunctional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerHandlerFunctional customerHandlerFunctional;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router/customers", customerHandler::getCustomerList)
                .GET("/router/customers/stream", customerHandlerFunctional::getCustomerListStream)
                .build();
    }
}

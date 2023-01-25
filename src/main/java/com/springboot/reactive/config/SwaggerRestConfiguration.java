package com.springboot.reactive.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerRestConfiguration {

    Logger logger = LoggerFactory.getLogger(SwaggerRestConfiguration.class);

    /*Configuring what is considered for API documentation in swagger*/
    //IF THIS IS NOT DEFINED, THEN UNWANTED MAPPING LIKE `Basic Error Controller` ARE ALSO SHOWN IN SWAGGER
    //@Bean
    public Docket swaggerConfiguration() {
        logger.info("Configuring swagger from main app");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**")) //URLs starting with this patterns
                .apis(RequestHandlerSelectors.basePackage("com.springboot.reactive")) //scan only this package for documentation inclusion
                .build();
    }
}

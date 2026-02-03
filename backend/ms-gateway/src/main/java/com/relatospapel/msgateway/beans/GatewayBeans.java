package com.relatospapel.msgateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayBeans {

    @Bean
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("books", route -> route
                        .path("/api/v1/books", "/api/v1/books/**")
                        .uri("http://127.0.0.1:8999")
                ).build();
    }


}

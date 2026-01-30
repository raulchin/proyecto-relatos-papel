package com.relatospapel.msgateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans {

    @Bean
    @Profile( value = "eureka-off" )
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("books", route -> route
                        .path("/v1/books", "/v1/books/**")
                        .uri("http://127.0.0.1:8999")
                ).build();
    }

    @Bean
    @Profile( value = "eureka-on" )
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("books", route -> route
                        .path("/v1/books", "/v1/books/**")
                        .uri("lb://ms-books-catalogue")
                ).build();
    }
}

package com.rbinnovative.rentalotool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${service.url.tools}")
    private String toolsUrl;
    @Value("${service.url.orders}")
    private String orders;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/tools")
                        .uri(toolsUrl))
                .route(p -> p
                        .path("/tools/*")
                        .uri(toolsUrl))
                .route(p -> p
                        .path("/orders")
                        .uri(orders))
                .route(p -> p
                        .path("/orders/*")
                        .uri(orders))
                .route(p -> p
                        .path("/category/*")
                        .uri(orders))
                .route(p -> p
                        .path("/category")
                        .uri(orders))
                .build();
    }
}

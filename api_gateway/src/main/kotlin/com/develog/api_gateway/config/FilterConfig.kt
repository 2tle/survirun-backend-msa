package com.develog.api_gateway.config

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {
    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder) = builder.routes {
        route("eureka-gui") {
            path("/eureka")
            filters {
                rewritePath("/eureka","/")
            }
            uri("lb://eureka-server")
        }
        route("auth-service") {
            path("/auth/**")
            uri("lb:http://auth-service")
        }
    }

}
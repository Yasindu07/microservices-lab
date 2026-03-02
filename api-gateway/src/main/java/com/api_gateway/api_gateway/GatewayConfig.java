package com.api_gateway.api_gateway;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayConfig {

	@Bean
	public RouterFunction<ServerResponse> itemServiceRoute() {
		return route("item-service")
				.route(RequestPredicates.path("/items/{*path}"), http())
				.before(uri("http://item-service:8081"))
				.build();
	}

	@Bean
	public RouterFunction<ServerResponse> orderServiceRoute() {
		return route("order-service")
				.route(RequestPredicates.path("/orders/{*path}"), http())
				.before(uri("http://order-service:8082"))
				.build();
	}

	@Bean
	public RouterFunction<ServerResponse> paymentServiceRoute() {
		return route("payment-service")
				.route(RequestPredicates.path("/payments/{*path}"), http())
				.before(uri("http://payment-service:8083"))
				.build();
	}
}

package com.google.shinyay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringCloudGatewayGsApplication {

	@Bean
	fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? = builder.routes()
			.route { r -> r.path("/search")
					.uri("https://www.google.co.jp") }
			.route { r -> r.path("/get")
					.filters { f -> f.addRequestHeader("Hello", "World") }
					.uri("http://httpbin.org") }
			.build()
}

fun main(args: Array<String>) {
	runApplication<SpringCloudGatewayGsApplication>(*args)
}

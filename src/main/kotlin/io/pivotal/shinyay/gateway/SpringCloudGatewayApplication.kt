package io.pivotal.shinyay.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringCloudGatewayApplication {

	@Bean
	fun routeLocator(builder: RouteLocatorBuilder): RouteLocator =
			builder.routes()
					.route { r ->
						r.path("/get")
								.filters { f -> f.addResponseHeader("Hello", "Gateway") }
								.uri("http://httpbin.org:80")
					}
					.build()
}

fun main(args: Array<String>) {
	runApplication<SpringCloudGatewayApplication>(*args)
}
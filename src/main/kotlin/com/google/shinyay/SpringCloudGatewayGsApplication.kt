package com.google.shinyay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import java.time.ZoneId
import java.time.ZonedDateTime

@SpringBootApplication
class SpringCloudGatewayGsApplication {

	@Bean
	fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? = builder.routes()
			.route { r -> r.path("/search")
					.uri("https://www.google.co.jp") }
			.route { r -> r.host("localhost:8080")
					.and()
					.before(ZonedDateTime.of(2020,7,1,0,0,0,0, ZoneId.systemDefault()))
					.and()
					.weight("group1", 5)
					.uri("https://www.google.com") }
			.route { r -> r.host("localhost:8080")
					.and()
					.weight("group1", 5)
					.uri("https://www.google.co.jp") }
			.route { r -> r.host("localhost:8080")
					.and()
					.path("/doodles")
					.and()
					.between(
							ZonedDateTime.of(2020,6,1,0,0,0,0, ZoneId.systemDefault()),
							ZonedDateTime.of(2020,6,30,0,0,0,0, ZoneId.systemDefault()))
					.uri("https://www.google.co.jp") }
			.route { r -> r.path("/get").and().method(HttpMethod.GET)
					.filters { f -> f.addRequestHeader("Hello", "World") }
					.uri("http://httpbin.org") }
			.build()
}

fun main(args: Array<String>) {
	runApplication<SpringCloudGatewayGsApplication>(*args)
}

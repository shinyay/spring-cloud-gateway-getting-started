package io.pivotal.shinyay.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudGatewayApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudGatewayApplication>(*args)
}

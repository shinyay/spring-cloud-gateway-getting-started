# Spring Cloud Gateway Getting Started

Spring Cloud Gateway is an intelligent proxy service, which ransparently centralizes requests in a single entry point and routes them to the proper service.

## Description

### Building Block for Gateway

|Name|Description|
|----|-----------|
|**Route**|Primary API of the Gateway<BR>Defined by followings<BR>- ID<BR>- Destination(URI)<BR>- Set of Predicates and Fileters|
|**Predicate**|HTTP Request Matching<BR>`Java 8 Function Predicate`<BR>Used for followings<BR>- Header <BR>- Method <BR>- Parameter|
|**Filter**|`Spring WebFilter`<BR>Modification of the incoming HTTP request or outgoing HTTP response|

### Route

The following description is a basic routing function. First of all we generate `RouteLocator` Bean which includes routing configuration.

```kotlin
@Bean
fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? = builder.routes()
        .route {  }
        .route {  }
        .build()
```

#### Destination (URI)

```kotlin
fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? = builder.routes()
			.route { r -> r.path("/search").uri("https://www.google.co.jp") }
			.build()
```

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)

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

### Predicate
**Predicate** lets you match on anything from the HTTP request, such as headers or parameters.

#### Method Route Predicate Factory

The following route matches if the request was a `GET`.

```kotlin
fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? = builder.routes()
        .route { r -> r.path("/get").and().method(HttpMethod.GET) }
        .build()
```

### Filter
**Filter** allows you to modify requests and responses before or after sending the downstream request.

#### AddRequestHeader GatewayFilter Factory

```kotlin
fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? = builder.routes()
        .route { r -> r.path("/get").and().method(HttpMethod.GET)
        .filters { f -> f.addRequestHeader("Hello", "World") }
		.uri("http://httpbin.org") }
```

### Route Predicate Factories
- After Route Predicate Factory
```yaml
predicates:
- After=2017-01-20T17:42:47.789-07:00[America/Denver]
```

- Before Route Predicate Factory
```yaml
predicates:
- Before=2017-01-20T17:42:47.789-07:00[America/Denver]
```

- Between Route Predicate Factory
```yaml
predicates:
- Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
```

- Cookie Route Predicate Factory
```yaml
predicates:
- Cookie=chocolate, ch.p
```

- Header Route Predicate Factory
```yaml
predicates:
- Header=X-Request-Id, \d+
```

- Host Route Predicate Factory
```yaml
predicates:
- Host=**.somehost.org,**.anotherhost.org
```

- Method Route Predicate Factory
```yaml
predicates:
- Method=GET
```

- Path Route Predicate Factory
```yaml
predicates:
- Path=/foo/{segment},/bar/{segment}
```

- Query Route Predicate Factory
```yaml
predicates:
- Query=baz
```

- RemoteAddr Route Predicate Factory
```yaml
predicates:
- RemoteAddr=192.168.1.1/24
```

- Weight Route Predicate Factory
```yaml
routes:
- id: weight_high
  uri: https://weighthigh.org
  predicates:
  - Weight=group1, 8
- id: weight_low
  uri: https://weightlow.org
  predicates:
  - Weight=group1, 2
```

### GatewayFilter Factory
- AddRequestHeader
- AddRequestParameter
- AddResponseHeader
- DedupeResponseHeader
- MapRequestHeade
- PrefixPath
- PreserveHostHeader
- RequestRateLimiter
- RedirectTo
- RemoveHopByHopHeadersFilter
- RemoveRequestHeader
- RemoveResponseHeade
- RemoveRequestParameter
- RewritePath
- RewriteLocationResponseHeader
- RewriteResponseHeader
- SaveSession
- SecureHeaders
- SetPath
- SetRequestHeader
- SetResponseHeader
- SetStatus
- StripPrefix
- Retry
- RequestSize
- Modify Request Body
- Modify Response Body

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

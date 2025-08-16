# Spring Annotations Demo

A minimal Spring Boot project demonstrating correct usage of common Spring annotations across configuration, components, web endpoints, validation, and AOP.

## What this shows

- Application and configuration
  - `@SpringBootApplication` on the entry point
  - `@ConfigurationProperties` with `@Validated` for typed, validated settings
  - `@Configuration` with a `@Bean` method
  - `@ConditionalOnProperty` to conditionally register a bean
- Components and DI
  - `@Component`, `@Service` for stereotype components
  - Constructor injection (preferred)
  - `@Primary` to select a default bean
  - `@Qualifier` to choose a specific bean implementation
- Web and validation
  - `@RestController`, `@RequestMapping`, `@GetMapping`
  - `@PathVariable`, `@RequestParam`
  - Jakarta `@NotBlank` with `@Validated` on the controller
- AOP
  - `@Aspect` with `@Before` and `@AfterReturning` advices

## Project structure

- Entry point: `src/main/java/com/example/annotationsdemo/AnnotationsDemoApplication.java`
- Config: `config/GreetingProperties.java`, `config/WebConfig.java`
- AOP: `aop/LoggingAspect.java`
- Service: `service/GreetingService.java`, `service/DefaultGreetingService.java`
- Strategy beans: `strategy/GreetingStrategy.java`, `strategy/DefaultGreetingStrategy.java`, `strategy/FormalGreetingStrategy.java`
- Web: `web/GreetingController.java`
- Properties: `src/main/resources/application.yml`

## Build and run

Requires Java 17+. If Maven is available:

```bash
mvn spring-boot:run
```

Or package and run the JAR:

```bash
mvn -DskipTests package
java -jar target/spring-annotations-demo-0.0.1-SNAPSHOT.jar
```

## Try it

- GET `/api/greet/{name}`
- GET `/api/greet?name=YourName`

Example:

```bash
curl http://localhost:8080/api/greet/Alice
```

## Configuration

```yaml
app:
  greeting:
    message: "Hello"
    suffix: "!"
    uppercase: false
```

- Toggle uppercase strategy: set `app.greeting.uppercase=true` to enable the conditional bean in `WebConfig`.
- `GreetingProperties` is validated (`@NotBlank` on `message`).
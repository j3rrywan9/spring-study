# Spring Testing

## Testing with JUnit 4

A `Test` class contains the JUnit tests.
These are methods and are only used for testing.
A test method needs to be annotated with `@org.junit.Test` annotation.
In this test method, you use a method provided by the JUnit framework to check the actual result versus the expected
result of the code execution.

In order to use the Spring's JUnit class runner for running the test cases within the Spring's `ApplicationContext`
environment, passed Spring's `SpringJUnit4ClassRunner` class as parameter.

We will use the `MockMvc` that will mock the entire Spring MVC infrastructure.
We will create a `MockMvc` instance in the method annotated by the `@Before` annotation, so that it will be available
before the test starts.

## Transactional management

```java
@Transactional

@DirtiesContext
```

## Introduction to Spring Testing

Testing is an integral part of enterprise software development.
This chapter focuses on the value-add of the IoC principle to unit testing and on the benefits of the Spring Framework's support for integration testing.

## Unit Testing

Dependency Injection should make your code less dependent on the container than it would be with traditional Java EE development.
The POJOs that make up your application should be testable in JUnit or TestNG tests, with objects simply instantiated using the `new` operator, without Spring or any other container.
You can use mock objects (in conjunction with other valuable testing techniques) to test your code in isolation.
If you follow the architecture recommendations for Spring, the resulting clean layering and componentization of your codebase will facilitate easier unit testing.

## Integration Testing

### Overview

It is important to be able to perform some integration testing without requiring deployment to your application server or connecting to other enterprise infrastructure.
This will enable you to test things such as:
* The correct wiring of your Spring IoC container contexts.
* Data access using JDBC or an ORM tool.
This would include such things as the correctness of SQL statements, Hibernate queries, JPA entity mappings, etc.

The Spring Framework provides first-class support for integration testing in the `spring-test` module.

In Spring 2.5 and later, unit and integration testing support is provided in the form of the annotation-driven Spring TestContext Framework.
The TestContext framework is agnostic of the actual testing framework in use, thus allowing instrumentation of tests in various environments including JUnit, TestNG, and so on.

### Annotations

#### Spring Testing Annotations

##### `@WebAppConfiguration`

`@WebAppConfiguration` is a class-level annotation that is used to declare that the `ApplicationContext` loaded for an integration test should be a `WebApplicationContext`.

##### `@ActiveProfiles`

`@ActiveProfiles` is a class-level annotation that is used to declare which bean definition profiles should be active when loading an `ApplicationContext` for an integration test.

## References

[Testing](https://docs.spring.io/spring/docs/5.0.5.RELEASE/spring-framework-reference/testing.html)

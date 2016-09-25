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

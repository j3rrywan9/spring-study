# Spring Boot

```bash
brew tap pivotal/top

brew install springboot
```

It offers four main features that will change the way you develop Spring applications:
* **Spring Boot starters** - Spring Boot starters aggregate common groupings of dependencies into single dependencies that can be added to a project's Maven or Gradle build.
* **Autoconfiguration** - Spring Boot's autoconfiguration feature leverages Spring 4's support for conditional configuration to make reasonable guesses about the beans your application needs and automatically configure them.
* **CLI** - Spring Boot's CLI takes advantage of the Groovy programming language along with autoconfiguration to further simplify Spring application development.
* **Actuator** - The Spring Boot Actuator adds certain management features to a Spring Boot application.

## System Requirements

By default, Spring Boot 1.5.1.RELEASE requires Java 7 and Spring Framework 4.3.6.RELEASE or above.

## Installing Spring Boot

Spring Boot can be used with “classic” Java development tools or installed as a command line tool.

### Maven installation

Spring Boot dependencies use the `org.springframework.boot` groupId.
Typically your Maven POM file will inherit from the `spring-boot-starter-parent` project and declare dependencies to one or more “Starters”.
Spring Boot also provides an optional Maven plugin to create executable jars.

## Developing your first Spring Boot application

### Creating the POM

We need to start by creating a Maven `pom.xml` file.

#### The `@RestController` and `@RequestMapping` annotations

The first annotation on our Example class is `@RestController`.
This is known as a stereotype annotation.
It provides hints for people reading the code, and for Spring, that the class plays a specific role.
In this case, our class is a web `@Controller` so Spring will consider it when handling incoming web requests.

The `@RequestMapping` annotation provides “routing” information.
It is telling Spring that any HTTP request with the path “/” should be mapped to the home method.
The `@RestController` annotation tells Spring to render the resulting string directly back to the caller.

#### The `@EnableAutoConfiguration` annotation

The second class-level annotation is `@EnableAutoConfiguration`.
This annotation tells Spring Boot to “guess” how you will want to configure Spring, based on the jar dependencies that you have added.
Since `spring-boot-starter-web` added Tomcat and Spring MVC, the auto-configuration will assume that you are developing a web application and setup Spring accordingly.

### Creating an executable jar

Let’s finish our example by creating a completely self-contained executable jar file that we could run in production.
Executable jars (sometimes called “fat jars”) are archives containing your compiled classes along with all of the jar dependencies that your code needs to run.

To create an executable jar we need to add the `spring-boot-maven-plugin` to our `pom.xml`.

The spring-boot-starter-parent POM includes `<executions>` configuration to bind the `repackage` goal.
If you are not using the parent POM you will need to declare this configuration yourself.

## Build systems

It is strongly recommended that you choose a build system that supports dependency management, and one that can consume artifacts published to the “Maven Central” repository.
We would recommend that you choose Maven or Gradle. 

### Dependency management

### Maven

Maven users can inherit from the `spring-boot-starter-parent` project to obtain sensible defaults.

### Gradle

### Starters

Starters are a set of convenient dependency descriptors that you can include in your application.
You get a one-stop-shop for all the Spring and related technology that you need, without having to hunt through sample code and copy paste loads of dependency descriptors.

The starters contain a lot of the dependencies that you need to get a project up and running quickly and with a consistent, supported set of managed transitive dependencies.

All **official** starters follow a similar naming pattern; `spring-boot-starter-*`, where `*` is a particular type of application.
This naming structure is intended to help when you need to find a starter.
The Maven integration in many IDEs allow you to search dependencies by name.

The following application starters are provided by Spring Boot under the `org.springframework.boot` group:

| Name | Description | Pom |
| --- | --- | --- |
| spring-boot-starter-web | Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container | Pom |
| spring-boot-starter-data-jpa | Starter for using Spring Data JPA with Hibernate | Pom |

Finally, Spring Boot also includes some starters that can be used if you want to exclude or swap specific technical facets:

| Name | Description | Pom |
| --- | --- | --- |
| spring-boot-starter-jetty | Starter for using Jetty as the embedded servlet container. An alternative to `spring-boot-starter-tomcat` | Pom |

## Structuring your code

Spring Boot does not require any specific code layout to work, however, there are some best practices that help.

### Using the "default" package

When a class doesn’t include a package declaration it is considered to be in the “default package”.
The use of the “default package” is generally discouraged, and should be avoided.
It can cause particular problems for Spring Boot applications that use `@ComponentScan`, `@EntityScan` or `@SpringBootApplication` annotations, since every class from every jar, will be read.

### Locating the main application class

We generally recommend that you locate your main application class in a root package above other classes.
The `@EnableAutoConfiguration` annotation is often placed on your main class, and it implicitly defines a base “search package” for certain items.

Using a root package also allows the `@ComponentScan` annotation to be used without needing to specify a basePackage attribute.
You can also use the `@SpringBootApplication` annotation if your main class is in the root package.

## Configuration classes

Spring Boot favors Java-based configuration.
Although it is possible to call `SpringApplication.run()` with an XML source, we generally recommend that your primary source is a `@Configuration` class.
Usually the class that defines the main method is also a good candidate as the primary `@Configuration`.

## Auto-configuration

Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added.

You need to opt-in to auto-configuration by adding the `@EnableAutoConfiguration` or `@SpringBootApplication` annotations to one of your `@Configuration` classes.

### Gradually replacing auto-configuration

Auto-configuration is noninvasive, at any point you can start to define your own configuration to replace specific parts of the auto-configuration.

### Disabling specific auto-configuration

If you find that specific auto-configure classes are being applied that you don’t want, you can use the exclude attribute of `@EnableAutoConfiguration` to disable them.

## Spring Beans and dependency injection

You are free to use any of the standard Spring Framework techniques to define your beans and their injected dependencies.
For simplicity, we often find that using `@ComponentScan` to find your beans, in combination with `@Autowired` constructor injection works well.

## Using the `@SpringBootApplication` annotation

Many Spring Boot developers always have their main class annotated with `@Configuration`, `@EnableAutoConfiguration` and `@ComponentScan`.
Since these annotations are so frequently used together (especially if you follow the best practices above), Spring Boot provides a convenient `@SpringBootApplication` alternative.

The `@SpringBootApplication` annotation is equivalent to using `@Configuration`, `@EnableAutoConfiguration` and `@ComponentScan` with their default attributes.

## Running your application

## Developer tools

## SpringApplication

The `SpringApplication` class provides a convenient way to bootstrap a Spring application that will be started from a `main()` method.
In many situations you can just delegate to the static `SpringApplication.run` method:
```java
public static void main(String[] args) {
  SpringApplication.run(MySpringConfiguration.class, args);
}
```

### Startup failure

### Customizing the banner

### Customizing SpringApplication

If the `SpringApplication` defaults aren’t to your taste you can instead create a local instance and customize it.

It is also possible to configure the `SpringApplication` using an `application.properties` file.

For a complete list of the configuration options, see the `SpringApplication` Javadoc.

### Fluent builder API

### Application events and listeners

### Web environment

A `SpringApplication` will attempt to create the right type of `ApplicationContext` on your behalf.
By default, an `AnnotationConfigApplicationContext` or `AnnotationConfigEmbeddedWebApplicationContext` will be used, depending on whether you are developing a web application or not.

### Accessing application arguments

### Using the ApplicationRunner or CommandLineRunner

### Application exit

### Admin features

## Externalized Configuration

Spring Boot allows you to externalize your configuration so you can work with the same application code in different environments.
You can use properties files, YAML files, environment variables and command-line arguments to externalize configuration.
Property values can be injected directly into your beans using the `@Value` annotation, accessed via Spring’s `Environment` abstraction or bound to structured objects via `@ConfigurationProperties`.

Spring Boot uses a very particular `PropertySource` order that is designed to allow sensible overriding of values.

### Configuring random values

## Profiles

Spring Profiles provide a way to segregate parts of your application configuration and make it only available in certain environments.

### Adding active profiles

## Logging

Spring Boot uses Commons Logging for all internal logging, but leaves the underlying log implementation open.
Default configurations are provided for Java Util Logging, Log4J2 and Logback.
In each case loggers are pre-configured to use console output with optional file output also available.

By default, If you use the ‘Starters’, Logback will be used for logging.
Appropriate Logback routing is also included to ensure that dependent libraries that use Java Util Logging, Commons Logging, Log4J or SLF4J will all work correctly.

### Log format

### Console output

The default log configuration will echo messages to the console as they are written.
By default `ERROR`, `WARN` and `INFO` level messages are logged.
You can also enable a “debug” mode by starting your application with a `--debug` flag.

Alternatively, you can enable a “trace” mode by starting your application with a `--trace` flag (or `trace=true` in your `application.properties`).
This will enable trace logging for a selection of core loggers (embedded container, Hibernate schema generation and the whole Spring portfolio).

### Color-coded output

If your terminal supports ANSI, color output will be used to aid readability.

### File output

By default, Spring Boot will only log to the console and will not write log files.
If you want to write log files in addition to the console output you need to set a `logging.file` or `logging.path` property (for example in your `application.properties`).

### Log levels

All the supported logging systems can have the logger levels set in the Spring `Environment` (so for example in `application.properties`) using ‘logging.level.*=LEVEL’ where ‘LEVEL’ is one of TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF.
The `root` logger can be configured using `logging.level.root`.

### Custom log configuration

The various logging systems can be activated by including the appropriate libraries on the classpath, and further customized by providing a suitable configuration file in the root of the classpath, or in a location specified by the Spring Environment property `logging.config`.

You can force Spring Boot to use a particular logging system using the `org.springframework.boot.logging.LoggingSystem` system property.
The value should be the fully-qualified class name of a `LoggingSystem` implementation.
You can also disable Spring Boot’s logging configuration entirely by using a value of `none`.

Depending on your logging system, the following files will be loaded:

### Logback extensions

Spring Boot includes a number of extensions to Logback which can help with advanced configuration.
You can use these extensions in your `logback-spring.xml` configuration file.

## Developing web applications

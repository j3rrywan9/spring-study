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

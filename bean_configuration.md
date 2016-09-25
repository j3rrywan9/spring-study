# Bean Configuration

## Java-based Configuration

```java
@Configuration
```
Indicates that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate
bean definitions and service requests for those beans at runtime, for example:
```java
@Configuration
public class AppConfig {

  @Bean
  public MyBean myBean() {
    // instantiate, configure and return bean ...
  }
}
```

## Annotation Configuration

```java
@Autowired
```
`@Autowired` means "autowire by type" first.
This works if there is exactly one bean of that type (class) available.

```java
@Qualifier
```
This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring.

```java
@ComponentScan
```
Configures component scanning directives for use with `@Configuration` classes.

```java
@Component
```
Indicates that an annotated class is a "component".
Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath
scanning.

```java
@Service
```
Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design as "an operation offered as
an interface that stands alone in the model, with no encapsulated state".

This annotation serves as a specialization of `@Component`, allowing for implementation classes to be autodetected
through classpath scanning.

## XML-based Configuration

The bean configuration information is stored in an XML file, which is used to create a bean definition using the
`<bean>..</bean>` element.
The bean definition contains the following metadata, which represents the configuration information of a bean:
* A fully qualified class name that represents bean name
* The behavioral configuration elements, such as scope, lifecycle, and so on, describes the bean's behavior in the
Spring IoC container.

The configuration file have `<beans>` as the root element.
The beans element has all other individual beans configured using the `<bean>` tag.
Every `<bean>` tag needs to specify a class attribute and can have an optional ID or name attribute.
The ID attributes enforce uniqueness in naming the beans.
The class attribute has the fully classified class name.

Spring provides the following two interfaces that act containers:
* BeanFactory: This is a basic container, and all other containers implement `BeanFactory`.
* ApplicationContext: This refers to the subinterface of `BeanFactory` and is mostly used as a container in enterprise
applications.

To instantiate Spring Container, create an object of any of the `BeanFactory` or `ApplicationContext` implementation
classes that supply the Spring bean configuration.
The basic packages in the Spring IoC container of the Spring Framework are `org.springframework.beans` and
`org.springframework.context`. An advanced configuration mechanism is provided by the `BeanFactory` interface to manage
any type of object.

# Bean Configuration

## Java-based Configuration


### `@Configuration`

Indicates that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, for example:
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

### `@Autowired`

Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.

`@Autowired` means "autowire by type" first.
This works if there is exactly one bean of that type (class) available.

### `@Qualifier`

This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring.

### `@ComponentScan`

Configures component scanning directives for use with `@Configuration` classes.

### `@Component`

Indicates that an annotated class is a "component".
Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

### `@Service`

Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design as "an operation offered as an interface that stands alone in the model, with no encapsulated state".

This annotation serves as a specialization of `@Component`, allowing for implementation classes to be autodetected through classpath scanning.

## XML-based Configuration

The bean configuration information is stored in an XML file, which is used to create a bean definition using the `<bean>..</bean>` element.
The bean definition contains the following metadata, which represents the configuration information of a bean:
* A fully qualified class name that represents bean name
* The behavioral configuration elements, such as scope, lifecycle, and so on, describes the bean's behavior in the Spring IoC container.

The configuration file have `<beans>` as the root element.
The beans element has all other individual beans configured using the `<bean>` tag.
Every `<bean>` tag needs to specify a class attribute and can have an optional ID or name attribute.
The ID attributes enforce uniqueness in naming the beans.
The class attribute has the fully classified class name.

Spring provides the following two interfaces that act containers:
* BeanFactory: This is a basic container, and all other containers implement `BeanFactory`.
* ApplicationContext: This refers to the subinterface of `BeanFactory` and is mostly used as a container in enterprise applications.

To instantiate Spring Container, create an object of any of the `BeanFactory` or `ApplicationContext` implementation classes that supply the Spring bean configuration.
The basic packages in the Spring IoC container of the Spring Framework are `org.springframework.beans` and `org.springframework.context`. An advanced configuration mechanism is provided by the `BeanFactory` interface to manage any type of object.

## API

### Class AbstractBeanFactory

```java
public abstract class AbstractBeanFactory
extends FactoryBeanRegistrySupport
implements ConfigurableBeanFactory
```
Abstract base class for `BeanFactory` implementations, providing the full capabilities of the `ConfigurableBeanFactory` SPI.
Does *not* assume a listable bean factory: can therefore also be used as base class for bean factory implementations which obtain bean definitions from some backend resource (where bean definition access is an expensive operation).

```java
BeanFactory getParentBeanFactory()
```
Return the parent bean factory, or `null` if there is none.

### Class DefaultListableBeanFactory

```java
Class DefaultListableBeanFactory
extends AbstractAutowireCapableBeanFactory
implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable
```
Default implementation of the `ListableBeanFactory` and `BeanDefinitionRegistry` interfaces: a full-fledged bean factory based on bean definition objects.

Typical usage is registering all bean definitions first (possibly read from a bean definition file), before accessing beans.
Bean definition lookup is therefore an inexpensive operation in a local bean definition table, operating on pre-built bean definition metadata objects.

Can be used as a standalone bean factory, or as a superclass for custom bean factories.

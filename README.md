# Learning Spring Framework

## Inversion of Control

IoC is a programming technique in which object coupling is bound at runtime by an assembler object and is usually not
known at compile time using static analysis.

IoC is a more general concept, whereas DI is a concrete design pattern.

IoC is a way of thinking; a mechanism is required to activate components that provide specific functionality, due to
which IoC depends on DI.
The IoC pattern inverts responsibility of the managing the lifecycle from the application to the framework, which makes
writing Java application even easier.

The container first creates the objects and then wires them together, after which it moves on to configure them, and
finally manage their complete lifecycle.
It identifies the object dependencies, creates them, and then injects them into the appropriate objects.

### Spring Container

Sprint Container is the central component of the Spring Framework.
Spring Container manages the lifecycle of an application's bean, which will live within Spring Container.
Spring Container is responsible for wiring an application's beans by associating different beans together.
Spring Container manages the components of applications using DI.
The configuration metadata, which can be represented in XML, Java annotations, or Java code, help Spring Container to
decide the object to initiate, configure, and assemble.

Spring Container is a container of beans and behaves as a factory of beans.

### Beans

Beans are reusable software components that are managed by the Spring IoC container.
It contains the properties, setter, and getter methods of a class.

The Spring IoC container is represented by the interface `org.springframework.context.ApplicationContext`, which is
responsible for instantiating, configuring, and assembling beans.
Beans are reflected in the configuration metadata used by a container.
The configuration metadata defines the instruction for the container and the objects to instantiate, configure, and
assemble.

### XML-based been configuration

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

### BeanFactory

This factory reads from a configuration file, which acts as a blueprint that contains guidelines on how we can create
the object.

### Spring BeanFactory

Spring has objects of the `BeanFactory` type that behave like the factory object.
You specify the blueprints object in a configuration file, which is an XML file, and then supply it to `BeanFactory`.
Later, if you need the instance of any object, you can ask `BeanFactory` for it, which then refers to the XML file and
constructs the bean as specified.
This bean is now a Spring bean as it has been created by Spring Container and is returned to you.

### ApplicationContext

The `org.springframework.context.ApplicationContext` interface defines `ApplicationContext`.

#### Implementation of ApplicationContext

The most commonly used `ApplicationContext` implementations are as follows:
* `ClassPathXmlApplicationContext`: This bean definition is loaded by the container from the XML file that is present in
the classpath by treating context definition as classpath resources.
`ApplicationContext` can be loaded from within the application's classpath using `ClassPathXmlApplicationContext`:
```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
```

## Dependency Injection

**Dependency Injection (DI)** is a design pattern in which an object's dependency is injected by the framework rather
than by the object itself.
It reduces coupling between multiple objects as it is dynamically injected by the framework.
In DI, the framework is completely responsible for reading configuration.

In the Spring Framework, DI is used to satisfy the dependencies between objects.
It exits in only two types:
* Constructor Injection: By invoking a constructor containing a number of arguments, constructor-based DI can be
accomplished.
These arguments are injected at the time of instance instantiation.
* Setter Injection: Setter-based DI is attained by calling setter methods on your beans.
Using setter methods defined in a Spring configuration file, the dependencies are "set" in the objects.

### Constructor-based Dependency Injection

Constructor Injection is the process of injecting the dependencies of an object through its constructor argument at the
time of instantiating it.
In other words, we can say that dependencies are supplied as an object through the object's own constructor.
The bean definition can use a constructor with zero of more arguments to initiate the bean.

### The setter-based Dependency Injection

The setter-based DI is the method of injecting the dependencies of an object using the setter method.
In the setter injection, the Spring container uses `setXXX()` of the Spring bean class to assign a dependent variable to
the bean property from the bean configuration file.
The setter method is more convenient to inject more dependencies since a large number of constructor arguments makes it
awkward.

## Autowiring in Spring

Autowiring is a feature provided by the Spring Framework that helps use reduce some of these configurations by
intelligently guessing what the reference is.

Spring wires a bean's properties automatically by setting the `autowire` propery on each `<bean>` tag that you want to
autowire.
By default, autowiring is disabled.
To enable it, specify the method of autowiring you want to apply using the `autowire` attribute of the bean you want to
autowire, as shown here:
```
<bean id="foo" class="Foo" autowire="autowire-type" />
```

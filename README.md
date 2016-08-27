# Learning Spring Framework

## Inversion of Control

IoC is a programming technique in which object coupling is bound at runtime by an assembler object and is usually not
known at compile time using static analysis.

It is a process whereby objects define their dependencies, that is, the other objects they work with, only through
constructor arguments, arguments to a factory method, or properties that set on the object instance after it is
constructed or returned from a factory method.
The container then *injects* those dependencies when it creates the bean.
This process is fundamentally the inverse, hence the name *Inversion of Control* (IoC), of the bean itself controlling
the instantiation or location of its dependencies by using construction of classes, or a mechanism such as the *Service
Locator* pattern.

IoC is a more general concept, whereas DI is a concrete design pattern.

IoC is a way of thinking; a mechanism is required to activate components that provide specific functionality, due to
which IoC depends on DI.
The IoC pattern inverts responsibility of the managing the lifecycle from the application to the framework, which makes
writing Java application even easier.

### Spring Container

The container first creates the objects and then wires them together, after which it moves on to configure them, and
finally manage their complete lifecycle.

In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are
called *beans*.
A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
Beans, and the *dependencies* among them, are reflected in the *configuration metadata* used by a container.

The interface `org.springframework.context.ApplicationContext` represents the Spring IoC container and is responsible
for instantiating, configuring, and assembling the aforementioned beans.
The configuration metadata is represented in XML, Java annotations, or Java code.
It allows you to express the objects that compose your application and the rich interdependencies between such objects.

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

### Bean configuration

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

The Spring bean XML configuration tag `<constructor-arg>` is used for Constructor Injection.

### The setter-based Dependency Injection

The setter-based DI is the method of injecting the dependencies of an object using the setter method.
In the setter injection, the Spring container uses `setXXX()` of the Spring bean class to assign a dependent variable to
the bean property from the bean configuration file.
The setter method is more convenient to inject more dependencies since a large number of constructor arguments makes it
awkward.

The Spring bean XML configuration tag `<property>` is used to configure properties.

| Attribute | Description | Occurrence |
| --------- | ----------- | ---------- |
| name | It takes the name of Java bean-based property | Optional |
| value | | |
| ref | It refers to a bean | |

## Autowiring in Spring

Autowiring is a feature provided by the Spring Framework that helps use reduce some of these configurations by
intelligently guessing what the reference is.

The Spring container can autowire relationships between collaborating beans without using the `<constructor-arg>` and
`<property>` elements.
Spring wires a bean's properties automatically by setting the `autowire` property on each `<bean>` tag that you want to
autowire.
By default, autowiring is disabled.
To enable it, specify the method of autowiring you want to apply using the `autowire` attribute of the bean you want to
autowire, as shown here:
```
<bean id="foo" class="Foo" autowire="autowire-type" />
```

### Autowiring modes

There are 5 modes of autowiring that Spring Container can use for autowiring.

#### Autowiring

#### Autowiring using the byType option

Autowiring using `byType` enables DI based on property data types.

## The bean's scope

When we start Spring Container, `ApplicationContext` reads the Spring configuration file, looks for all bean definition
available there, and then initializes beans before any call to the `getBean()` method.

During initialization, `ApplicationContext` itself has initialized all the Spring beans configured in Spring XML.
When another object makes a call to the `getBean()` method, `ApplicationContext` returns the same reference of bean that
has already been initialized.
This is the default behavior of beans.

This leads to the concept of a bean's scope.
We can choose the number of instances of beans depending on the scope.
There are different scopes in which a bean can be configured.
The `<bean>` tag has a `scope` attribute that is used to configure the scope of the bean.

`xmlns` - XML namespace
`xmlns:xsi`
`xsl:schemaLocation`

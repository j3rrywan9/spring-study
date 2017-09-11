# Spring Web MVC framework

## Introduction to Spring Web MVC framework

The Spring Web model-view-controller (MVC) framework is designed around a `DispatcherServlet` that dispatches requests to handlers, with configurable handler mappings, view resolution, locale, time zone and theme resolution as well as support for uploading files.
The default handler is based on the `@Controller` and `@RequestMapping` annotations, offering a wide range of flexible handling methods.
With the introduction of Spring 3.0, the `@Controller` mechanism also allows you to create RESTful Web sites and applications, through the `@PathVariable` annotation and other features.

## The DispatcherServlet

Spring’s web MVC framework is, like many other web MVC frameworks, request-driven, designed around a central Servlet that dispatches requests to controllers and offers other functionality that facilitates the development of web applications.
Spring’s DispatcherServlet however, does more than just that.
It is completely integrated with the Spring IoC container and as such allows you to use every other feature that Spring has.

The request processing workflow of the Spring Web MVC `DispatcherServelt` is illustrated in the following diagram.
The pattern-savvy reader will recognize that the `DispatcherServlet` is an expression of the "Front Controller" design pattern (this is a pattern that Spring Web MVC shares with many other leading web frameworks).

<img src="./images/mvc.jpg" width="800px"> 

The `DispatcherServlet` is an actual Servlet (it inherits from the `HttpServlet` base class), and as such is declared in your web application.
You need to map requests that you want the `DispatcherServlet` to handle, by using a URL mapping.

`WebApplicationInitializer` is an interface provided by Spring MVC that ensures your code-based configuration is detected and automatically used to initialize any Servlet 3 container.
An abstract base class implementation of this interface named `AbstractAnnotationConfigDispatcherServletInitializer` makes it even easier to register the `DispatcherServlet` by simply specifying its servlet mapping and listing configuration classes - it’s even the recommended way to set up your Spring MVC application.

```java
public abstract class AbstractAnnotationConfigDispatcherServletInitializer
extends AbstractDispatcherServletInitializer
```
Base class for `WebApplicationInitializer` implementations that register a `DispatcherServlet` configured with annotated classes, e.g. Spring's `@Configuration` classes.

Concrete implementations are required to implement `getRootConfigClasses()` and `getServletConfigClasses()` as well as `AbstractDispatcherServletInitializer.getServletMappings()`.
Further template and customization methods are provided by `AbstractDispatcherServletInitializer`.

This is the preferred approach for applications that use Java-based Spring configuration.

```java
protected abstract Class<?>[] getRootConfigClasses()
```

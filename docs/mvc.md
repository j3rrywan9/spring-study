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

<img src="./images/mvc.png" width="800px">

The `DispatcherServlet` is an actual Servlet (it inherits from the `HttpServlet` base class), and as such is declared in your web application.
You need to map requests that you want the `DispatcherServlet` to handle, by using a URL mapping.

`WebApplicationInitializer` is an interface provided by Spring MVC that ensures your code-based configuration is detected and automatically used to initialize any Servlet 3 container.
An abstract base class implementation of this interface named `AbstractAnnotationConfigDispatcherServletInitializer` makes it even easier to register the `DispatcherServlet` by simply specifying its servlet mapping and listing configuration classes - it’s even the recommended way to set up your Spring MVC application.

## Code-based Servlet container initialization

In a Servlet 3.0+ environment, you have the option of configuring the Servlet container programmatically as an alternative or in combination with a `web.xml` file.

`WebApplicationInitializer` is an interface provided by Spring MVC that ensures your implementation is detected and automatically used to initialize any Servlet 3 container.
An abstract base class implementation of `WebApplicationInitializer` named `AbstractDispatcherServletInitializer` makes it even easier to register the `DispatcherServlet` by simply overriding methods to specify the servlet mapping and the location of the `DispatcherServlet` configuration.

Concrete implementations are required to implement `getRootConfigClasses()` and `getServletConfigClasses()` as well as `AbstractDispatcherServletInitializer.getServletMappings()`.
Further template and customization methods are provided by `AbstractDispatcherServletInitializer`.

This is the preferred approach for applications that use Java-based Spring configuration.

```java
public abstract class AbstractDispatcherServletInitializer
extends AbstractContextLoaderInitializer
```
Base class for `WebApplicationInitializer` implementations that register a `DispatcherServlet` in the servlet context.

Concrete implementations are required to implement `createServletApplicationContext()`, as well as `getServletMappings()`, both of which get invoked from `registerDispatcherServlet(ServletContext)`.

```java
protected abstract WebApplicationContext createServletApplicationContext()
```
Create a `DispatcherServlet` (or other kind of `FrameworkServlet`-derived dispatcher) with the specified `WebApplicationContext`.

```java
public abstract class AbstractAnnotationConfigDispatcherServletInitializer
extends AbstractDispatcherServletInitializer
```
Base class for `WebApplicationInitializer` implementations that register a `DispatcherServlet` configured with annotated classes, e.g. Spring's `@Configuration` classes.

```java
@Override
protected WebApplicationContext createServletApplicationContext() {
  AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
  Class<?>[] configClasses = getServletConfigClasses();
  if (!ObjectUtils.isEmpty(configClasses)) {
    servletAppContext.register(configClasses);
  }
  return servletAppContext;
}
```

```java
protected abstract Class<?>[] getRootConfigClasses()
```
Specify `@Configuration` and/or `@Component` classes to be provided to the root application context.

```java
protected abstract Class<?>[]	getServletConfigClasses()
```
Specify `@Configuration` and/or `@Component` classes to be provided to the dispatcher servlet application context.

```java
protected abstract String[]	getServletMappings()
```
Specify the servlet mapping(s) for the `DispatcherServlet` — for example "/", "/app", etc.

If using XML-based Spring configuration, you should extend directly from `AbstractDispatcherServletInitializer`.

## Implementing Controllers

Controllers provide access to the application behavior that you typically define through a service interface.
Controllers interpret user input and transform it into a model that is represented to the user by the view.
Spring implements a controller in a very abstract way, which enables you to create a wide variety of controllers.

Spring 2.5 introduced an annotation-based programming model for MVC controllers that uses annotations such as `@RequestMapping`, `@RequestParam`, `@ModelAttribute`, and so on.

### Defining a controller with `@Controller`

The `@Controller` annotation indicates that a particular class serves the role of a controller.
Spring does not require you to extend any controller base class or reference the Servlet API.
However, you can still reference Servlet-specific features if you need to.

### Mapping Requests With `@RequestMapping`

You use the `@RequestMapping` annotation to map URLs onto an entire class or a particular handler method.
Typically the class-level annotation maps a specific request path (or path pattern) onto a form controller, with additional method-level annotations narrowing the primary mapping for a specific HTTP method request method ("GET", "POST", etc.) or an HTTP request parameter condition.

### Defining `@RequestMapping` handler methods

`@RequestMapping` handler methods can have very flexible signatures.
The supported method arguments and return values are described in the following section.
Most arguments can be used in arbitrary order with the only exception being `BindingResult` arguments.

#### Supported method argument types

* `java.util.Map` / `org.springframework.ui.Model` / `org.springframework.ui.ModelMap` for enriching the implicit model that is exposed to the web view.

#### Supported method return types

The following are the supported return types:
* A ModelAndView object, with the model implicitly enriched with command objects and the results of @ModelAttribute annotated reference data accessor methods.
* A Model object, with the view name implicitly determined through a RequestToViewNameTranslator and the model implicitly enriched with command objects and the results of @ModelAttribute annotated reference data accessor methods.
* A Map object for exposing a model, with the view name implicitly determined through a RequestToViewNameTranslator and the model implicitly enriched with command objects and the results of @ModelAttribute annotated reference data accessor methods.
* A View object, with the model implicitly determined through command objects and @ModelAttribute annotated reference data accessor methods. The handler method may also programmatically enrich the model by declaring a Model argument (see above).
* A `String` value that is interpreted as the logical view name, with the model implicitly determined through command objects and `@ModelAttribute` annotated reference data accessor methods.
The handler method may also programmatically enrich the model by declaring a `Model` argument (see above).

## Configuring Spring MVC

The MVC Java config and the MVC namespace provide similar default configuration that overrides the `DispatcherServlet` defaults.
The goal is to spare most applications from having to create the same configuration and also to provide higher-level constructs for configuring Spring MVC that serve as a simple starting point and require little or no prior knowledge of the underlying configuration.

To enable MVC Java config add the annotation `@EnableWebMvc` to one of your `@Configuration` classes:
```java
@Configuration
@EnableWebMvc
public class WebConfig {

}
```

## Resolving views

All MVC frameworks for web applications provide a way to address views.
Spring provides view resolvers, which enable you to render models in a browser without tying you to a specific view technology.
Out of the box, Spring enables you to use JSPs, Velocity templates and XSLT views, for example.

The two interfaces that are important to the way Spring handles views are `ViewResolver` and `View`.
The `ViewResolver` provides a mapping between view names and actual views.
The `View` interface addresses the preparation of the request and hands the request over to one of the view technologies.

### Resolving views with the ViewResolver interface

All handler methods in the Spring Web MVC controllers must resolve to a logical view name, either explicitly (e.g., by returning a `String`, `View`, or `ModelAndView`) or implicitly (i.e., based on conventions).
Views in Spring are addressed by a logical view name and are resolved by a view resolver.
Spring comes with quite a few view resolvers.

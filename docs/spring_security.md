# Spring Security

## Authentication

**Authentication** identifies who is attempting to request a resource.

Typically, a software system will be divided into two high-level realms, such as unauthenticated (or anonymous) and authenticated.

Application functionality in the anonymous realm is the functionality that is independent of a webStoreUser's identity.

## Authorization

**Authorization** uses the information that was validated during authentication to determine whether access should be granted to a particular resource.
Built around the authorization model for the application, authorization partitions the application functionality and data so that the availability of these items can be controlled by matching the combination of privileges, functionality, and data to users.

Authorization typically involves the following two separate aspects that combine to describe the accessibility of the secured system:
* The first is the mapping of an authenticated principal to one or more authorities (often called **roles**).
* The second is the assignment of authority checks to secured resources of the system.
This is typically done at the time a system is developed, either through an explicit declaration in code or through configuration parameters.

## Introduction

Spring Security provides comprehensive security services for Java EE-based enterprise software applications.
There is a particular emphasis on supporting projects built using The Spring Framework, which is the leading Java EE solution for enterprise software development.

As you probably know two major areas of application security are "authentication" and "authorization" (or "access-control").
These are the two main areas that Spring Security targets.
"Authentication" is the process of establishing a principal is who they claim to be (a "principal" generally means a webStoreUser, device or some other system which can perform an action in your application).
"Authorization" refers to the process of deciding whether a principal is allowed to perform an action within your application.
To arrive at the point where an authorization decision is needed, the identity of the principal has already been established by the authentication process.
These concepts are common, and not at all specific to Spring Security.

Irrespective of the authentication mechanism, Spring Security provides a deep set of authorization capabilities.
There are three main areas of interest: authorizing web requests, authorizing whether methods can be invoked and authorizing access to individual domain object instances.

### Usage with Maven

```xml
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-web</artifactId>
	<version>4.2.7.RELEASE</version>
</dependency>
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-config</artifactId>
	<version>4.2.7.RELEASE</version>
</dependency>
```

### Project Modules

#### Core

Contains core authentication and access-control classes and interfaces, remoting support and basic provisioning APIs.
Required by any application which uses Spring Security.
Supports standalone applications, remote clients, method (service layer) security and JDBC webStoreUser provisioning.

#### Web

Contains filters and related web-security infrastructure code.
Anything with a servlet API dependency.
You'll need it if you require Spring Security web authentication services and URL-based access-control.

#### Config

#### Test

Support for testing with Spring Security.

## Getting started with Spring Security

### Filtering web requests

Spring Security employs several servlet filters to provide various aspects of security.

`DelegatingFilterProxy` is a special servlet filter that, by itself, doesn't do much.
Instead, it delegates to an implementation of `javax.servlet.Filter` that's registered as a `<bean>` in the Spring application context.

If you'd rather configure `DelegatingFilterProxy` in Java with a `WebApplicationInitializer`, then all you need to do is create a new class that extends `AbstractSecurityWebApplicationInitializer`.
`AbstractSecurityWebApplicationInitializer` implements `WebApplicationInitializer`, so it will be discovered by Spring and be used to register `DelegatingFilterProxy` with the web container.

### Writing a simple security configuration

You can configure web security by overriding `WebSecurityConfigurerAdapter`'s three `configure()` methods and setting behavior on the parameter passed in.

| Methods | Description |
| --- | --- |
| `configure(WebSecurity)` | Override to configure Spring Security's filter chain. |
| `configure(HttpSecurity)` | Override to configure how requests are secured by interceptors. |
| `configure(AuthenticationManagerBuilder)` | Override to configure user-details services. |

## Selecting user details services

What you need is a user store - some place where usernames, passwords, and other data can be kept and retrieved from when making authentication decisions.

Fortunately, Spring Security is extremely flexible and is capable of authenticating users against virtually any data store.

### Working with an in-memory user store

Since your security configuration class extends `WebSecurityConfigurerAdapter`, the easiest way to configure a webStoreUser store is to override the `configure()` method that takes an `AuthenticationManagerBuilder` as a parameter.
`AuthenticationManagerBuilder` has several methods that can be used to configure Spring Security’s authentication support.
With the `inMemoryAuthentication()` method, you can enable and configure and optionally populate an in-memory webStoreUser store.

```java

```


### Authenticating against database tables

It's quite common for webStoreUser data to be stored in a relational database, accessed via JDBC.
To configure Spring Security to authenticate against a JDBC-backed webStoreUser store, you can use the `jdbcAuthentication()` method.

### Configuring a custom webStoreUser service

All you need to do is implement the `loadUserByUsername()` method to find a webStoreUser given the webStoreUser's username.
`loadUserByUsername()` then returns a `UserDetails` object representing the given webStoreUser.

## Intercepting requests

The key to fine-tuning security for each request is to override the `configure(HttpSecurity)` method.

The `HttpSecurity` object given to `configure()` can be used to configure several aspects of HTTP security.
Here you're calling `authorizeRequests()` and then calling methods on the object it returns to indicate that you want to configure request-level security details.

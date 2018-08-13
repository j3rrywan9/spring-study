# Spring Data

## The Spring Data Project

The Spring Data project provides a consistent programming model across the different store implementations using patterns and abstractions already known from within the Spring Framework.
This allows for a consistent experience when you're working with different stores.

### General Themes

A very core part of the Spring Data modules is a mapping and conversion API that allows obtaining metadata about domain classes to be persistent and enables the actual conversion of arbitrary domain objects into store-specific data types.

To ease that process even more, Spring Data provides a repository abstraction on top of the template implementation that will reduce the effort to implement data access objects to a plain interface definition for the most common scenarios like performing standard CRUD operations as well as executing queries in case the store supports that.

## Repositories

The goal of the repository abstraction of Spring Data is to reduce the effort required to implement data access layers for various persistence stores significantly.

### Quick Start

A traditional approach to a data access layer would now require you to at least implement a repository class that contains necessary CRUD methods as well as query methods to access subsets of the entities stored by applying restrictions on them.

The Spring Data repository approach allows you to get rid of most of the implementation code and instead start with a plain interface definition for the entity's repository.

As you can see, we extend the Spring Data `Repository` interface, which is just a generic marker interface.

## JPA Repositories

It's annotated with `@MappedSuperclass` to express that it is not a managed entity class on its own but rather will be extended by entity class.

## API

### Spring Data Core

```java
@NoRepositoryBean
public interface CrudRepository<T,ID extends Serializable>
extends Repository<T,ID>
```
Interface for generic CRUD operations on a repository for a specific type.

```java
public @interface NoRepositoryBean
```
Annotation to exclude repository interfaces from being picked up and thus in consequence getting an instance being created.
This will typically be used when providing an extended base interface for all repositories in combination with a custom repository base class to implement methods declared in that intermediate interface.
In this case you typically derive your concrete repository interfaces from the intermediate one but don't want to create a Spring bean for the intermediate interface.

### Spring Data JPA

```java
public @interface EnableJpaRepositories
```
Annotation to enable JPA repositories.
Will scan the package of the annotated configuration class for Spring Data repositories by default.

### Spring Data REST

#### Introduction

REST web services have become the number one means for application integration on the web.
In its core, REST defines that a system consists of resources that clients interact with.
These resources are implemented in a hypermedia driven way.
Spring MVC offers a solid foundation to build theses kinds of services.
But implementing even the simplest tenet of REST web services for a multi-domain object system can be quite tedious and result in a lot of boilerplate code.

Spring Data REST builds on top of Spring Data repositories and automatically exports those as REST resources.
It leverages hypermedia to allow clients to find functionality exposed by the repositories and integrates these resources into related hypermedia based functionality automatically.

#### Getting started

The simplest way to get to started is if you are building a Spring Boot application.
That's because Spring Data REST has both a starter as well as auto-configuration.

##### Basic settings for Spring Data REST

###### Which repositories get exposed by default?

###### Changing the base URI

By default, Spring Data REST serves up REST resources at the root URI, "/".
There are multiple ways to change the base path.

With Spring Boot 1.2+, all it takes is a single property in `application.properties`:
```java
spring.data.rest.base-path=/api
```

##### Starting the application

At this point, you must also configure your key data store.

Spring Data REST officially supports:
* Spring Data JPA

#### Repository resources

##### Fundamentals

The core functionality of Spring Data REST is to export resources for Spring Data repositories.
Thus, the core artifact to look at and potentially tweak to customize the way the exporting works is the repository interface.
Assume the following repository interface:
```java
public interface OrderRepository extends CrudRepository<Order, Long>
```
For this repository, Spring Data REST exposes a collection resource at `/orders`.
The path is derived from the uncapitalized, pluralized, simple class name of the domain class being managed.
It also exposes an item resource for each of the items managed by the repository under the URI template `/orders/{id}`.

By default the HTTP methods to interact with these resources map to the according methods of `CrudRepository`.
Read more on that in the sections on collection resources and item resources.

##### Default state codes

For the resources exposed, we use a set of default status codes:
* `200 OK` - for plain `GET` requests.
* `201 Created` - for `POST` and `PUT` requests that create new resources.
* `204 No Content` - for `PUT`, `PATCH`, and `DELETE` requests if the configuration is set to not return bodies for resource updates (`RepositoryRestConfiguration.returnBodyOnUpdate`).
If the configuration value is set to include responses for `PUT`, `200 OK` will be returned for updates, `201 Created` will be returned for resource created through `PUT`.

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

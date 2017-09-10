# DAO and JDBC in Spring

## DAO support

The DAO support in Spring is aimed at making it easy to work with data access technologies like JDBC, Hibernate, JPA or JDO in a consistent way.

When we talk about the Spring data support, it's specially for the purpose of your application interacting with the data or the database, and you can typically write the Java code that interacts with the database.
The whole point of using the Spring data support is that you can do away with all the extra boilerplate code and the code that you write specifically for the business case and the business problem that you want to resolve.

The Spring JDBC module provides a kind of an abstract layer and all the tedious JDBC code that we would otherwise have to write is provided by the JDBC module, which is in the Spring framework.

## THe DAO design pattern

The DAO design pattern can be used to provide a separation between the low-level data accessing operations and the high-level business services.

### The DAO layer

In between the database and the business layer, there is a layer called the DAO layer.
The DAO layer is mainly used to perform CRUD operation.
To perform this CRUD operation, DAO uses a low-level API, such as the JDBC API or the Hibernate API.
The DAO layer decouples the implementation of persistent storage from the rest of your application.

## JdbcTemplate

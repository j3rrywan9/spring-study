# DAO and JDBC in Spring

When we talk about the Spring data support, it's specially for the purpose of your application interacting with the data
or the database, and you can typically write the Java code that interacts with the database.

## THe DAO design pattern

The DAO design pattern can be used to provide a separation between the low-level data accessing operations and the
high-level business services.

### The DAO layer

In between the database and the business layer, there is a layer called the DAO layer.
The DAO layer is mainly used to perform CRUD operation.
To perform this CRUD operation, DAO uses a low-level API, such as the JDBC API or the Hibernate API.
The DAO layer decouples the implementation of persistent storage from the rest of your application.

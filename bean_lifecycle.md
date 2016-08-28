# Bean Lifecycle

As long as Spring beans are required by the application, they exist within the container.
For a bean to get into a usable state after instantiation, it needs to perform some initialization.
Likewise, some clean up may be necessary when the bean is no longer required and is removed from the container.

Spring provides us with callback methods for the life cycle of the bean.
You can have a method in your bean that runs when the bean has been created, and you can also have a method in your bean
that is run when the bean is about to be destroyed.

The life cycle of beans consists of callback methods, which can be categorized broadly into the following two groups:
* Post-initialization callback methods
* Pre-destruction callback methods

### Initialization

### Activation

### Destruction

### Initialization callbacks

### Destruction callbacks

There are two ways you can do a destruction callback:
* Implementing the `org.springframework.beans.factory.DisposableBean` interface
* Using `destroy-method` in the XML configuration

# Bean Scope

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
There are different bean scopes in Spring, such as singleton, prototype, request, session, and global session.

## Scopes

### Singleton

By default, all Spring beans are singleton.
Once `AppicationContext` is initialized, it looks at all the beans in XML and initializes only one bean per bean
definition in Spring Container.
On each call to the `getBean()` method, Spring Container returns the same instance of the bean.

The first bean scope in Spring that is called is singleton, which initializes only one bean per bean definition in the
container and returns the same instance reference on each call to the `getBean()` method.
This scope makes Spring initialize all beans during the load time itself without waiting for the `getBean()` call.

### Prototype

The prototype is second bean scope in Spring, which returns a brand new instance of a bean on each call to the
`getBean()` method.
When a bean is defined as a prototype, Spring waits for `getBean()` to happen and only then does it initialize the
prototype.

### Request

### Session

### Global session

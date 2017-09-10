# Spring MVC

The Spring MVC supports Web application development by providing comprehensive and intensive support.

The Spring MVC framework is designed around a `DispatcherServlet`. The `DispatcherServlet` dispatches the HTTP requests to the handler, which is very simple `Controller` interface.
Spring MVC allows us to use any form object or command object.

### Flow of request handling in Spring MVC

* **Filter**
* **DispatcherServlet**
* **Local resolution and theme resolution**
* **Handler mapping**
* **Controller**
* **ViewResolver**
* **View**

Whenever an HTTP request from a browser comes to a Spring MVC application, it is first intercepted by
`DispatcherServlet`, which acts like the front controller for a Spring MVC application.
The `DispatcherServlet` class intercepts the incoming HTTP request and determines which controller handles the request, and then sends the HTTP request to Spring MVC controller.

The controller implements the behavior of the Spring MVC application.
The controller receives the request from the `DispatcherServlet` class and performs some business logic in accordance with the client request.
A Spring MVC application may have several controllers, and to decide on the controller to send the request, `DispatcherServlet` takes help from one or more handler mappings.
The handler mapping makes its decision based on the URL carried by the request.

After the business logic is performed by controller, some information referred to as the model is generated, that needs to be carried back to the client and display in the browser.
But it is not sufficient to send raw information to the client.
So the raw information needs to be given to the view.
The controller also packages up the model data and identifies the view name that will render the output.
Then, it sends the request along with view name and model back to `DispatcherServlet`.

```java
public abstract class AbstractAnnotationConfigDispatcherServletInitializer
extends AbstractDispatcherServletInitializer
```
Concrete implementations are required to implement `getRootConfigClasses()` and `getServletConfigClasses()` as well as `AbstractDispatcherServletInitializer.getServletMappings()`.
Further template and customization methods are provided by `AbstractDispatcherServletInitializer`.

```java
protected abstract Class<?>[] getRootConfigClasses()
```

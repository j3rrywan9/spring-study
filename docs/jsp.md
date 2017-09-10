# JSP

## Viewing a JSP Page

With JSP, the web page doesn't actually exist on the server.
As you can see in following figure, the server creates it fresh when responding to each request.

The following steps explain how the web server creates the web page:
1. As with a normal page, your browser sends an HTTP request to the web server.
This doesn't change with JSP, although the URL probably ends in `.jsp` instead of `.html` or `.htm`.
1. The web server is not a normal server, but rather a Java server, with the extensions necessary to identify and handle Java servlets.
The web server recognizes that the HTTP request is for a JSP page and forwards it to a JSP engine.
1. The JSP engine loads the JSP page from disk and converts it into a Java servlet.
From this point on, this servlet is indistinguishable from any other servlet developed directly in Java rather than JSP.
1. The JSP engine compiles the servlet into an executable class and forwards the original request to anther part of the web server called the `servlet engine`.
1. The servlet engine loads the servlet class and executes it.
During execution, the servlet produces an output in HTML format, which the servlet engine passes to the web server inside an HTTP response.
1. The web server forwards the HTTP response to your browser
1. Your web browser handles the dynamically generated HTML page inside the HTTP response exactly as if it were a static page.
In fact, static and dynamic web pages are in the same format.

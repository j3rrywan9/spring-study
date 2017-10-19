# Runtime Value Injection

For those cases, Spring offers two ways of evaluating values at runtime:
* Property placeholders
* The Spring Expression Language (SpEL)

## Injecting external values

The simplest way to resole external values in Spring is to declare a property source and retrieve the properties via the Spring Environment.

### Resolving property placeholders

Spring has always supported the option of externalizing properties into a properties file and then plugging them into Spring beans using placeholder values.
In Spring wiring, placeholder values are property names wrapped with `${...}`.

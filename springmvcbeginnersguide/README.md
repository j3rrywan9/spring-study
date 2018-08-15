# Spring MVC Beginner's Guide Second Edition

## Installing Jetty

```bash
brew install jetty
```

## Building

```bash
mvn clean package -pl springmvcbeginnersguide/webstore
```

## Testing

The most basic technique for deploying Web Applications is to put a WAR file or Exploded WAR directory into the `${jetty.base}/webapps/` directory and let Jetty's deployment scanner find it and deploy it under a Context path of the same name.
```bash
cp springmvcbeginnersguide/webstore/target/webstore-1.0.0-SNAPSHOT.war /usr/local/Cellar/jetty/9.4.11.v20180605/libexec/webapps/webstore.war

cd /usr/local/Cellar/jetty/9.4.11.v20180605/libexec/

java -jar start.jar
```


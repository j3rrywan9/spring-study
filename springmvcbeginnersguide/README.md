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
export JETTY_HOME=/usr/local/Cellar/jetty/9.4.15.v20190215/libexec

cp springmvcbeginnersguide/webstore/target/webstore-1.0.0-SNAPSHOT.war $JETTY_HOME/webapps/webstore.war

cd $JETTY_HOME

java -jar start.jar
```

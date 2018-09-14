Spring Boot 2.0 Actuator Examples
=======================================

[Spring Actuator](https://spring.io/blog/2017/08/22/introducing-actuator-endpoints-in-spring-boot-2-0) 
with [Spring Boot 2.0](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-endpoints-custom) examples.

- Example of a Spring Boot 2.0 custom Actuator endpoint

### Build
Execute the following command from the parent directory to build the jar file:
```
mvn clean install
```

### Run
From the parent directory, executte the following coommand to start the application:
```
java -jar target/spring-actuator-example-1.0.0.jar
```

You should notice the application starting up,


Once the application starts up, navigate to `http://localhost:8080/myhealth` in a browser, e.g., Chrome.


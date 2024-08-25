# springboot3-soap-server

This application is a modern variant of a demo by Java Techie (https://www.youtube.com/watch?v=ceSqN3CWd14). The important changes are:

- Spring Boot 2 -> 3.x
- Other plugin with JAXB3 support: org.jvnet.jaxb/jaxb-maven-plugin
- Java 8 -> 17 
- Test messages added
- Location generated sources: /src -> /target
- Maven wrapper added

The jaxb2-maven-plugin will compile loaneligibility.xsd into fully annotated java classes. The plugin uses the generate tool as a code-generation engine.

# view wsdl

Spring Boot generates a WSDL based on the XSD, so no need to create one by hand.
Url: http://localhost:8080/ws/loanEligibility.wsdl

# testberichten

The http-tests directory contains two XML test messages. 
These messages can be send to a running application with file tests.http. 
In IntelliJ Ultimate, the tests can be started with the built-in HTTP client using the green arrow.

From the CLI, the test messages can be sent as requests using curl:
```curl
curl -v -X POST -H "Content-Type: text/xml;charset=UTF-8" --data @http-tests/approved.xml http://localhost:8080/ws
curl -v -X POST -H "Content-Type: text/xml;charset=UTF-8" --data @http-tests/denied.xml http://localhost:8080/ws
```
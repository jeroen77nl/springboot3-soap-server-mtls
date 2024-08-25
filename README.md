# springboot3-soap-server-mtls

This application is a modern variant of a demo by Java Techie (https://www.youtube.com/watch?v=ceSqN3CWd14).
This is basically a copy of my repo **spring boot 3-soap-server**, with the addition of mutual TLS functionality.

The resources folder contains two stores used by the app for mTLS:
- server-keystore.p12
- server-truststore.jks

The root folder contains the following certificate and key-files for client testing purposes:
- ca.crt
- client.crt
- client.key

See article https://paras301.medium.com/implementing-ssl-tls-in-springboot-mutual-tls-mtls-part-2-b3eb64c6a78e for more info about the creation of these stores.

# running the server app

These commands should suffice for running the server app from the project root directory:
```cmd
./mvnw clean install
./mvnw spring-boot:run
```

# testmessages

The http-tests directory contains two XML test messages and some scripts.
From the CLI, the test messages can be sent as requests using curl using tests.curl

The mTLS is enabled by default and the server runs on port 8443.

mTLS can be disabled by setting property **server.ssl.enabled=true** to false. A restart is required.
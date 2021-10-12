# Remote Method Invocation with Java
The objective of these three different applications is to use RMI and know the differences betweeen RMI and socket-level programming. 

## 1. Hello World RMI
Simple application that demostrates RMI with a simple method.

    1. The server object is registered with the RMI registry.
    2. The client looks up through the RMI registry for the remote object.
    3. Once remote object is located, its stub is returned to the client.
    4. The remote object can be used in the same way as a local object. The communication between the client and the server is handled through the stub and skeleton.

## 2. Student Score RMI 
Application that calculates the scores of the students using RMI. 

## 3. Matrix Multiplication
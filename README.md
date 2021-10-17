# Remote Method Invocation with Java
The objective of these three different applications is to use RMI and know the differences betweeen RMI and socket-level programming. 

## 1. Hello World RMI
Simple application that demostrates RMI with a simple method.

    1. The server object is registered with the RMI registry.
    2. The client looks up through the RMI registry for the remote object.
    3. Once remote object is located, its stub is returned to the client.
    4. The remote object can be used in the same way as a local object. The communication between the client and the server is handled through the stub and skeleton.

## 2. Student Score RMI 
Application that calculates the scores of the students using RMI. The application   has two interfaces: StudentInterface.java and
PromotionInterface.java

The interface StudentInterface.java allows the client to access to the student
information: name, age,Id, scores….Each student passes many exams and each exam
is associated with a score and a coefficient (a double between 0 and 1). This interface
proposes three methods:

1. add_exam: adds an exam to a student. An exam has a name, a score and a
coefficient.
2. print_exams: sends a string (list of exams) to the client.
3. calculate_ average: calculates the average score.

The interface PromotionInterface.java allows to:
1. Create a new student (method add_student)
2. Find a student (method get_student).As this method return a reference to an
   object, the client can ask to calculate the average score of the student
3. Calculate the average score of all the promotion (method promotion_score)


## 3. Matrix Multiplication
Matrix multiplication is an important operation of linear algebra. It is widely used in many systems and sometimes
it is expensive for some applications when size is large.
The goal is to implement a distributed application using JAVA RMI to reduce the ecost of the calculation of this operation.
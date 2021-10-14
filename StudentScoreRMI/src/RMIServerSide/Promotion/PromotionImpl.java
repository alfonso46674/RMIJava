package RMIServerSide.Promotion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import RMIServerSide.Student.StudentImpl;

public class PromotionImpl extends UnicastRemoteObject implements PromotionInterface{

    public String name;
    public HashMap<String,StudentImpl> students;

    public PromotionImpl(String name) throws RemoteException{
        this.name = name;
        this.students = new HashMap<String, StudentImpl>();
    }


    public void add_student(String name, Integer age, String id) throws RemoteException {
        //add the student to the HashMap -> its id is the key, and the student object is the value
        this.students.put(id, new StudentImpl(name, age, id));
    };

    public StudentImpl get_student(String id) throws RemoteException {
        return this.students.get(id);
    };

    public Double promotion_score() throws RemoteException {
        Double class_average = 0.0;
        //iterate through the HashMap and calculate the average f

        for(StudentImpl student : students.values()){
            //calculate the average score for each student and add it to the class_average
            class_average += student.calculate_average();
        }
        //return the average score for the class
        return class_average / students.size();
    }

    public static void main(String[] args) {
        try {
            // create class
            PromotionImpl classRoom = new PromotionImpl("MathClass");
            //add students
            classRoom.add_student("Carlos", 21, "A1");
            classRoom.add_student("Ashley", 23, "A2");
            classRoom.add_student("Toby", 19, "A3");
            //add two exams per students
            classRoom.students.get("A1").add_exam("Math", 9.0, 0.5);
            classRoom.students.get("A1").add_exam("English", 4.5, 0.2);

            classRoom.students.get("A2").add_exam("Geography", 8.2, 0.3);
            classRoom.students.get("A2").add_exam("English", 8.0, 0.1);

            classRoom.students.get("A3").add_exam("Physics", 7.0, 0.6);
            classRoom.students.get("A3").add_exam("English", 10.0, 0.2);


            System.out.println(classRoom.get_student("A1").name + ": " + classRoom.get_student("A1").calculate_average());
            System.out.println(classRoom.get_student("A2").name + ": " + classRoom.get_student("A2").calculate_average());
            System.out.println(classRoom.get_student("A3").name + ": " + classRoom.get_student("A3").calculate_average());

            System.out.println(classRoom.name + ": " + classRoom.promotion_score());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
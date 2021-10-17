package RMIServerSide.Promotion;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import RMIServerSide.Student.StudentImpl;
import RMIServerSide.Student.StudentInterface;

public class PromotionImpl extends UnicastRemoteObject implements PromotionInterface{


    public HashMap<String,StudentImpl> students;

    public PromotionImpl() throws RemoteException{
        this.students = new HashMap<String, StudentImpl>();
    }


    public void add_student(String name, Integer age, String id) throws RemoteException {
        //add the student to the HashMap -> its id is the key, and the student object is the value
        this.students.put(id, new StudentImpl(name, age, id));
    };

    public StudentInterface get_student(String id) throws RemoteException {
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

}
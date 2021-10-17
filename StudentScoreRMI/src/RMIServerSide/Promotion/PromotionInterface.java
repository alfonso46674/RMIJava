package RMIServerSide.Promotion;

import java.rmi.Remote;
import java.rmi.RemoteException;

import RMIServerSide.Student.StudentInterface;

public interface PromotionInterface extends Remote{

    //Add a new student to the classroom
    public void add_student(String name, Integer age, String id) throws RemoteException;

    //Finds a student and returns a reference to that object
    public StudentInterface get_student(String id) throws RemoteException;

    //Calculates the average score of all the promotion (average score of all studeents in the classroom)
    public Double promotion_score() throws RemoteException;
}
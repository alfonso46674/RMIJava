package RMIServerSide.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {

    //adds an exam to a student. An exam has a name, score and a coefficient
    public void add_exam(String name, Double score, Double coefficient) throws RemoteException;

    //Returns a string (list of exams) to the client
    public String print_exams() throws RemoteException;

    //Calculates the average score
    public Double calculate_average() throws RemoteException;

}
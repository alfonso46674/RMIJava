import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StudentImpl extends UnicastRemoteObject implements StudentInterface {

    public String name;
    public Integer age;
    public String id;
    public ArrayList<Double> scores;
    public ArrayList<Exam> exams;

    public StudentImpl(String name, Integer age, String id) throws RemoteException {
        this.name = name;
        this.age = age;
        this.id = id;
        this.scores = new ArrayList<Double>();
        this.exams = new ArrayList<Exam>();
    }

    // adds an exam to a student. An exam has a name, score and a coefficient
    public void add_exam(String name, Double score, Double coefficient) throws RemoteException {
        Exam exam = new Exam(name, score, coefficient); //TODO create enumeration for the exams name
        exams.add(exam);
    }

    // Returns a string (list of exams) to the client
    public String print_exams() throws RemoteException {
        String examsList = "";

        for(int i = 0; i < this.exams.size(); i++){
            examsList += this.exams.get(i).name + ", ";
        }
        //delete the last two chars since they are , and a blank space
        return examsList.substring(0,examsList.length() - 2);
    }

    // Calculates the average score
    public Double calculate_average() throws RemoteException {
        Double sum = 0.0;
        for (int i = 0; i < this.exams.size(); i++) {
            sum += this.exams.get(i).score;
        }
        return sum / this.exams.size();
    }

    public static void main(String[] args) {
        try {
            StudentImpl student = new StudentImpl("Carlos", 22, "32A");
            student.add_exam("Geography", 5.5, 0.1);
            student.add_exam("Math", 10.0, 0.2);
            System.out.println(student.print_exams());
            System.out.println(student.calculate_average());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package RMIClientSide;

import RMIServerSide.Promotion.PromotionInterface;

import java.rmi.Naming;

public class Client {
    private static PromotionInterface promotion;

    public static void main(String[] args) {
        try{
            //lookup for the remote promotion object in the rmi registry
            promotion = (PromotionInterface) Naming.lookup("//localhost/promotion");

            //testing the promotion object

            //Create new students
            promotion.add_student("John",22,"A1");
            promotion.add_student("Ashley",21,"A2");
            promotion.add_student("Tyler",19,"B1");

            //Add exams to each student
            promotion.get_student("A1").add_exam("Math",10.0,0.6);
            promotion.get_student("A1").add_exam("English",5.5,0.1);
            promotion.get_student("A2").add_exam("French",7.8,0.2);
            promotion.get_student("A2").add_exam("Geography",10.0,0.3);
            promotion.get_student("B1").add_exam("Math",9.5,0.7);
            promotion.get_student("B1").add_exam("French",8.0,0.3);

            //Print the exams for each student
            System.out.println("Exams");
            System.out.println("Student: " +promotion.get_student("A1").getName() + ". Exams: " +  promotion.get_student("A1").print_exams());
            System.out.println("Student: " +promotion.get_student("A2").getName() + ". Exams: " +  promotion.get_student("A2").print_exams());
            System.out.println("Student: " +promotion.get_student("B1").getName() + ". Exams: " +  promotion.get_student("B1").print_exams());

            //calculate the average of each student
            System.out.println("\nAverages");
            System.out.println("Student: " + promotion.get_student("A1").getName() + ". Average: " + promotion.get_student("A1").calculate_average() );
            System.out.println("Student: " + promotion.get_student("A2").getName() + ". Average: " + promotion.get_student("A2").calculate_average() );
            System.out.println("Student: " + promotion.get_student("B1").getName() + ". Average: " + promotion.get_student("B1").calculate_average() );


            //calculate the promotions average
            System.out.print("\nPromotion average");
            System.out.print("Average: " + promotion.promotion_score());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

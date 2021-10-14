public class Exam {
    public String name;
    public Double score; // TODO Change score from double to int, so that the score range is from 0 to 100
    public Double coefficient;

    public Exam (String name, Double score, Double coefficient){
        this.name = name;
        this.score = score;
        this.coefficient = coefficient; // TODO Validate coefficient range between 0 and 1
    }
    
}

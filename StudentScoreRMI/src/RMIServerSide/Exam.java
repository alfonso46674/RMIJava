public class Exam {
    public String name;
    public Double score;
    public Double coefficient;

    public Exam (String name, Double score, Double coefficient){
        this.name = name;
        this.score = score;
        this.coefficient = coefficient; // TODO Validate coefficient range between 0 and 1
    }
    
}

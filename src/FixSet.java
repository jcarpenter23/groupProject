import java.io.IOException;

public class FixSet {
    public static void main(String[] args) {
        try{
            QuestionSet questionSet = new QuestionSet("sets/defaultSet.set");
            questionSet.save("fixed.set");
            QuestionSet fixed = new QuestionSet("fixed.set");
            System.out.println(fixed);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}

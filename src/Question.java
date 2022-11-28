import java.util.ArrayList;

public class Question {
    private final String question;
    
    private final ArrayList<String> answers;
    
    private final String category;
    
    public Question(String question, ArrayList<String> answers, String category) {
        this.question = question;
        this.category = category;
        
        while (answers.size() > 4) {
            answers.remove(4);
        }
        
        while (answers.size() < 4) {
            answers.add("");
        }
        
        this.answers = answers;
    }
    
    public Question(String question, ArrayList<String> answers) {
        this.question = question;
        this.category = "";
        
        while (answers.size() > 4) {
            answers.remove(4);
        }
        
        while (answers.size() < 4) {
            answers.add("");
        }
        
        this.answers = answers;
    }
}

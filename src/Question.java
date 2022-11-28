import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private final String question;
    
    private ArrayList<String> answers = null;
    
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
    
    public String getQuestion() {
        return question;
    }
    
    public String getCategory() {
        return category;
    }
    
    public ArrayList<String> getAnswers() {
        return answers;
    }
    
    public String getAnswer(int index) {
        try {
            return answers.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    public String getCorrectAnswer() {
        return answers.get(0);
    }
    
    public ArrayList<String> getShuffledAnswers() {
        ArrayList<String> output = answers;
        Collections.shuffle(output);
        return output;
    }
}

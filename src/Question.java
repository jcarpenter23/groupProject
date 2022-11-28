import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private final String question;
    
    // the correct answer is always at index 0
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
        // the correct answer is always at index 0
        return answers.get(0);
    }
    
    public ArrayList<String> getShuffledAnswers() {
        ArrayList<String> output = new ArrayList<>(answers);
        Collections.shuffle(output);
        return output;
    }
}

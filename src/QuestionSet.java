import java.util.ArrayList;
import java.util.Random;

public class QuestionSet {
    private final ArrayList<Question> questions;
    private static final Random random = new Random();
    
    public QuestionSet(ArrayList<Question> questions) {
        this.questions = questions;
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
    public Question getQuestion(int index) {
        return questions.get(index);
    }
    
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}

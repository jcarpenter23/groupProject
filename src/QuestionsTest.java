import java.util.ArrayList;

public class QuestionsTest {
    public static void main(String[] args) {
        ArrayList<String> testAnswers = new ArrayList<>() {
            {
                add("correct answer");
                add("wrong answer 1");
                add("wrong answer 2");
                add("wrong answer 3");
            }
        };
        
        Question testQuestion = new Question("test question", testAnswers, "test category");
        
        System.out.println(testQuestion.getQuestion());
        System.out.println(testQuestion.getCategory());
        System.out.println(testQuestion.getAnswers());
        System.out.println(testQuestion.getAnswer(3));
        System.out.println(testQuestion.getCorrectAnswer());
        System.out.println(testQuestion.getShuffledAnswers());
        System.out.println(testQuestion.getAnswers());
    }
}

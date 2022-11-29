import java.io.FileNotFoundException;
import java.io.IOException;

public class QuestionsTest {
    public static void main(String[] args) {
        QuestionSet testSet;
        try {
            testSet = new QuestionSet("sets/test.set");
        } catch (FileNotFoundException e) {
            System.out.println("where did the file go");
            return;
        } catch (IOException e) {
            System.out.println("something broke");
            return;
        }
        
        System.out.println(testSet);
        System.out.println();
        
        System.out.println(testSet.getQuestions());
        System.out.println(testSet.getQuestion(1));
        System.out.println(testSet.getRandomQuestion());
        
        Question testQuestion = testSet.getQuestion(0);
        
        System.out.println(testQuestion);
        System.out.println();
        
        System.out.println(testQuestion.getQuestion());
        System.out.println(testQuestion.getCategory());
        System.out.println(testQuestion.getAnswers());
        System.out.println(testQuestion.getAnswer(3));
        System.out.println(testQuestion.getCorrectAnswer());
        System.out.println(testQuestion.getShuffledAnswers());
        System.out.println(testQuestion.getAnswers());
    }
}

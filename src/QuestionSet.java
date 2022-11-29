import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuestionSet {
    private final ArrayList<Question> questions;
    private static final Random random = new Random();
    
    private final String filename;
    
    private final ArrayList<String> categories;
    
    public QuestionSet(ArrayList<Question> questions) {
        this.questions = questions;
        filename = "";
        categories = new ArrayList<>();
    }
    
    public QuestionSet(String filename) throws IOException {
        questions = new ArrayList<>();
        categories = new ArrayList<>();
        this.filename = filename;
    
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        String currentCategory;
        String currentQuestion;
        ArrayList<String> answers;
        
        while (true) {
            try {
                currentCategory = br.readLine();
            } catch (IOException e) {
                break;
            }
            
            if (currentCategory == null) {
                break; // end of file
            }
            
            while (true) {
                try {
                    currentQuestion = br.readLine();
                    
                    if (currentQuestion == null || currentQuestion.isEmpty()) {
                        break; // blank line, so next line starts a new category, or end of file
                    }
                    
                    answers = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        answers.add(br.readLine());
                    }
                    
                } catch (IOException e) {
                    break;
                }
                
                if (answers.contains(null)) {
                    break; // end of file
                }
                
                questions.add(new Question(currentQuestion, answers, currentCategory));
            }
        }
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
    
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Question question : questions) {
            output.append(question).append("\n\n");
        }
        return output.toString();
    }
}

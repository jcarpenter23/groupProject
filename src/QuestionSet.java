import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
                    
                    if (currentQuestion == null || currentQuestion.isBlank()) {
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
    
    public void createCategory(String name) {
        if (categories.contains(name)) {
            throw new IllegalStateException(String.format("Category %s already exists", name));
        }
        validateCategoryName(name);
        categories.add(name);
    }
    
    private static void validateCategoryName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Blank category names are not allowed");
        }
    }
    
    public void createQuestion(String text, ArrayList<String> answers, String category) {
        if (categories.contains(category)) {
            questions.add(new Question(text, answers, category));
        } else {
            throw new IllegalArgumentException(String.format("Unknown category: %s", category));
        }
    }

    public void forceCreateQuestion(String text, ArrayList<String> answers, String category) {
        if (!categories.contains(category)) {
            createCategory(category);
        }
        questions.add(new Question(text, answers, category));
    }
    
    public void sortByCategory() {
        Collections.sort(questions);
    }
    
    public void save() throws IOException {
        save(filename);
    }
    
    public void save(String filename) throws IOException {
        sortByCategory();
        
        File file = new File(filename);
        
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        
        //noinspection ResultOfMethodCallIgnored
        file.createNewFile();

        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        
        String previousCategory = "";
        
        for (Question question : questions) {
            if (!question.getCategory().equals(previousCategory)) {
                if (!previousCategory.isBlank()) {
                    printWriter.println(); // separator line
                }
                
                printWriter.println(question.getCategory());
            }
            
            printWriter.println(question.getQuestionText());
            for (String answer : question.getAnswers()) {
                printWriter.println(answer);
            }
        }
        
        printWriter.flush();
        printWriter.close();
    }
}

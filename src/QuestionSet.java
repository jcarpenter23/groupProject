import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// a set of questions, typically loaded from a .set file
public class QuestionSet {
    private final ArrayList<Question> questions;
    private static final Random random = new Random();
    private final String filename;
    private final ArrayList<String> categories;
    
    // creates a question set from an array list of questions. categories are not automatically loaded
    public QuestionSet(ArrayList<Question> questions) {
        this.questions = questions;
        filename = "";
        categories = new ArrayList<>();
    }
    
    // creates a question set from a .set file. categories ARE automatically loaded
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
            
            categories.add(currentCategory);
            
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
    
    // returns the entire array of questions
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
    // returns the question with the given index
    public Question getQuestion(int index) {
        return questions.get(index);
    }
    
    // returns a randomly selected question
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
    
    // returns the string representation of each question, each separated by a blank line
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Question question : questions) {
            output.append(question).append("\n\n");
        }
        return output.toString();
    }
    
    // creates a new category
    // if the category already exists, throws IllegalStateException
    // if the name is blank, throws IllegalArgumentException
    public void createCategory(String name) {
        if (categories.contains(name)) {
            throw new IllegalStateException(String.format("Category %s already exists", name));
        }
        validateCategoryName(name);
        categories.add(name);
    }
    
    // makes sure category names aren't blank. throws IllegalArgumentException if they are
    private static void validateCategoryName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Blank category names are not allowed");
        }
    }
    
    // creates a new question and adds it to the question set. the given category must already exist
    public void createQuestion(String text, ArrayList<String> answers, String category) {
        if (categories.contains(category)) {
            questions.add(new Question(text, answers, category));
        } else {
            throw new IllegalArgumentException(String.format("Unknown category: %s", category));
        }
    }

    // creates a new question and adds it to the question set. if the given category doesn't exist, it is created
    public void forceCreateQuestion(String text, ArrayList<String> answers, String category) {
        if (!categories.contains(category)) {
            createCategory(category);
        }
        questions.add(new Question(text, answers, category));
    }
    
    // adds a question object to the question set. if its category isn't already in the set, it is created
    public void forceCreateQuestion(Question question) {
        if (!categories.contains(question.getCategory())) {
            createCategory(question.getCategory());
        }
        questions.add(question);
    }
    
    // sorts the questions in the set by their category
    public void sortByCategory() {
        Collections.sort(questions);
    }
    
    // saves the question set to the file it was loaded from
    public void save() throws IOException {
        save(filename);
    }
    
    // saves the question set to the given file name
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
            
            previousCategory = question.getCategory();
        }
        
        printWriter.flush();
        printWriter.close();
    }
    
    // returns an array list containing all categories in the question set
    public ArrayList<String> getCategories() {
        return categories;
    }
}

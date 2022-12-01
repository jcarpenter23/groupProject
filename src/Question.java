import java.util.ArrayList;
import java.util.Collections;

// holds data about a single question
public class Question implements Comparable<Question> {
    private final String questionText;
    private final ArrayList<String> answers;
    private final String category;
    
    // creates a new question. the correct answer should be at index 0 in answers
    // throws IllegalArgumentException if question text is blank
    public Question(String questionText, ArrayList<String> answers, String category) {
        if (questionText.isBlank()) {
            throw new IllegalArgumentException("Blank questions are not allowed");
        }
        
        this.questionText = questionText;
        this.category = category;
        
        while (answers.size() > 4) {
            answers.remove(4);
        }
        while (answers.size() < 4) {
            answers.add("");
        }
        this.answers = answers;
    }

    // returns the question text
    public String getQuestionText() {
        return questionText;
    }
    
    // returns the question's category
    public String getCategory() {
        return category;
    }
    
    // returns an array list containing the question's answer choices. the correct answer is at index 0
    public ArrayList<String> getAnswers() {
        return answers;
    }
    
    // returns a specific answer. inputs not in [0, 3] throw an IllegalArgumentException
    public String getAnswer(int index) {
        try {
            return answers.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    // returns the correct answer. identical to .getAnswer(0)
    public String getCorrectAnswer() {
        // the correct answer is always at index 0
        return answers.get(0);
    }
    
    // returns an array list containing the question's answer choices in a random order. the correct answer may be at any index.
    public ArrayList<String> getShuffledAnswers() {
        ArrayList<String> output = new ArrayList<>(answers);
        Collections.shuffle(output);
        return output;
    }
    
    // returns string representation of a question, as described below. note that this is NOT compatible with the .set file format
    // category: question
    // right answer
    // wrong answer
    // wrong answer
    // wrong answer
    public String toString() {
        StringBuilder answersString = new StringBuilder();
        for (String answer : answers) {
            answersString.append("\n").append(answer);
        }
        return String.format("%s: %s%s", category, questionText, answersString);
    }
    
    // compares each question's category using String.compareTo(String anotherString). used to ensure questions of the same category are saved together in .set files
    @Override
    public int compareTo(Question o) {
        return category.compareTo(o.getCategory());
    }
    
    public boolean validateCorrectAnswer(String answer) {
        return answer.equals(answers.get(0));
    }
}
import java.util.ArrayList;
import java.util.Collections;
/*
 *
 */

public class Question implements Comparable<Question> {
    private final String questionText;
    private final ArrayList<String> answers;
    private final String category;
    
    public Question(String questionText, ArrayList<String> answers, String category) {
        this.questionText = questionText;
        this.category = category;
        
        if (answers.size() > 4) {
            answers.remove(4);
        }
        if (answers.size() < 4) {
            answers.add("");
        }
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
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

    //public void ask() {
    
    public String toString() {
        StringBuilder answersString = new StringBuilder();
        for (String answer : answers) {
            answersString.append("\n").append(answer);
        }
        return String.format("%s: %s%s", category, questionText, answersString);
    }

    
    @Override
    public int compareTo(Question o) {
        return category.compareTo(o.getCategory());
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// gui for single player game. asks question, then gives feedback
public class GameGui {
    private final QuestionSet questionSet;
    
    private final JLabel questionTextDisplay;
    private final ArrayList<JButton> answerButtons;
    
    private Question currentQuestion;
    private String questionText;
    private ArrayList<String> answers;
    private Question nextQuestion;
    
    private int questionsCorrect;
    private int questionsAsked;
    
    private boolean feedbackScreen;
    
    // creates the window in which the single player game will be played, then begins the game
    public GameGui(QuestionSet questionSet) {
        this.questionSet = questionSet;
        questionText = "";
        answers = new ArrayList<>() {
            {
                add("");
                add("");
                add("");
                add("");
            }
        };
    
        JFrame playArea = new JFrame("QUIZ TIME - PLAY");
        playArea.setDefaultCloseOperation(playArea.DISPOSE_ON_CLOSE);
        playArea.getContentPane().setLayout(new GridLayout(5, 1));
        
        questionTextDisplay = new JLabel("");
        
        answerButtons = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            answerButtons.add(new JButton(""));
        }
        
        playArea.add(questionTextDisplay);
        for (JButton button : answerButtons) {
            button.addActionListener(new AnswerButtonEventListener(button, this));
            playArea.add(button);
        }
    
        playArea.pack();
        playArea.setMinimumSize(playArea.getSize());
        playArea.setSize(600, 400);
        playArea.setVisible(true);
        
        nextQuestion = questionSet.getRandomQuestion();
        showNewQuestion();
    }
    
    // listener for button in single player gui
    static class AnswerButtonEventListener implements ActionListener {
    
        JButton button;
        GameGui gameGui;
        
        public AnswerButtonEventListener(JButton button, GameGui gameGui) {
            this.button = button;
            this.gameGui = gameGui;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameGui.onFeedbackScreen()) {
                gameGui.showFeedbackScreen(button.getText());
            } else {
                gameGui.showNewQuestion();
            }
        }
    }
    
    // true if the game is on the question feedback screen
    public boolean onFeedbackScreen() {
        return feedbackScreen;
    }
    
    // asks the user the question stored in nextQuestion
    public void showNewQuestion() {
        feedbackScreen = false;
        currentQuestion = nextQuestion;
        
        questionText = currentQuestion.getQuestionText();
        questionTextDisplay.setText(questionText);
        
        answers = currentQuestion.getShuffledAnswers();
        
        for (int i = 0; i < 4; i++) {
            answerButtons.get(i).setText(answers.get(i));
        }
    }
    
    // shows whether the user got the question right, their score so far, and the next category
    // pressing any answer button on this screen begins the next question
    public void showFeedbackScreen(String answer) {
        feedbackScreen = true;
        questionsAsked++;
        nextQuestion = questionSet.getRandomQuestion();
        
        String feedbackString;
        if (answer.equals(currentQuestion.getCorrectAnswer())) {
            questionsCorrect++;
            feedbackString = "You got it!";
        } else {
            feedbackString = "Nope, the correct answer was " + currentQuestion.getCorrectAnswer() + ".";
        }
        feedbackString += " Correct answers: " + questionsCorrect + "/" + questionsAsked;
        questionTextDisplay.setText(feedbackString);
        
        for (JButton button : answerButtons) {
            button.setText("Next question: " + nextQuestion.getCategory());
        }
    }
}

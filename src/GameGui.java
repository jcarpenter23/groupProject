import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameGui {
    QuestionSet questionSet;
    
    JFrame playArea;
    JLabel questionTextDisplay;
    ArrayList<JButton> answerButtons;
    
    Question currentQuestion;
    String questionText;
    ArrayList<String> answers;
    Question nextQuestion;
    
    int questionsCorrect;
    int questionsAsked;
    
    boolean feedbackScreen;
    
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
        
        playArea = new JFrame("TRIVIA BOT - PLAY");
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
        playArea.setSize(300, 200);
        playArea.setVisible(true);
        
        nextQuestion = questionSet.getRandomQuestion();
        showNewQuestion();
    }
    
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
            }
        }
    }
    
    public boolean onFeedbackScreen() {
        return feedbackScreen;
    }
    
    public void showNewQuestion() {
        feedbackScreen = false;
        currentQuestion = nextQuestion;
        
        questionText = currentQuestion.getQuestionText();
        questionTextDisplay.setText(questionText);
        
        answers = currentQuestion.getShuffledAnswers();
        
        System.out.println(answers);
        System.out.println(answerButtons);
        
        for (int i = 0; i < 4; i++) {
            answerButtons.get(i).setText(answers.get(i));
        }
    }
    
    public void showFeedbackScreen(String answer) {
        questionsAsked++;
        
        String feedbackString;
        if (answer.equals(currentQuestion.getCorrectAnswer())) {
            questionsCorrect++;
            feedbackString = "You got it!";
        } else {
            feedbackString = "Nope, the correct answer was " + currentQuestion.getCorrectAnswer();
        }
    }
}

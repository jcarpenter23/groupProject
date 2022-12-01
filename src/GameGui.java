import javax.swing.*;
import java.awt.*;
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
            playArea.add(button);
        }
    
        playArea.pack();
        playArea.setMinimumSize(playArea.getSize());
        playArea.setSize(300, 200);
        playArea.setVisible(true);
    }
}

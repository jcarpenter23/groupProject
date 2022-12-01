import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI {
    
    private static final String SETS_DIRECTORY = "sets";
    private static final String CUSTOM_SET_FILE = SETS_DIRECTORY + "/custom.set";

    static class playButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JFrame playArea = new JFrame("TRIVIA BOT - PLAY");
            playArea.setDefaultCloseOperation(playArea.DISPOSE_ON_CLOSE);
            
            
            
            JFileChooser fileChooser = new JFileChooser(SETS_DIRECTORY);
            fileChooser.showOpenDialog(playArea);
            
            File toOpen = fileChooser.getSelectedFile();
            
            JLabel testText = new JLabel(toOpen.getName());
            playArea.getContentPane().add(testText);
    
            playArea.pack();
            playArea.setMinimumSize(playArea.getSize());
            playArea.setSize(300, 200);
            playArea.setVisible(true);
        }
    }

    static class createButtonListener implements ActionListener {
        
        private static QuestionSet customSet = new QuestionSet(new ArrayList<>());
        @Override
        public void actionPerformed(ActionEvent e) {
            
            File customSetFile = new File(CUSTOM_SET_FILE);
            try {
                //noinspection ResultOfMethodCallIgnored
                customSetFile.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    
            try {
                customSet = new QuestionSet(CUSTOM_SET_FILE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    
    
            JFrame createArea = new JFrame("TRIVIA BOT - CREATE");
            createArea.setDefaultCloseOperation(createArea.DISPOSE_ON_CLOSE);

            createArea.getContentPane().setLayout(new BoxLayout(createArea.getContentPane(), BoxLayout.Y_AXIS));


            //text boxes and labels for Questions input
            JTextField categoryBox = new JTextField(10);
            JTextField questionsBox = new JTextField(10);
            JTextField answersBox = new JTextField(10);
            JLabel categoryInstructions = new JLabel("What category will the question fit:");
            JLabel questionInstructions = new JLabel("Enter a trivia question to add:");
            JLabel answerInstructions = new JLabel("Enter the answer to the question:");


            createArea.getContentPane().add(categoryInstructions);
            createArea.getContentPane().add(categoryBox);
            createArea.getContentPane().add(questionInstructions);
            createArea.getContentPane().add(questionsBox);
            createArea.getContentPane().add(answerInstructions);
            createArea.getContentPane().add(answersBox);

            categoryInstructions.setVisible(true);
            categoryBox.setVisible(true);
            questionInstructions.setVisible(true);
            questionsBox.setVisible(true);
            answerInstructions.setVisible(true);
            answersBox.setVisible(true);

            //button for text boxes
            JButton addQuestion = new JButton("ADD");
            addQuestion.addActionListener(new AddQuestionButtonListener(categoryBox, questionsBox, answersBox));
            createArea.getContentPane().add(addQuestion);


            createArea.pack();
            createArea.setMinimumSize(createArea.getSize());
            createArea.setSize(300, 200);
            createArea.setVisible(true);
        }
        
        public static void addToCustomSet(Question question) {
            customSet.forceCreateQuestion(question);
        }
    }
    
    static class AddQuestionButtonListener implements ActionListener {
        private final JTextField categoryBox;
        private final JTextField questionsBox;
        private final JTextField answersBox;
        
        public AddQuestionButtonListener(JTextField categoryBox, JTextField questionsBox, JTextField answersBox) {
            this.answersBox = answersBox;
            this.questionsBox = questionsBox;
            this.categoryBox = categoryBox;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String category = categoryBox.getText();
            String questionText = questionsBox.getText();
            
            ArrayList<String> answers = new ArrayList<String>() {
                {
                    add(answersBox.getText());
                }
            };
            
            createButtonListener.addToCustomSet(new Question(questionText, answers, category));
        }
    }


    public static void main(String[] args) {
        //frame code
        JFrame MainMenu = new JFrame("TriviaBot");
        
        MainMenu.setDefaultCloseOperation(MainMenu.EXIT_ON_CLOSE);

        //box layout
        MainMenu.setLayout(new GridBagLayout());


        //Add Image
        JLabel triviaImage = new JLabel();
        triviaImage.setIcon(new ImageIcon("trivia.jpg"));
        Dimension size = triviaImage.getPreferredSize();
        triviaImage.setBounds(1000,1000,size.width, size.height);
        MainMenu.add(triviaImage, new GridBagConstraints());



        //Title Text
        JLabel TitleText = new JLabel("Welcome to TriviaBot!");
        MainMenu.getContentPane().add(TitleText);

        //Play Button
        JButton playButton = new JButton("PLAY");
        playButton.addActionListener(new playButtonListener());
        MainMenu.add(playButton, new GridBagConstraints());


        //Create Button
        JButton createButton = new JButton("CREATE");
        createButton.addActionListener(new createButtonListener());
        MainMenu.add(createButton, new GridBagConstraints());
    
        
        MainMenu.pack();
        MainMenu.setMinimumSize(MainMenu.getSize());
        MainMenu.setSize(300, 200);
        MainMenu.setVisible(true);
        }

        
 }



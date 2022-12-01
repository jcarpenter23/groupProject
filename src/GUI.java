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
            JTextField correctanswersBox = new JTextField(10);
            JTextField wronganswersBox1 = new JTextField(10);
            JTextField wronganswersBox2 = new JTextField(10);
            JTextField wronganswersBox3 = new JTextField(10);
            JLabel categoryInstructions = new JLabel("What category will the question fit:");
            JLabel questionInstructions = new JLabel("Enter a trivia question to add:");
            JLabel answerInstructions = new JLabel("Enter the correct answer to the question:");
            JLabel wrongInstructions1 = new JLabel("Enter an incorrect answer to the question:");
            JLabel wrongInstructions2 = new JLabel("Enter a second incorrect answer to the question:");
            JLabel wrongInstructions3 = new JLabel("Enter a third incorrect answer to the question:");



            createArea.getContentPane().add(categoryInstructions);
            createArea.getContentPane().add(categoryBox);
            createArea.getContentPane().add(questionInstructions);
            createArea.getContentPane().add(questionsBox);
            createArea.getContentPane().add(answerInstructions);
            createArea.getContentPane().add(correctanswersBox);
            createArea.getContentPane().add(wrongInstructions1);
            createArea.getContentPane().add(wronganswersBox1);
            createArea.getContentPane().add(wrongInstructions2);
            createArea.getContentPane().add(wronganswersBox2);
            createArea.getContentPane().add(wrongInstructions3);
            createArea.getContentPane().add(wronganswersBox3);

            categoryInstructions.setVisible(true);
            categoryBox.setVisible(true);
            questionInstructions.setVisible(true);
            questionsBox.setVisible(true);
            answerInstructions.setVisible(true);
            correctanswersBox.setVisible(true);
            wrongInstructions1.setVisible(true);
            wronganswersBox1.setVisible(true);
            wrongInstructions2.setVisible(true);
            wronganswersBox2.setVisible(true);
            wrongInstructions3.setVisible(true);
            wronganswersBox3.setVisible(true);

            //button for text boxes
            JButton addQuestion = new JButton("ADD");
            addQuestion.addActionListener(new AddQuestionButtonListener(categoryBox, questionsBox, correctanswersBox, wronganswersBox1, wronganswersBox2, wronganswersBox3));
            createArea.getContentPane().add(addQuestion);


            createArea.pack();
            createArea.setMinimumSize(createArea.getSize());
            createArea.setSize(300, 200);
            createArea.setVisible(true);
        }
        
        public static void addToCustomSet(Question question) {
            customSet.forceCreateQuestion(question);
        }
        
        public static QuestionSet getCustomSet() {
            return customSet;
        }
    }
    
    static class AddQuestionButtonListener implements ActionListener {
        private final JTextField categoryBox;
        private final JTextField questionsBox;
        private final JTextField correctanswersBox;
        private final JTextField wronganswersBox1;
        private final JTextField wronganswersBox2;
        private final JTextField wronganswersBox3;
        
        
        public AddQuestionButtonListener(JTextField categoryBox, JTextField questionsBox, JTextField correctanswersBox, JTextField wronganswersBox1, JTextField wronganswersBox2, JTextField wronganswersBox3) {
            this.questionsBox = questionsBox;
            this.categoryBox = categoryBox;
            this.correctanswersBox = correctanswersBox;
            this.wronganswersBox1 = wronganswersBox1;
            this.wronganswersBox2 = wronganswersBox2;
            this.wronganswersBox3 = wronganswersBox3;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String category = categoryBox.getText();
            String questionText = questionsBox.getText();
            
            ArrayList<String> answers = new ArrayList<String>() {
                {
                    add(correctanswersBox.getText());
                    add(wronganswersBox1.getText());
                    add(wronganswersBox2.getText());
                    add(wronganswersBox3.getText());
                }
            };
            
            createButtonListener.addToCustomSet(new Question(questionText, answers, category));
            
            System.out.println(createButtonListener.getCustomSet());
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



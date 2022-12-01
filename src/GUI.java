import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// handles the program's gui
public class GUI {
    
    private static final String SETS_DIRECTORY = "sets";
    private static final String CUSTOM_SET_FILE = SETS_DIRECTORY + "/custom.set";

    // action listener for "play" button on main menu
    static class playButtonListener implements ActionListener {
        // begins standard game
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JFrame playArea = new JFrame("TRIVIA BOT - PLAY");
            playArea.setDefaultCloseOperation(playArea.DISPOSE_ON_CLOSE);
            
            

            JFileChooser fileChooser = new JFileChooser(SETS_DIRECTORY);
            fileChooser.showOpenDialog(playArea);
            
            File toOpen = fileChooser.getSelectedFile();
            
            QuestionSet questionSet;
            
            try {
                questionSet = new QuestionSet(toOpen.getPath());
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
            
            GameGui gameGui = new GameGui(questionSet);
            
            /*
            JLabel testText = new JLabel(toOpen.getName());
            playArea.getContentPane().add(testText);
    
            playArea.pack();
            playArea.setMinimumSize(playArea.getSize());
            playArea.setSize(300, 200);
            playArea.setVisible(true);
            
             */
        }
    }

    // action listener for "create" button on main menu
    static class createButtonListener implements ActionListener {
        
        private static QuestionSet customSet = new QuestionSet(new ArrayList<>());
        
        // opens question set creation gui. questions created are saved to sets/custom.set
        // if sets/custom.set doesn't exist, it is created when "create" is clicked
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
        
        // adds a question to customSet
        public static void addToCustomSet(Question question) {
            customSet.forceCreateQuestion(question);
        }
        
        // returns customSet
        public static QuestionSet getCustomSet() {
            return customSet;
        }
        
        // saves the contents of customSet to sets/custom.set
        public static void saveCustomSet() {
            try {
                customSet.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // action listener for "add" button in create menu
    static class AddQuestionButtonListener implements ActionListener {
        
        private final ArrayList<JTextField> textFields;
        
        // creates a new action listener with access to 6 text fields (one per question string)
        public AddQuestionButtonListener(JTextField categoryBox, JTextField questionsBox, JTextField correctanswersBox, JTextField wronganswersBox1, JTextField wronganswersBox2, JTextField wronganswersBox3) {
            textFields = new ArrayList<>() {
                {
                    add(categoryBox);
                    add(questionsBox);
                    add(correctanswersBox);
                    add(wronganswersBox1);
                    add(wronganswersBox2);
                    add(wronganswersBox3);
                }
            };
        }
        
        // creates a Question object from the contents of the text fields, adds it to customSet, and saves it to sets/custom.set
        // if category field is blank when "add" is clicked, an IllegalArgumentException is printed to System.err and the question is not added
        // text field contents are cleared upon clicking "add" (even if adding/saving question fails!)
        @Override
        public void actionPerformed(ActionEvent e) {
            String category = textFields.get(0).getText();
            String questionText = textFields.get(1).getText();
            
            ArrayList<String> answers = new ArrayList<>() {
                {
                    for (int i = 2; i < 6; i++) {
                        add(textFields.get(i).getText());
                    }
                }
            };
    
            for (JTextField textField : textFields) {
                textField.setText("");
            }
            
            createButtonListener.addToCustomSet(new Question(questionText, answers, category));
            createButtonListener.saveCustomSet();
        }
    }

    // action listener for "quick play" button on main menu
    static class quickButtonListener implements ActionListener{

        // begins quick play game
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame quickArea = new JFrame("Quick Play");
            quickArea.setDefaultCloseOperation(quickArea.DISPOSE_ON_CLOSE);
            quickArea.getContentPane().setLayout(new BoxLayout(quickArea.getContentPane(), BoxLayout.Y_AXIS));

            JLabel players = new JLabel("How many players will participate?");
            JTextField playerEntry = new JTextField(20);

            JButton playerContinue = new JButton("Continue");
            playerContinue.addActionListener(new continuedplayButtonListener());


            quickArea.getContentPane().add(players);
            quickArea.getContentPane().add(playerEntry);
            quickArea.getContentPane().add(playerContinue);


            players.setVisible(true);
            playerEntry.setVisible(true);
            playerContinue.setVisible(true);


            quickArea.pack();
            quickArea.setMinimumSize(quickArea.getSize());
            quickArea.setSize(300, 200);
            quickArea.setVisible(true);

        }
    }
    
    // action listener for "continue button" on quick play menu
    static class continuedplayButtonListener implements ActionListener{

        // opens player name entry
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame playerNames = new JFrame("Quick Play");
            playerNames.setDefaultCloseOperation(playerNames.DISPOSE_ON_CLOSE);
            playerNames.getContentPane().setLayout(new BoxLayout(playerNames.getContentPane(), BoxLayout.Y_AXIS));

            JLabel namesOfPlayers = new JLabel("Enter player names:");
            JTextArea playersInput = new JTextArea();
            
            JScrollPane scrollPane = new JScrollPane(playersInput);

            JButton GamePlay = new JButton("Lets Play");
            GamePlay.addActionListener(new letsPlayButtonListener());


            playerNames.getContentPane().add(namesOfPlayers);
            playerNames.getContentPane().add(scrollPane);
            playerNames.getContentPane().add(GamePlay);


            namesOfPlayers.setVisible(true);
            scrollPane.setVisible(true);
            GamePlay.setVisible(true);


            playerNames.pack();
            playerNames.setMinimumSize(playerNames.getSize());
            playerNames.setSize(300, 200);
            playerNames.setVisible(true);

        }
    }

    //action listener for when the user decides to continue with quick play - asks if they are ready to begin
    static class letsPlayButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame getReady = new JFrame("Quick Play");
            getReady.setDefaultCloseOperation(getReady.DISPOSE_ON_CLOSE);
            getReady.getContentPane().setLayout(new BoxLayout(getReady.getContentPane(), BoxLayout.Y_AXIS));

            JLabel introText = new JLabel("Player 1 - Are You Ready?");

            JButton yesPlay = new JButton("Yes, Let's Play!");
            JButton noPlay = new JButton("No, take me back!");

            getReady.getContentPane().add(introText);
            getReady.getContentPane().add(yesPlay);
            getReady.getContentPane().add(noPlay);

            introText.setVisible(true);
            yesPlay.setVisible(true);
            noPlay.setVisible(true);

            getReady.pack();
            getReady.setMinimumSize(getReady.getSize());
            getReady.setSize(300, 200);
            getReady.setVisible(true);
        }
    }


    // opens main menu
    public static void main(String[] args) {

        //look and feel of system
        UIManager.LookAndFeelInfo[] options = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo option : options) {
            System.out.println(option.getClassName());
        }

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch(Exception e) {
            System.out.println("Could not set the look and feel.");
        }

        //frame code

        JFrame MainMenu = new JFrame("TriviaBot");
        
        MainMenu.setDefaultCloseOperation(MainMenu.EXIT_ON_CLOSE);


        //box layout
        MainMenu.setLayout(new GridBagLayout());

        //Title Text
        JLabel TitleText = new JLabel("Welcome to TriviaBot!");
        TitleText.setVisible(true);
        MainMenu.getContentPane().add(TitleText);

        //Play Button
        JButton playButton = new JButton("PLAY");
        playButton.addActionListener(new playButtonListener());
        MainMenu.add(playButton, new GridBagConstraints());


        //Create Button
        JButton createButton = new JButton("CREATE");
        createButton.addActionListener(new createButtonListener());
        MainMenu.add(createButton, new GridBagConstraints());

        //Random Play
        JButton quickplayButton = new JButton("QUICK PLAY");
        quickplayButton.addActionListener(new quickButtonListener());
        MainMenu.add(quickplayButton, new GridBagConstraints());
    

        MainMenu.pack();
        MainMenu.setMinimumSize(MainMenu.getSize());
        MainMenu.setSize(300, 200);
        MainMenu.setVisible(true);
        }

        
 }



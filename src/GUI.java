import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {
    
    private static final String SETS_DIRECTORY = "sets";

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
        @Override
        public void actionPerformed(ActionEvent e) {
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
            createArea.getContentPane().add(addQuestion);


            createArea.pack();
            createArea.setMinimumSize(createArea.getSize());
            createArea.setSize(300, 200);
            createArea.setVisible(true);
        }
    }

    static class quickButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame quickArea = new JFrame("TRIVIA BOT - CREATE");
            quickArea.setDefaultCloseOperation(quickArea.DISPOSE_ON_CLOSE);
            quickArea.getContentPane().setLayout(new BoxLayout(quickArea.getContentPane(), BoxLayout.Y_AXIS));

            JLabel players = new JLabel("How many players will participate?");
            JTextField playerEntry = new JTextField(20);

            JButton playerContinue = new JButton("Continue");


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



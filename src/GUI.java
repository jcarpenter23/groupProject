import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    static class playButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame playArea = new JFrame("TRIVIA BOT - PLAY");
            playArea.setDefaultCloseOperation(playArea.DISPOSE_ON_CLOSE);
            playArea.setSize(10000, 10000);
            playArea.pack();
            playArea.setVisible(true);
        }
    }

    static class createButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame createArea = new JFrame("TRIVIA BOT - CREATE");
            createArea.setDefaultCloseOperation(createArea.DISPOSE_ON_CLOSE);
            createArea.setSize(10000, 10000);
            //display frame
            createArea.pack();
            createArea.setVisible(true);

            //text boxes for Questions input
            JTextField questionsBox = new JTextField(200);
            JTextField answersBox = new JTextField(200);
            createArea.getContentPane().add(questionsBox);
            createArea.getContentPane().add(answersBox);
            questionsBox.setVisible(true);
            answersBox.setVisible(true);

            //button for text boxes
            JButton addQuestion = new JButton("ADD");
            createArea.getContentPane().add(addQuestion);


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



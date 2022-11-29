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
            createArea.pack();
            createArea.setVisible(true);

        }
    }





    public static void main(String[] args) {

        //frame code
        JFrame MainMenu = new JFrame("TriviaBot");
        MainMenu.setDefaultCloseOperation(MainMenu.EXIT_ON_CLOSE);
        MainMenu.setSize(10000,10000);
        MainMenu.pack();
        MainMenu.setVisible(true);

        //Add Image
        JLabel triviaImage = new JLabel();
        triviaImage.setIcon(new ImageIcon("trivia.jpg"));
        Dimension size = triviaImage.getPreferredSize();
        triviaImage.setBounds(50,30,size.width, size.height);
        MainMenu.add(triviaImage);

        //box layout
        MainMenu.setLayout(new GridBagLayout());

        //Title Text
        JLabel TitleText = new JLabel("Welcome to TriviaBot!");
        MainMenu.add(TitleText, new GridBagConstraints());
        //Play Button
        JButton playButton = new JButton("PLAY");
        playButton.addActionListener(new playButtonListener());
        MainMenu.add(playButton, new GridBagConstraints());

        //Create Button
        JButton createButton = new JButton("CREATE");
        createButton.addActionListener(new createButtonListener());
        MainMenu.add(createButton, new GridBagConstraints());

        }
    }




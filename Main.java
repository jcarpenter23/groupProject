import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Color;


public class Main {
    public static void main(String[] args) {
        //Button Listener - done button
        class doneButton implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
            //add and run replace, save method
            }
        }

        //Button Listener 1
        class ButtonListener1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1 (edit madlib story)
                JFrame frame1 = new JFrame("Edit MadLib Stories");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.getContentPane().setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));
                frame1.setSize(700,700);
                frame1.setVisible(true);
                JLabel nounPrompt = new JLabel("Enter 10 nouns for your story: ");
                JTextField nounsText = new JTextField();
                frame1.getContentPane().add(nounPrompt);
                frame1.getContentPane().add(nounsText);
                JLabel verbPrompt = new JLabel("Enter 10 verbs for your story: ");
                JTextField verbText = new JTextField();
                frame1.getContentPane().add(verbPrompt);
                frame1.getContentPane().add(verbText);
                JLabel adjectivePrompt = new JLabel("Enter 10 adjectives for your story: ");
                JTextField adjectiveText = new JTextField();
                frame1.getContentPane().add(adjectivePrompt);
                frame1.getContentPane().add(adjectiveText);
                JButton doneButton = new JButton("DONE");
                doneButton.addActionListener((new doneButton()));
                frame1.getContentPane().add(doneButton);
            }
        }
        /*
        //Button Listener 2
        class ButtonListener2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 2 (read completed stories)
                JFrame frame2 = new JFrame("Completed Stories");
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.getContentPane().setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));
                frame2.setSize(700,700);
                frame2.setVisible(true);

            }
        }
        //Button Listener 3
        class ButtonListener3 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 3 (view unedited stories)
                JFrame frame3 = new JFrame("View Templates");
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.getContentPane().setLayout(new BoxLayout(frame3.getContentPane(), BoxLayout.Y_AXIS));
                JTextField field1 = new JTextField(3);
                frame3.getContentPane().add(field1);
                frame3.setSize(700,700);
                frame3.setVisible(true);

            }
        }
         */

        //GUI setup (frame, labels, and layout)
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(700,700);
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(Color.black);
        JLabel label1 = new JLabel("Welcome to your MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);
        //GUI buttons
        JButton button1 = new JButton("Edit your own MadLib Story");
        button1.addActionListener(new ButtonListener1());
        frame.getContentPane().add(button1);
        button1.setPreferredSize(new Dimension(50, 50));
        /*
        JButton button2 = new JButton("Read completed stories");
        button1.addActionListener(new ButtonListener2());
        frame.getContentPane().add(button2);
        JButton button3 = new JButton("View template stories");
        button1.addActionListener(new ButtonListener3());
        frame.getContentPane().add(button3);

         */

    }

    public static ArrayList<String> getStories() {
        File storyDirectory = new File("stories/");
        String[] storyList = storyDirectory.list();
        ArrayList<String> stories = new ArrayList<>();
        for (String story : storyList) {
            stories.add(story);
        }

        return stories;
    }
    public static void printStories() {
        getStories();
        int count = 0;
        for (int i = 0; i < getStories().size(); i++) {
            count++;
            System.out.println(count + ". " + getStories().get(i));
        }
    }
    public static Story chooseStory() {

        int pickStory = getStories().size() + 1;
        while (pickStory > getStories().size()) {
            System.out.println("Please choose an available story.");
            printStories();
            Scanner scan = new Scanner(System.in);
            try {
                pickStory = scan.nextInt();
            } catch (InputMismatchException e){
                pickStory = getStories().size() + 1;
            }
        }
        String storyToRead = getStories().get(pickStory - 1);
        System.out.println(storyToRead);
        Story chosenStory = new Story("stories/" + storyToRead);
        return chosenStory;
    }
    public static void menu(){
        //try to create a Words object to save input to
        String userInput = null;
        Words user=new Words(userInput);

        Scanner scan = new Scanner(System.in);
        //get user to input nouns, adjectives, and verbs
        //save user's input to the user Words object
        System.out.println("Enter some nouns, type 'done' when finished");
        userInput = scan.nextLine();
        while(!userInput.equals("done")){
            user.getNouns().add(userInput);
            userInput = scan.nextLine();
        }
        System.out.println("Enter some verbs, type 'done' when finished");
        userInput = scan.nextLine();
        while(!userInput.equals("done")){
            user.getVerbs().add(userInput);
            userInput = scan.nextLine();
        }
        System.out.println("Enter some adjectives, type 'done' when finished");
        userInput = scan.nextLine();
        while(!userInput.equals("done")){
            user.getAdjectives().add(userInput);
            userInput = scan.nextLine();
        }
        System.out.println("Nouns Entered: "+ user.getNouns());
        System.out.println("Verbs Entered: "+ user.getVerbs());
        System.out.println("Adjectives Entered: "+ user.getAdjectives());
        getStories();
        Story story1=chooseStory();
        //turns words in story to a word object/big String
        story1.read();

        //prints string of words without replacing
        System.out.println(story1.getWordsInStory().getString());
        //replaces user inputed words
        story1.replace(user);
        //creates new file with replaced words
        story1.saveStory();

    }
}

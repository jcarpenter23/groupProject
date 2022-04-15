
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static ArrayList<String> getStories() {
        File storyDirectory = new File("stories/");
        String[] storyList = storyDirectory.list();
        int count = 0;
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
            System.out.println("Please choose an available deck.");
            printStories();
            Scanner scan = new Scanner(System.in);
            try {
                pickStory = scan.nextInt();
            } catch (InputMismatchException e){pickStory = getStories().size() + 1;}
        }
        String storyToRead = getStories().get(pickStory - 1);
        Story chosenStory = new Story(storyToRead);
        return chosenStory;
    }


    public static void main(String[] args) {

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
        Story story1=new Story(".idea/MadLibOne.story");
        story1.read();
        story1.replace(user);
        story1.saveStory();

        System.out.println("Done Runnning");

        /*
        //Button Listener 1
        class ButtonListener1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1
            }
        }
        //Button Listener 2
        class ButtonListener2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 2
            }
        }
        //Button Listener 3
        class ButtonListener3 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 3
            }
        }

        //GUI setup (frame, labels, and layout)
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(700,700);
        JLabel label1 = new JLabel("Welcome to your MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);
        frame.setVisible(true);
        //GUI buttons
        JButton button1 = new JButton("Edit your own MadLib Story");
        button1.addActionListener(new ButtonListener1());
        frame.getContentPane().add(button1);
        JButton button2 = new JButton("Read completed stories");
        button1.addActionListener(new ButtonListener2());
        frame.getContentPane().add(button2);
        JButton button3 = new JButton("View template stories");
        button1.addActionListener(new ButtonListener3());
        frame.getContentPane().add(button3);
        */

    }
}

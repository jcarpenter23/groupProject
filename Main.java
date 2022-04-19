import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.awt.Color;


public class Main {
    public static void main(String[] args) {

        //Button Listener - done button
        class doneButton implements ActionListener{
           // JTextArea input;
            //String inputText= input.getText();
            //ArrayList<String> nounies=new ArrayList<> (List.of(inputText.split(" ")));


            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame finishedStory = new JFrame("Your story");
            //String text = input.getText();
            //Words wordsConvert = new Words(text);
            finishedStory.setDefaultCloseOperation(finishedStory.EXIT_ON_CLOSE);
            finishedStory.getContentPane().setLayout(new BoxLayout(finishedStory.getContentPane(), BoxLayout.Y_AXIS));
            finishedStory.setSize(700,700);
            finishedStory.setVisible(true);

            }
           // doneButton (JTextArea input) {
             //   this.input = input;
        }

        //Edit Stories - Button Listener 1
        class EditStories implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1 (edit madlib story)
                JFrame frame1 = new JFrame("Edit MadLib Stories");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.getContentPane().setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));
                frame1.setSize(700,700);
                frame1.setVisible(true);
                JLabel nounPrompt = new JLabel("Enter 10 nouns, verbs, and adjectives for your story: ");
                JTextArea input = new JTextArea(5,5);
                frame1.getContentPane().add(nounPrompt);
                frame1.getContentPane().add(input);
                //done and back button
                JButton doneButton = new JButton("DONE");
                //doneButton.addActionListener((new doneButton()));
                frame1.getContentPane().add(doneButton);
                JButton backButton1 = new JButton("BACK");
                frame1.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    frame1.dispose();
                });
            }
        }


        //printing template button listeners
        class story1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame printStory1 = new JFrame("Story One");
            printStory1.setDefaultCloseOperation(printStory1.EXIT_ON_CLOSE);
            printStory1.getContentPane().setLayout(new BoxLayout(printStory1.getContentPane(), BoxLayout.Y_AXIS));
            printStory1.setSize(700,700);
            printStory1.setVisible(true);
            JLabel STORYONE = new JLabel("<html>American children are fascinated by *ADJECTIVE* stuff-like Stories that scare the *NOUN* off them or make their" +
                    " *NOUN* stand on end. Scientists say this is because being frightened causes the *NOUN* gland to function and puts\n" +
                    " *NOUN* into their blood. And everyone knows that makes kids feet *ADJECTIVE* . When they are scared by a movie or an *NOUN* ,\n" +
                    "boys laugh and holler and *VERB* . But girls cover their eyes with their *NOUN* and keep screaming and *VERB* . Most kids get\n" +
                    "over this by the time they are 67 years old. Then they like movies about cars *VERB* or cops shooing *NOUN*");
                printStory1.getContentPane().add(STORYONE);
                JButton backButton1 = new JButton("BACK");
                printStory1.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    printStory1.dispose();
                });
            }
        }
        class story2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame printStory2 = new JFrame("Story Two");
                printStory2.setDefaultCloseOperation(printStory2.EXIT_ON_CLOSE);
                printStory2.getContentPane().setLayout(new BoxLayout(printStory2.getContentPane(), BoxLayout.Y_AXIS));
                printStory2.setSize(700,700);
                printStory2.setVisible(true);
                JLabel STORYTWO = new JLabel("<html>It was a *ADJECTIVE* summer day. *NOUN* and I were excited to go camping at *NOUN*. It was my first time going there. I packed\n" +
                        "my favorite *NOUN* . It is *ADJECTIVE* and *ADJECTIVE* . Perfect for camping! On the road we went in our *ADJECTIVE* *ADJECTIVE* van!\n" +
                        "We were listening to *NOUN* all the way down. The Drive was about 5 hours but it was so worth it. I could smell meat being cooked.\n" +
                        "It smelled *ADJECTIVE* . I *VERB* to the room I was staying in with my *NOUN* . The next thing I knew, *NOUN* came and *VERB* on the bed.\n" +
                        "Over the next few days I got to, *VERB* , *VERB* , and *VERB* . My camping trip was *ADJECTIVE* .");
                printStory2.getContentPane().add(STORYTWO);
                JButton backButton2 = new JButton("BACK");
                printStory2.getContentPane().add(backButton2);
                backButton2.addActionListener(e1 -> {
                    printStory2.dispose();
                });
            }
        }
        class story3 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame printStory3 = new JFrame("Story Three");
                printStory3.setDefaultCloseOperation(printStory3.EXIT_ON_CLOSE);
                printStory3.getContentPane().setLayout(new BoxLayout(printStory3.getContentPane(), BoxLayout.Y_AXIS));
                printStory3.setSize(700,700);
                printStory3.setVisible(true);
                JLabel STORYTHREE = new JLabel("<html>My cubicle is *ADJECTIVE*. I have a *NOUN* on my desk next to a(n) *ADJECTIVE* *NOUN* . In my drawer, I also have a(n) *ADJECTIVE*\n" +
                        "*NOUN* . One time a coworker tried to *VERB* a *NOUN* on my desk. I said to him, \"Hey!\" how would you like it if I *VERB* your\n" +
                        " *NOUN* ? I'll do it if you don't leave.\n" +
                        "My one complaint about my cubicle is that it is *ADJECTIVE* . I think everyone here at the office complains about this.\n" +
                        "We also complain tat our cubicle is *ADJECTIVE* . If we had money in our budget, my boss could purchase some *NOUN* to help\n" +
                        "alleviate this problem. Our boss doesn't understand. His office is the size of *NOUN* . He has enough room in his office to\n" +
                        "put a *NOUN* and a *NOUN* in there.");
                printStory3.getContentPane().add(STORYTHREE);
                JButton backButton3 = new JButton("BACK");
                printStory3.getContentPane().add(backButton3);
                backButton3.addActionListener(e1 -> {
                    printStory3.dispose();
                });
            }
        }

        //Completed Stories - button listener 2
        class TemplateStories implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 2 (read completed stories)
                JFrame frame2 = new JFrame("Template Stories");
                frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
                frame2.getContentPane().setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));
                frame2.setSize(700,700);
                frame2.setVisible(true);
                JLabel storyList = new JLabel("Here are a list of your available templates:");
                JLabel space = new JLabel("           ");
                frame2.getContentPane().add(storyList);
                frame2.getContentPane().add(space);
                //print completed stories
                JLabel storyList1 = new JLabel("Which would you like to choose");
                frame2.getContentPane().add(storyList1);
                JButton story1 = new JButton("Story One");         ///TITLE???
                frame2.getContentPane().add(story1);
                story1.addActionListener(new story1());
                JButton story2 = new JButton("Story Two");        ///TITLE???
                frame2.getContentPane().add(story2);
                story2.addActionListener(new story2());
                JButton story3 = new JButton("Story Three");        ///TITLE???
                frame2.getContentPane().add(story3);
                story3.addActionListener(new story3());
                JButton backButton1 = new JButton("BACK");
                frame2.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    frame2.dispose();
                });
            }
        }

        //View templates - Button Listener 3
        class CompletedStories implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 3 (view unedited stories)
                JFrame frame3 = new JFrame("Completed Stories");
                frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
                frame3.getContentPane().setLayout(new BoxLayout(frame3.getContentPane(), BoxLayout.Y_AXIS));
                JLabel templateWords = new JLabel("Here are your completed stories - which would you like to view?");
                frame3.getContentPane().add(templateWords);


                JButton backButton1 = new JButton("BACK");
                frame3.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    frame3.dispose();
                });

            }
        }

        //GUI setup (frame, labels, and layout)
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        JLabel label1 = new JLabel("Welcome to your MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);
        //GUI buttons
        JButton button1 = new JButton("Edit your own MadLib Story");
        button1.addActionListener(new EditStories());
        frame.getContentPane().add(button1);
        button1.setPreferredSize(new Dimension(50, 50));

        JButton button2 = new JButton("View Template Stories");
        button2.addActionListener(new TemplateStories());
        frame.getContentPane().add(button2);
        button2.setPreferredSize(new Dimension(50,50));


        JButton button3 = new JButton("View Completed Stories");
        button3.addActionListener(new CompletedStories());
        frame.getContentPane().add(button3);
        button3.setPreferredSize(new Dimension(50,50));

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

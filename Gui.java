import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gui {
    public static void gui() {

        //done button for Story One - appears after input for story has been entered
        //takes the input, replaces it within the template story, and prints out a new frame with the completed story
        class doneButton1 implements ActionListener {
            JTextArea input;

            doneButton1(JTextArea input) {
                this.input = input;
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                Story story1 = new Story("stories/MadLibsOne.story");
                String inputText = input.getText();
                Words wordle = new Words(inputText);
                ArrayList<String> wordies = new ArrayList<>(List.of(inputText.split(" ")));
                int i = 0;
                while (i <= 9) {
                    wordle.getNouns().add(wordies.get(i));
                    i++;
                }
                while (i <= 19) {
                    wordle.getVerbs().add(wordies.get(i));
                    i++;
                }
                while (i <= 29) {
                    wordle.getAdjectives().add(wordies.get(i));
                    i++;
                }
                //turns default words in story to a word object/big String
                story1.read();
                //replaces user words
                story1.replace(wordle);
                //creates new file with replaced words
                story1.saveStory1();
                //get the written story, convert to string
                Scanner in = null;
                try {
                    in = new Scanner(new File("MadLibOneWritten.story"));
                } catch (FileNotFoundException f) {
                    f.printStackTrace();
                }
                String s = in.nextLine();
                while (in.hasNextLine()) {
                    s = s + in.nextLine();
                }

                //creates new frame
                JFrame finishedStory = new JFrame("Your story");

                finishedStory.setDefaultCloseOperation(finishedStory.EXIT_ON_CLOSE);
                finishedStory.getContentPane().setLayout(new BoxLayout(finishedStory.getContentPane(), BoxLayout.Y_AXIS));
                finishedStory.setSize(700, 700);
                finishedStory.setVisible(true);
                JButton backButton1 = new JButton("BACK");
                finishedStory.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    finishedStory.dispose();
                });
                JLabel finalstory1 = new JLabel("<html>" + s);
                finalstory1.setBounds(10, 10, 300, 100);
                finishedStory.getContentPane().add(finalstory1);

            }
        }

        //done button for Story Two - appears after input for story has been entered
        //takes the input, replaces it within the template story, and prints out a new frame with the completed story
        class doneButton2 implements ActionListener {
            JTextArea input;

            doneButton2(JTextArea input) {
                this.input = input;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                Story story2 = new Story("stories/MadLibsTwo.story");
                String inputText = input.getText();
                Words wordle = new Words(inputText);
                ArrayList<String> wordies = new ArrayList<>(List.of(inputText.split(" ")));
                int i = 0;
                while (i <= 9) {
                    wordle.getNouns().add(wordies.get(i));
                    i++;
                }
                while (i <= 19) {
                    wordle.getVerbs().add(wordies.get(i));
                    i++;
                }
                while (i <= 29) {
                    wordle.getAdjectives().add(wordies.get(i));
                    i++;
                }
                //turns default words in story to a word object/big String
                story2.read();
                //replaces user words
                story2.replace(wordle);
                //creates new file with replaced words
                story2.saveStory2();

                Scanner in = null;
                try {
                    in = new Scanner(new File("MadLibTwoWritten.story"));
                } catch (FileNotFoundException f) {
                    f.printStackTrace();
                }
                String s = in.nextLine();
                while (in.hasNextLine()) {
                    s = s + in.nextLine();
                }

                // creates new frame and buttons
                JFrame finishedStory2 = new JFrame("Your story");

                finishedStory2.setDefaultCloseOperation(finishedStory2.EXIT_ON_CLOSE);
                finishedStory2.getContentPane().setLayout(new BoxLayout(finishedStory2.getContentPane(), BoxLayout.Y_AXIS));
                finishedStory2.setSize(700, 700);
                finishedStory2.setVisible(true);
                JButton backButton1 = new JButton("BACK");
                finishedStory2.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    finishedStory2.dispose();
                });
                JLabel finalstory2 = new JLabel("<html>" + s);
                finalstory2.setBounds(10, 10, 300, 100);
                finishedStory2.getContentPane().add(finalstory2);
            }
        }

        //done button for Story Three - appears after input for story has been entered
        //takes the input, replaces it within the template story, and prints out a new frame with the completed story
        class doneButton3 implements ActionListener {
            JTextArea input;

            doneButton3(JTextArea input) {
                this.input = input;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                Story story3 = new Story("stories/MadLibsThree.story");
                String inputText = input.getText();
                Words wordle = new Words(inputText);
                ArrayList<String> wordies = new ArrayList<>(List.of(inputText.split(" ")));
                int i = 0;
                while (i <= 9) {
                    wordle.getNouns().add(wordies.get(i));
                    i++;
                }
                while (i <= 19) {
                    wordle.getVerbs().add(wordies.get(i));
                    i++;
                }
                while (i <= 29) {
                    wordle.getAdjectives().add(wordies.get(i));
                    i++;
                }
                //turns default words in story to a word object/big String
                story3.read();
                //replaces words
                story3.replace(wordle);
                //creates new file with replaced words
                story3.saveStory3();

                Scanner in = null;
                try {
                    in = new Scanner(new File("MadLibThreeWritten.story"));
                } catch (FileNotFoundException f) {
                    f.printStackTrace();
                }
                String s = in.nextLine();
                while (in.hasNextLine()) {
                    s = s + in.nextLine();
                }

                //creates new frame
                JFrame finishedStory3 = new JFrame("Your story");

                finishedStory3.setDefaultCloseOperation(finishedStory3.EXIT_ON_CLOSE);
                finishedStory3.getContentPane().setLayout(new BoxLayout(finishedStory3.getContentPane(), BoxLayout.Y_AXIS));
                finishedStory3.setSize(700, 700);
                finishedStory3.setVisible(true);
                JButton backButton1 = new JButton("BACK");
                finishedStory3.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    finishedStory3.dispose();
                });
                JLabel finalstory3 = new JLabel("<html>" + s);
                finalstory3.setBounds(10, 10, 300, 100);
                finishedStory3.getContentPane().add(finalstory3);
            }
        }

        //edit Story One (Button Listener)
        //for Story One, the frame and text area is created for the user to input their 10 nouns, verbs and adjectives
        //a done and back buttons are also created
        class storyone implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1 (edit madlib story)
                JFrame frame1 = new JFrame("Edit MadLib Stories");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.getContentPane().setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));
                frame1.setSize(700, 700);
                frame1.setVisible(true);
                JLabel nounPrompt = new JLabel("Enter 10 nouns, verbs, and adjectives for your story: ");
                JTextArea input = new JTextArea(5, 5);
                frame1.getContentPane().add(nounPrompt);
                frame1.getContentPane().add(input);
                //done and back button
                JButton doneButton1 = new JButton("DONE");
                frame1.getContentPane().add(doneButton1);
                doneButton1.addActionListener((new doneButton1(input)));
                JButton backButton1 = new JButton("BACK");
                frame1.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    frame1.dispose();
                });
            }
        }

        //edit Story Two (Button Listener)
        //for Story Two, the frame and text area is created for the user to input their 10 nouns, verbs and adjectives
        //a done and back buttons are also created
        class storytwo implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1 (edit madlib story)
                JFrame frame1 = new JFrame("Edit MadLib Stories");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.getContentPane().setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));
                frame1.setSize(700, 700);
                frame1.setVisible(true);
                JLabel nounPrompt = new JLabel("Enter 10 nouns, verbs, and adjectives for your story: ");
                JTextArea input = new JTextArea(5, 5);
                frame1.getContentPane().add(nounPrompt);
                frame1.getContentPane().add(input);
                //done and back button
                JButton doneButton2 = new JButton("DONE");
                doneButton2.addActionListener((new doneButton2(input)));
                frame1.getContentPane().add(doneButton2);
                JButton backButton1 = new JButton("BACK");
                frame1.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    frame1.dispose();
                });
            }
        }

        //edit Story Three (Button Listener)
        //for Story Three, the frame and text area is created for the user to input their 10 nouns, verbs and adjectives
        //a done and back buttons are also created
        class storythree implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 1 (edit madlib story)
                JFrame frame1 = new JFrame("Edit MadLib Stories");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.getContentPane().setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));
                frame1.setSize(700, 700);
                frame1.setVisible(true);
                JLabel nounPrompt = new JLabel("Enter 10 nouns, verbs, and adjectives for your story: ");
                JTextArea input = new JTextArea(5, 5);
                frame1.getContentPane().add(nounPrompt);
                frame1.getContentPane().add(input);
                //done and back button
                JButton doneButton3 = new JButton("DONE");
                doneButton3.addActionListener((new doneButton3(input)));
                frame1.getContentPane().add(doneButton3);
                JButton backButton1 = new JButton("BACK");
                frame1.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    frame1.dispose();
                });
            }
        }

        //this button listener runs after the user has decided that they want to "Edit a MadLib Story"
        //creates a new frame, prompts them to pick which story they would like to edit
        //creates a back button for the user to back out and pick another story
        class pickStory implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pick = new JFrame("Pick your Story");
                pick.setDefaultCloseOperation(pick.EXIT_ON_CLOSE);
                pick.getContentPane().setLayout(new BoxLayout(pick.getContentPane(), BoxLayout.Y_AXIS));
                pick.setSize(700, 700);
                pick.setVisible(true);
                JLabel pickPrompt = new JLabel("Which Story would you like to pick:");
                pick.getContentPane().add(pickPrompt);
                JButton storyone = new JButton("Story One");
                storyone.addActionListener(new storyone());
                JButton storytwo = new JButton("Story Two");
                storytwo.addActionListener(new storytwo());
                JButton storythree = new JButton("Story Three");
                storythree.addActionListener(new storythree());
                pick.getContentPane().add(storyone);
                pick.getContentPane().add(storytwo);
                pick.getContentPane().add(storythree);
                JButton backButton1 = new JButton("BACK");
                pick.getContentPane().add(backButton1);
                backButton1.addActionListener(e1 -> {
                    pick.dispose();
                });
            }
        }


        //view template stories - Story One
        //this button creates a new frame that then prints out the story template that is pulled from a file
        //a back button is created to close the window and allows the user to pick another story
        class story1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame printStory1 = new JFrame("Story One");
                printStory1.setDefaultCloseOperation(printStory1.EXIT_ON_CLOSE);
                printStory1.getContentPane().setLayout(new BoxLayout(printStory1.getContentPane(), BoxLayout.Y_AXIS));
                printStory1.setSize(700, 700);
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

        //view template stories - Story Two
        //this button creates a new frame that then prints out the story template that is pulled from a file
        //a back button is created to close the window and allows the user to pick another story
        class story2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame printStory2 = new JFrame("Story Two");
                printStory2.setDefaultCloseOperation(printStory2.EXIT_ON_CLOSE);
                printStory2.getContentPane().setLayout(new BoxLayout(printStory2.getContentPane(), BoxLayout.Y_AXIS));
                printStory2.setSize(700, 700);
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

        //view template stories - Story Three
        //this button creates a new frame that then prints out the story template that is pulled from a file
        //a back button is created to close the window and allows the user to pick another story
        class story3 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame printStory3 = new JFrame("Story Three");
                printStory3.setDefaultCloseOperation(printStory3.EXIT_ON_CLOSE);
                printStory3.getContentPane().setLayout(new BoxLayout(printStory3.getContentPane(), BoxLayout.Y_AXIS));
                printStory3.setSize(700, 700);
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

        //view Template Stories Button
        //creates a new frame, lists out the available stories for the user to choose from which would eventually display
        //creates buttons for each story and a back button as well
        class TemplateStories implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method calls for button 2 (read completed stories)
                JFrame frame2 = new JFrame("Template Stories");
                frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
                frame2.getContentPane().setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));
                frame2.setSize(700, 700);
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


        //initial GUI setup (frame, labels, and layout)
        //this creates the first frame the user sees on opening and prints out the buttons for acitivity options
        JFrame frame = new JFrame("MadLibs Creator");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        JLabel label1 = new JLabel("Welcome to your MadLibs Creator. From the menu, click a button to start your adventure!");
        frame.getContentPane().add(label1);

        JButton pickStory = new JButton("Edit your own MadLib Story");
        pickStory.addActionListener(new pickStory());
        frame.getContentPane().add(pickStory);
        pickStory.setPreferredSize(new Dimension(50, 50));

        JButton button2 = new JButton("View Template Stories");
        button2.addActionListener(new TemplateStories());
        frame.getContentPane().add(button2);
        button2.setPreferredSize(new Dimension(50, 50));

    }
}


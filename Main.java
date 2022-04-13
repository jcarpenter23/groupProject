import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static ArrayList<String> getStory() {
        //This creates a List of stories and stores them in a ArrayList
        ArrayList<String> storyList = new ArrayList<>();
        Scanner in = new Scanner(System.in);


        //Leads the file to the directory with the stories
        File f = new File("storys");

        //This is to filter the names of the files
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith("story");
            }
        };
        //This is to story the inital files in a Array to hold them
        File storyFile[] = f.listFiles(filter);


        //To check if the storyFile array is empty or not
        if (storyFile == null) {
            System.out.println("THERE ARE NO FILES");
        }
        else
            for (int o = 0; o < storyFile.length; o++) {
                //System.out.println(o+ "\"" + deckFiles[o].getName());
                storyList.add(storyFile[o].getName());
            }//Reads through the Storyfiles and adds them to the arraylist

        return storyList;
    }

    public static Story chooseStory() {
        //This code is to Story the list of stories from the getStory method and allows the user to select the story
        //they want to use.
        ArrayList<String> listOfStory;
        listOfStory = getStory();
        int storyChoice;
        Scanner in = new Scanner(System.in);
        for(int o = 0; o < listOfStory.size(); o ++) {
            System.out.println(o + listOfStory.get(o));
        }

        System.out.println("Which story would you like to use?");
        storyChoice = in.nextInt();
        Story story = new Story("storys/" + listOfStory.get(storyChoice));

        System.out.println("This has been selected:" + listOfStory.get(storyChoice));

        return story;
    }


    public static void main(String[] args) {

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


    }
}

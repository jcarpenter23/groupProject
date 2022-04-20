import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.awt.Color;


public class Main {
    public static void main(String[] args) {
        Gui.gui();
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
}

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> getStory() {
        ArrayList<String> storyList = new ArrayList<>();

        File f = new File("story");

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith("story");
            }
        };
        File storyFiles[] = f.listFiles(filter);

        if ( storyFiles == null ) {
            System.out.println("THERE ARE NO FILES");
        } else
            for (int o = 0; o < storyFiles.length; o++) {
                storyList.add(storyFiles[o].getName());
            }

        return storyList;
    }
    public static Story chooseStory() {
        ArrayList<String> listOfStories;
        listOfStories = getStory();
        int storyChoice;
        Scanner in = new Scanner(System.in);
        for(int o = 0; o < listOfStories.size(); o ++) {
            System.out.println(o + listOfStories.get(o));
        }

        System.out.println("Which deck would you like to use?");
        storyChoice = in.nextInt();
        Story story = new Story("storys/" + listOfStories.get(storyChoice));

        System.out.println("This has been selected:" +listOfStories.get(storyChoice));

        return story;
    }

}

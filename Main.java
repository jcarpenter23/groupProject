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
                //System.out.println(o+ "\"" + deckFiles[o].getName());
                storyList.add(storyFiles[o].getName());
            }

        return storyList;
    }
}

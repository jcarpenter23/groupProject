import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Story {
    private String fileName;

    public Story(String fileName) {
        this.fileName = fileName;
    }

    public void replace(String input, String initial){

    }

    public void save(){

    }

    public void saveStories() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter write = new PrintWriter(fileWriter);
        words.saveWords(write);
    }

}

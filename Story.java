import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Story {

    private String fileName;


    public Story (String fileName) {
        this.fileName = fileName;
    }

    public void read(String fileName) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        File inputFile = new File(fileName);
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*public void replace(String input, String initial){

    }

    public void save(){

    }

    public void saveStories() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter write = new PrintWriter(fileWriter);
        words.saveWords(write);
    } */

}

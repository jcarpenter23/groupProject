import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Story {

    private String fileName;


    public Story (String fileName) {
        this.fileName = fileName;
    }

    public String read(String fileName) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while(in.hasNextLine()){
            s=s+in.hasNextLine();
        }
        return s;
    }

    public void replace(String s){
        //create an array by using s.split
        //loop though it
        //if the word starts with *, call getRandomNoun/adj/verb

    }

    /*public void save(){

    }

    public void saveStories() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter write = new PrintWriter(fileWriter);
        words.saveWords(write);
    } */

}

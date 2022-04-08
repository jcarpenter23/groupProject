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
        String words[] = s.split(" ");
        String finalWords[] = words;
        int i = 0;
        for(i = 0; i < words.length; i++) {
            if (words[i].startsWith("*")) {
                if ( words[i].contains("NOUN") ) {
                    //Call in Get random Noun Method
                    //Final Words goes here.
                } else if ( words[i].contains("VERB") ) {
                    //Call in Get random Verb Method
                } else if ( words[i].contains("ABJECTIVE") ) {
                    //Call in Get Adjective Method
                }
            }
        }
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

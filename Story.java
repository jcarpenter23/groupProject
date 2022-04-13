import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story {

    private String fileName;

    public Story (String fileName) {
        this.fileName = fileName;
    }

    public Words read(String fileName) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while(in.hasNextLine()){
            s=s+in.hasNextLine();
        }
        Words story = new Words(s);
        return story;
    }

    public String replace(String s){
        Words w =new Words(s);
        ArrayList<String> words = new ArrayList<>(List.of(s.split(" ")));
        String wordTobeAdded;
        ArrayList<String> finalWords = new ArrayList<>(words.size());
        for(int i = 0; i < (words.size()); i++) {
            if (words.get(i).startsWith("*")) {
                if ( words.get(i).contains("NOUN") ) {
                    wordTobeAdded = w.getRandomNoun();
                    finalWords.add(wordTobeAdded);
                } else if ( words.get(i).contains("VERB") ) {
                    wordTobeAdded = w.getRandomVerb();
                    finalWords.add(wordTobeAdded);
                } else if ( words.get(i).contains("ADJECTIVE") ) {
                    wordTobeAdded = w.getRandomAdj();
                    finalWords.add(wordTobeAdded);
                }
            }
        }
        //turn final words back into a string
        String space = " ";
        String joinedWords = String.join(space, finalWords);
        return joinedWords;
    }

    public void saveStories(String s){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("MadLibOneWritten.story");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter output = new PrintWriter(fileWriter);
        output.write(s);
        output.flush();
        output.close();
    }

}

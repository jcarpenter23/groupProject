import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story {

    private String fileName;
    private Words wordsInStory;
    private String joinedWords;

    public Story (String fileName) {
        this.fileName = fileName;
    }

    public void read() {
        Scanner in = null;
        try {
            in = new Scanner(new File(this.fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = in.nextLine();
        while(in.hasNextLine()){
            s=s+in.nextLine();
        }
        Words wordsInStory = new Words(s);
        this.wordsInStory= wordsInStory;
    }

    public void replace(){
        ArrayList<String> words = new ArrayList<>(List.of(this.wordsInStory.getString().split(" ")));
        //^problems with this line, we want to get randomNouns/etc. from the "user"
        // Words object input, not file input(wordsInStory)
        //how do we separate this?
        String wordTobeAdded;
        ArrayList<String> finalWords = new ArrayList<>(words.size());
        for(int i = 0; i < (words.size()); i++) {
            if (words.get(i).startsWith("*")) {
                if ( words.get(i).contains("NOUN") ) {
                    wordTobeAdded = wordsInStory.getRandomNoun();
                    finalWords.add(wordTobeAdded);
                } else if ( words.get(i).contains("VERB") ) {
                    wordTobeAdded = wordsInStory.getRandomVerb();
                    finalWords.add(wordTobeAdded);
                } else if ( words.get(i).contains("ADJECTIVE") ) {
                    wordTobeAdded = wordsInStory.getRandomAdj();
                    finalWords.add(wordTobeAdded);
                }
            }
        }
        //turn final words back into a string
        String space = " ";
        String joinedWords = String.join(space, finalWords);
        this.joinedWords=joinedWords;
    }

    public void saveStory(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("MadLibOneWritten.story");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter output = new PrintWriter(fileWriter);
        output.write(joinedWords);
        output.flush();
        output.close();
    }

}

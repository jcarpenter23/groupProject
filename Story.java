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

    public void replace(Words input){
        ArrayList<String> words = new ArrayList<>(List.of(this.wordsInStory.getString().split(" ")));
        String wordTobeAdded;
        for(int i = 0; i < (words.size()); i++) {
            if (words.get(i).startsWith("*") && words.get(i).endsWith("*")) {
                if ( words.get(i).contains("NOUN") ) {
                    wordTobeAdded = input.getRandomNoun();
                    words.remove(i);
                    words.add(i,wordTobeAdded);
                } else if ( words.get(i).contains("VERB") ) {
                    wordTobeAdded = input.getRandomVerb();
                    words.remove(i);
                    words.add(i,wordTobeAdded);
                } else if ( words.get(i).contains("ADJECTIVE") ) {
                    wordTobeAdded = input.getRandomAdj();
                    words.remove(i);
                    words.add(i,wordTobeAdded);
                }
            }
        }
        //turn words back into a String
        String space = " ";
        String joinedWords = String.join(space, words);
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
        output.write(joinedWords); //only writes joinedWords(user input words)
        // into the file, we need the whole story
        output.flush();
        output.close();
    }

}

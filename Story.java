import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Story {

    private final String fileName;
    ArrayList<String> nouns;
    ArrayList<String> adjectives;
    ArrayList<String> verbs;
    Words w=new Words();

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

    public String replace(String s){
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


    /*public void save(){

    }

    public void saveStories() throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter write = new PrintWriter(fileWriter);
        words.saveWords(write);
    } */

}

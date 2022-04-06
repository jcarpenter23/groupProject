import java.io.PrintWriter;
import java.util.ArrayList;

public class Words {
    ArrayList<String> nouns = new ArrayList<>();
    ArrayList<String> adjectives = new ArrayList<>();
    ArrayList<String> verbs= new ArrayList<>();

    public void saveWords(PrintWriter write){
        write.println(getNouns());
        write.println(getAdjectives());
        write.println(getVerbs());
    }
    public ArrayList getNouns(){
        return nouns;
    }
    public ArrayList getAdjectives(){
        return adjectives;
    }
    public ArrayList getVerbs(){
        return verbs;
    }
}

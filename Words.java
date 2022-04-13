
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    private String string;
    public static ArrayList<String> nouns=new ArrayList<>();
    public static ArrayList<String> adjectives=new ArrayList<>();
    public static ArrayList<String> verbs=new ArrayList<>();

    public Words(String string) {
        this.string=string;
    }

    public void saveWords(PrintWriter write){
        write.println(getNouns());
        write.println(getAdjectives());
        write.println(getVerbs());
    }
    //Random Methods
    public String getRandomNoun(){
        Random r = new Random();
        int randomElement = r.nextInt(nouns.size());
        String randomNoun = nouns.get(randomElement);
        return randomNoun;
    }
    public String getRandomAdj(){
        Random r = new Random();
        int randomElement = r.nextInt(adjectives.size());
        String randomAdj = adjectives.get(randomElement);
        return randomAdj;
    }
    public String getRandomVerb(){
        Random r = new Random();
        int randomElement = r.nextInt(verbs.size());
        String randomVerb = verbs.get(randomElement);
        return randomVerb;
    }
    //Get ArrayList Methods
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

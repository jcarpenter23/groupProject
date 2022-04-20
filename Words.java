/*
This class creates a word object of a string that can be
manipulated into ArrayLists of nouns, adjectives, and verbs
This class also contains getters for the lists and the original string
 */
import java.util.ArrayList;
import java.util.Random;

public class Words {
    private String string;
    private ArrayList<String> nouns;
    private ArrayList<String> adjectives;
    private ArrayList<String> verbs;

    //Words constructor, takes a string as a parameter
    public Words(String string) {
        this.nouns = new ArrayList<String>();
        this.adjectives=new ArrayList<String>();
        this.verbs=new ArrayList<String>();
        this.string=string;
    }
    //returns the string element of a Words object
    public String getString(){
        return this.string;
    }
    //Random noun, adjective, and verb methods
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
    //Get each ArrayList methods
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

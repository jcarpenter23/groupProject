 /*
  *This class assigns player objects their chosen answer, score and name
  *Keeps track of each player's score to determine winner of that category
  */
public class Player {
    private String name;
    private int score;
    private int answer;

    // creates a player
    public Player(String name, int score, int answer){
        this.name = name;
        this.score = 0;
        this.answer = answer;
    }
    //returns player's score
    public int getScore() {return score;}
    //returns player's name
    public String getName() {return name;}
    // gets players answer
    public void getChosenAnswer(int answer) {
        this.answer = answer;
    }

    //increments score - used if player's chosen answer is correct
    public int incrementScore() {
        return score++;
    }

}

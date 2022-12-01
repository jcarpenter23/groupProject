import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// a game. stores info about game state
public class Game {
    private final ArrayList<Player> players;
    private final QuestionSet questionSet;
    private Question currentQuestion;
    private final int crownsToWin;
    private ArrayList<Player> crownHolders;
    private ArrayList<Long> crownTimes;
    private Player winner;
    private static final Player NO_ONE = new Player("No one", 0, 0);
    
    // creates a new game
    public Game(int playerCount, File setFile, int crownsToWin) throws IOException {
        players = new ArrayList<>();
        
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player("Player " + (i + 1), 0, 0));
        }
        
        this.questionSet = new QuestionSet(setFile.getPath());
        
        this.crownsToWin = crownsToWin;
        
        crownHolders = new ArrayList<>();
        crownTimes = new ArrayList<>();
        
        for (int i = 0; i < questionSet.getCategories().size(); i++) {
            crownHolders.add(NO_ONE);
            crownTimes.add(Long.MAX_VALUE);
        }
    }
    
    // returns true if someone has enough crowns to win the game
    public boolean someoneWon() {
        int crownsHeld;
        for (Player player :players) {
            crownsHeld = 0;
            for (Player crownHolder : crownHolders) {
                if (player.getName().equals(crownHolder.getName())) {
                    crownsHeld++;
                }
            }
            
            if (crownsHeld >= crownsToWin) {
                winner = player;
                return true;
            }
        }
        return false;
    }
    
    // checks if a correct answer to a question is fast enough to update crown info
    // returns true if someone now has enough crowns to win
    public boolean updateCrowns(String category, long time, Player player) {
        int catIndex = questionSet.getCategories().indexOf(category);
        if (catIndex == -1) {
            throw new IllegalArgumentException("Unknown category: " + category);
        }
        
        if (time < crownTimes.get(catIndex)) {
            crownTimes.set(catIndex, time);
            crownHolders.set(catIndex, player);
        }
        
        return someoneWon();
    }
    
    // returns array list of players
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    // returns the player with the given index
    public Player getPlayer(int index) {
        return players.get(index);
    }
    
    // randomly selects a question from the question set, saves it in currentQuestion, and returns it
    public Question getNewQuestion() {
        currentQuestion = questionSet.getRandomQuestion();
        return currentQuestion;
    }
    
    // returns the current question
    public Question getCurrentQuestion() {
        return currentQuestion;
    }
    
    // returns the number of crowns a player needs to have to win
    public int getCrownsToWin() {
        return crownsToWin;
    }
    
    // returns an array list of players where each index stores the player with the crown of the category with the same index
    public ArrayList<Player> getCrownHolders() {
        return crownHolders;
    }
    
    // returns an array list of longs where each index stores time to beat in ms for the category with the same index
    public ArrayList<Long> getCrownTimes() {
        return crownTimes;
    }
    
    // returns the winner. if a winner hasn't yet been declared, winner is null
    public Player getWinner() {
        return winner;
    }
}

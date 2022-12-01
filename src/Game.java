import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private final ArrayList<Player> players;
    private final QuestionSet questionSet;
    private Question currentQuestion;
    private final int crownsToWin;
    
    private ArrayList<Player> crownHolders;
    
    private ArrayList<Long> crownTimes;
    
    private Player winner;
    
    private static final Player NO_ONE = new Player("No one", 0, 0);
    
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
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public Player getPlayer(int index) {
        return players.get(index);
    }
    
    public Question getNewQuestion() {
        currentQuestion = questionSet.getRandomQuestion();
        return currentQuestion;
    }
    
    public Question getCurrentQuestion() {
        return currentQuestion;
    }
    
    public int getCrownsToWin() {
        return crownsToWin;
    }
    
    public ArrayList<Player> getCrownHolders() {
        return crownHolders;
    }
    
    public ArrayList<Long> getCrownTimes() {
        return crownTimes;
    }
    
    public Player getWinner() {
        return winner;
    }
}

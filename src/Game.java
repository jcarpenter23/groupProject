import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private final ArrayList<Player> players;
    private final QuestionSet questionSet;
    private Question currentQuestion;
    private final int crownsToWin;
    
    public Game(int playerCount, File setFile, int crownsToWin) throws IOException {
        players = new ArrayList<>();
        
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player("Player " + (i + 1), 0, 0));
        }
        
        this.questionSet = new QuestionSet(setFile.getPath());
        
        this.crownsToWin = crownsToWin;
    }
}

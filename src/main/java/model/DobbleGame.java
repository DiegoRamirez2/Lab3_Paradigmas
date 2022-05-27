package model;
import java.util.ArrayList;

public class DobbleGame {
    public Dobble DobbleSet;
    public Integer NumPlayers;
    public ArrayList<Player> ListPlayers;
    public String GameMode;
    public String GameStatus;
    public ArrayList<Card> GameArea;

    public DobbleGame(Integer NumPlayers, Dobble cardsSet, String GameMode) {
        this.NumPlayers = NumPlayers;
        this.ListPlayers = new ArrayList<>();
        this.DobbleSet = cardsSet;
        this.GameMode = GameMode;
        this.GameStatus = "Jugando";
        this.GameArea = new ArrayList<>();
    }

    public String GameStatus() {
        return GameStatus;
    }

    public void StackMode(){
        for(int i = 0; i < 2; i++){
            Card aux = DobbleSet.cardsSet.get(0);
            DobbleSet.cardsSet.remove(0);
            GameArea.add(aux);
        }
    }

    @Override
    public String toString() {
        return
                DobbleSet +
                ", NumPlayers = " + NumPlayers +
                ", ListPlayers = " + ListPlayers +
                ", GameMode = " + GameMode + '\'' +
                ", GameStatus = " + GameStatus + '\'' +
                ", GameArea = " + GameArea;
    }
}

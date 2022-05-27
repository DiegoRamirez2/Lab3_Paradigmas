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

    public String Status() {
        return GameStatus;
    }

    public void StackMode(){
        for(int i = 0; i < 2; i++){
            Card aux = DobbleSet.cardsSet.get(0);
            DobbleSet.cardsSet.remove(0);
            GameArea.add(aux);
        }
    }
    public void Register(Player User){
        if (ListPlayers.size() == 0){
            ListPlayers.add(User);
        }
        else{
            for(int i = 0; i < ListPlayers.size(); i++){
                Player aux = ListPlayers.get(i);
                if (User.Username == aux.Username){
                    return;
                }
            }
            ListPlayers.add(User);
        }
    }
    public String whoseTurnsIsIt(){
        if(ListPlayers.size() == 0){
            return "No hay jugadores";
        }
        else{
            Player aux = ListPlayers.get(0);
            return aux.Username;
        }
    }
    public int Score(String UserName){
        if (ListPlayers.size() != 0) {
            for (int i = 0; i < ListPlayers.size(); i++) {
                Player aux = ListPlayers.get(i);
                if (aux.Username == UserName) {
                    return aux.ObtainPoint();
                }
            }
        }
        return 0;
    }
    public void AppendPoints(){
        Player aux = ListPlayers.get(0);
        aux.Cartas.addAll(GameArea);
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

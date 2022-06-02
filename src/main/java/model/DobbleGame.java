package model;
import java.util.ArrayList;
import java.util.Objects;


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
        if (ListPlayers.size() != 0) {
            for (Player aux : ListPlayers) {
                if (User.Username.equals(aux.Username)) {
                    System.out.println("No se pueden registrar mas jugadores\n");
                    return;
                }
            }
        }
        ListPlayers.add(User);
        System.out.println("Se ha registrado el usuario con exito\n");
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
            for (Player aux : ListPlayers) {
                if (Objects.equals(aux.Username, UserName)) {
                    return aux.ObtainPoint();
                }
            }
        }
        return 0;
    }
    public void AppendPoints(){
        Player aux = ListPlayers.get(0);
        aux.Cartas.addAll(GameArea);
        GameArea.clear();
    }
    public void AddCard(Card card){
        if(!(GameStatus.equals("Terminado"))) {
            DobbleSet.cardsSet.add(card);
            if (DobbleSet.IsDobble()) {
                System.out.println("Se ha agregado la carta con exito\n");
                return;
            }
            DobbleSet.cardsSet.remove(DobbleSet.numCards() - 1);
            System.out.println("La carta no cumple los requisitos para ser agregada\n");
        }
    }
    public void Null(){
        if(!(GameStatus.equals("Terminado"))){
            if(GameArea.size() > 0){
                System.out.println("Ya existen cartas en el area de juego\n");
            }
            else {
                if (GameMode.equalsIgnoreCase("STACKMODE")) {
                    StackMode();
                    System.out.println("Se ha realizado el volteo inicial de cartas con exito\n");
                }
            }
        }
    }
    public void spotIt(Object Elemento){
        if(!(GameStatus.equals("Terminado"))){
            if(GameArea.size() < 2){
                System.out.println("No hay cartas suficientes para realizar la comparacion de cartas\n");
            }
            else{
                Card aux = new Card();
                aux.addAll(GameArea.get(0));
                aux.retainAll(GameArea.get(1));
                if(aux.size() == 1 || Elemento == aux.get(0)){
                    AppendPoints();
                }
                nextTurn();
            }
        }
    }
    public void pass() {
        if (!(GameStatus.equals("Terminado"))) {
            if (GameArea.size() < 2) {
                System.out.println("\nNo existen cartas en el area de juego\n");
            } else {
                System.out.println("Se he realizado con exito el pase de turno\n");
                DobbleSet.cardsSet.add(0, GameArea.get(1));
                DobbleSet.cardsSet.add(0, GameArea.get(0));
                GameArea.clear();
                nextTurn();
            }
        }
    }
    public void finish(){
        this.GameStatus = "Terminado";
    }
    public void nextTurn(){
        Player player = ListPlayers.get(0);
        ListPlayers.remove(0);
        ListPlayers.add(player);
    }
    @Override
    public String toString() {
        return
                DobbleSet +
                "Número de jugadores: " + NumPlayers +
                "\nLista de Jugadores registrados: " + ListPlayers +
                "\nModo de Juego: " + GameMode +
                "\nEstado del Juego: " + GameStatus +
                "\nArea de Juego: " + GameArea + "\n";
    }
}

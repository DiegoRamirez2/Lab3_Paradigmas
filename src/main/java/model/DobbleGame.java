package model;
import java.util.ArrayList;
import java.util.Collections;


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

    public void StackMode() {
        for (int i = 0; i < 2; i++) {
            Card aux = DobbleSet.cardsSet.get(0);
            DobbleSet.cardsSet.remove(0);
            GameArea.add(aux);
        }
    }

    public void Register(Player User) {
        if (ListPlayers.size() != 0) {
            for (Player aux : ListPlayers) {
                if (User.Username.equals(aux.Username)) {
                    return;
                }
            }
        }
        if (ListPlayers.size() < NumPlayers) {
            ListPlayers.add(User);
        }
    }

    public Player whoseTurnsIsIt() {
        return ListPlayers.get(0);
    }

    public int Score(String UserName) {
        if (ListPlayers.size() != 0) {
            for (Player aux : ListPlayers) {
                if (aux.Username.equals(UserName)) {
                    return aux.ObtainPoint();
                }
            }
        }
        return 0;
    }

    public void AppendPoints() {
        Player aux = ListPlayers.get(0);
        aux.Cartas.addAll(GameArea);
        GameArea.clear();
    }
    public void Null() {
        if (GameMode.equalsIgnoreCase("STACKMODE")) {
            StackMode();
        }
    }

    public void spotIt(Object Elemento) {
        Card aux = new Card();
        aux.addAll(GameArea.get(0));
        aux.retainAll(GameArea.get(1));
        if (aux.size() == 1 && Elemento.equals(aux.get(0))) {
            AppendPoints();
            GameArea.clear();
        }
        nextTurn();
    }

    public void pass() {
        if (GameArea.size() < 2) {
            nextTurn();
        } else {
            DobbleSet.cardsSet.add(0, GameArea.get(1));
            DobbleSet.cardsSet.add(0, GameArea.get(0));
            GameArea.clear();
            nextTurn();
        }
    }

    public void finish() {
        this.GameStatus = "Terminado";
        System.out.println(Resultado());
    }

    public void nextTurn() {
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

    public String Puntajes() {
        StringBuilder cadena = new StringBuilder();
        for (Player listPlayer : ListPlayers) {
            cadena.append(listPlayer.getUsername())
                    .append(" tiene: ")
                    .append(listPlayer.ObtainPoint())
                    .append(" puntos\n");
        }
        return "### Lista de puntajes ###\n" + cadena;
    }

    public String Resultado() {
        if (ListPlayers.size() > 0) {
            Collections.sort(ListPlayers);
            StringBuilder cadena = new StringBuilder();
            cadena.append(ListPlayers.get(0).PlayerAndPoints()).append("\n### Perdedor(es) ###\n");
            for (int i = 1; i < ListPlayers.size(); i++) {
                cadena.append(ListPlayers.get(i).PlayerAndPoints()).append("\n");
            }
            return "### Ganador ###\n" + cadena;
        }
        return "No existen jugadores en el juego";
    }
}

package model;

import interfaces.DobbleGameInterface;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que simula un DobbleGame, el cual almacena un Dobble, un Integer, dos String,
 * una lista de cartas y una lista de jugadores.
 * @version 2022.16.06
 * @author Diego Ramírez Vivas
 */
public class DobbleGame implements DobbleGameInterface {
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

    /**
     * Obtiene el estado de juego (String) del DobbleGame
     * @return String Si se obtiene el estado del DobbleGame
     */
    public String Status() {
        return GameStatus;
    }

    /**
     * Retira las dos primeras cartas del set de Cartas y las agrega al área de juego
     */
    public void StackMode() {
        for (int i = 0; i < 2; i++) {
            Card aux = DobbleSet.cardsSet.get(0);
            DobbleSet.cardsSet.remove(0);
            GameArea.add(aux);
        }
    }

    /**
     * Registra a un jugador (Player) dentro del DobbleGame si no se
     * encuentra ya registrado, o no se excede el máximo de jugadores
     * @param User Un jugador (Player) cualquiera
     */
    public void Register(Player User) {
        if (ListPlayers.size() != 0) {
            for (Player aux : ListPlayers) {
                if (User.equals(aux)) {
                    return;
                }
            }
        }
        if (ListPlayers.size() < NumPlayers) {
            ListPlayers.add(User);
        }
    }

    /**
     * Obtiene el jugador al que le corresponde jugar
     * @return Player Si se obtiene el jugador al que le corresponde jugar
     */
    public Player whoseTurnsIsIt() {
        return ListPlayers.get(0);
    }

    /**
     * Obtiene los puntos de un nombre de usuario dado
     * @param UserName (String). El nombre de usuario de un jugador registrado
     * @return (Integer) Si se obtienen los puntos del nombre de usuario dado
     */
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

    /**
     * Agrega las cartas que se encuentren en el área de juego
     * al jugador que le corresponde jugar
     */
    public void AppendPoints() {
        Player aux = ListPlayers.get(0);
        aux.Cartas.addAll(GameArea);
        GameArea.clear();
    }

    /**
     * Efectua el volteo inicial de las dos primeras cartas del mazo
     */
    public void Null() {
        if (GameMode.equalsIgnoreCase("STACKMODE")) {
            StackMode();
        }
    }

    /**
     * Efectua la intersección entre las dos cartas del área de juego
     * y compara el resultado con el elemento ingresado por el jugador
     * @param Elemento (String). Un elemento cualquiera que el jugador cree que es correcto
     */
    public void spotIt(String Elemento) {
        Card aux = new Card();
        aux.addAll(GameArea.get(0));
        aux.retainAll(GameArea.get(1));
        if (aux.size() == 1 && Elemento.equals(aux.get(0))) {
            AppendPoints();
            GameArea.clear();
        }
        nextTurn();
    }

    /**
     * Efectua el pase de turno del juego, otorgandole el turno
     * de juego al siguiente jugador de la lista de jugadores
     * y devuelve las cartas del área de juego al Set de cartas
     */
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

    /**
     * Cambia el estado de juego de "Jugando" a "Terminado",
     * restringiendo al Jugador (Player) para que no pueda
     * efectuar más jugadas en el DobbleGame
     */
    public void finish() {
        this.GameStatus = "Terminado";
        System.out.println(Resultado());
    }

    /**
     * Efectua el pase de turno de jugadores, y le otorga
     * el turno al siguiente jugador
     */
    public void nextTurn() {
        Player player = ListPlayers.get(0);
        ListPlayers.remove(0);
        ListPlayers.add(player);
    }

    /**
     * Convierte la lista de jugadores (ArrayList<Player>) de un Dobble
     * en un String mostrando los puntos de cada Player
     * @return String Si se convierte la lista de jugadores de un Dobble
     */
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

    /**
     * Ordena la lista de jugadores dado sus puntajes y los convierte
     * a String para mostrar el ganador y los perdedores
     * @return String Si se convierte la lista ordenada de jugadores a String
     */
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

    /**
     * Obtiene el DobbleSet (Dobble) de un DobbleGame
     * @return Dobble Si se obtiene el DobbleSet de un DobbleGame
     */
    public Dobble getDobbleSet() {
        return DobbleSet;
    }

    /**
     * Obtiene la lista de jugadores (ArrayList<Player>) de un DobbleGame
     * @return ArrayList<Player> Si se obtiene la lista de jugadores de un DobbleGame
     */
    public ArrayList<Player> getListPlayers() {
        return ListPlayers;
    }

    /**
     * Obtiene el modo de juego de un DobbleGame
     * @return String Si se obtiene el modo de juego de un DobbleGame
     */
    public String getGameMode() {
        return GameMode;
    }

    /**
     * Convierte todo el contenido de un DobbleGame a String
     * @return String Si se convierte todo el contenido del DobbleGame a String
     */
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
    /**
     * Compara dos DobbleGame para verificar que tengan el mismo estado
     * @param DBG1 Un DobbleGame cualquiera
     * @return Boolean Si se comparan los dos DobbleGame
     */
    @Override
    public boolean equals(Object DBG1){
        if(this == DBG1){
            return true;
        }
        if(DBG1 == null){
            return false;
        }
        if(DBG1.getClass() != DobbleGame.class){
            return false;
        }
        DobbleGame newDBG = (DobbleGame) DBG1;
        return newDBG.getDobbleSet().equals(this.DobbleSet)
                && newDBG.getListPlayers().equals(this.ListPlayers)
                && newDBG.getGameMode().equals(this.GameMode);
    }
}
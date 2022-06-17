package interfaces;

import model.*;
import java.util.ArrayList;

public interface DobbleGameInterface {
    String Status();
    void StackMode();
    void Register(Player U);
    Player whoseTurnsIsIt();
    void AppendPoints();
    void Null();
    void spotIt(String Elemento);
    void pass();
    void finish();
    void nextTurn();
    String Puntajes();
    String Resultado();
    Dobble getDobbleSet();
    ArrayList<Player> getListPlayers();
    String getGameMode();
    String toString();
    boolean equals(Object o);
}
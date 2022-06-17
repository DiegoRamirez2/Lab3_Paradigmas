package interfaces;
import model.*;
import java.util.ArrayList;

public interface DobbleInterface {
    ArrayList<Card> setConstructor(ArrayList<String> E, Integer Num, Integer C);
    boolean IsDobble();
    ArrayList<Card> missingCards();
    void AddCard(Integer Pos);
    ArrayList<Card> getCardsSet();
    ArrayList<String> getElements();
    String toString();
    boolean equals(Object o);
}
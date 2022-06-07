package model;
import java.util.ArrayList;


public class Card extends ArrayList<Object> {
    public ArrayList<Object> carta;

    // Métodos
    // Constructor
    public Card() {
        this.carta = new ArrayList<>();
    }

    public ArrayList<Object> getCarta() {
        return carta;
    }
    public void setCarta(ArrayList<Object> carta) {
        this.carta = carta;
    }
    @Override
    public boolean equals(Object C1){
        if(this == C1){
            return true;
        }
        if(C1 == null){
            return false;
        }
        if(C1.getClass() != Card.class){
            return false;
        }
        Card aux = (Card) C1;
        return aux.getCarta().equals(this.carta);
    }
}

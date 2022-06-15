package model;
import interfaces.CardInterface;

import java.util.ArrayList;


public class Card extends ArrayList<Object> implements CardInterface {
    public ArrayList<String> carta;
    // Métodos
    // Constructor
    public Card() {
        this.carta = new ArrayList<>();
    }

    public Card getCarta() {
        return this;
    }
    @Override
    public String toString() {
        return super.toString();
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
        } else {
            Card aux = (Card) C1;
            Card aux2 = new Card();
            aux2.addAll(this);
            aux2.removeAll(aux);
            return aux2.size() == 0;
        }
    }
}
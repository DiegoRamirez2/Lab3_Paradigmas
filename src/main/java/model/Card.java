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

    public ArrayList<String> getCarta() {
        return carta;
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
        }
        Card aux = (Card) C1;
        return aux.getCarta().equals(this.carta);
    }
}
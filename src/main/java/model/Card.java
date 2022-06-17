package model;

import interfaces.CardInterface;
import java.util.ArrayList;

/**
 * Clase que simula una Carta, el cual tiene un ArrayList de Strings
 * @version 2022.16.06
 * @autor: Diego Ramírez Vivas
 */
public class Card extends ArrayList<Object> implements CardInterface {
    public ArrayList<String> carta;
    // Métodos
    // Constructor
    public Card() {
        this.carta = new ArrayList<>();
    }

    /**
     * Obtiene la carta (ArrayList<String>)
     * @return Card Si se obtiene el ArrayList de la carta
     */
    public Card getCarta() {
        return this;
    }

    /**
     * Transforma todo el contenido de una Carta a String
     * @return String Si se convierte todo el contenido de una Carta a String
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Compara dos Cartas para verificar que sean iguales
     * @param C1 Una carta cualquiera
     * @return Boolean Si se comparan las dos cartas
     */
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
package model;
import interfaces.DobbleInterface;

import java.util.ArrayList;
import java.util.Collections;

public class Dobble implements DobbleInterface {
    public ArrayList<Card> cardsSet;
    public ArrayList<String> elements;

    public Dobble(ArrayList<String> elementos, Integer numE, Integer maxC) {
        this.cardsSet = setConstructor(elementos, numE, maxC);
        this.elements = elementos;
        Collections.shuffle(cardsSet);
    }

    public ArrayList<Card> setConstructor(ArrayList<String> elements, Integer numE, Integer maxC) {
        int n = numE - 1;
        Card newCard = new Card();
        ArrayList<Card> Cartas = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            newCard.add(elements.get(i - 1));
        }
        Cartas.add(newCard);
        for (int j = 1; j <= n; j++) {
            Card newCard2 = new Card();
            newCard2.add(elements.get(0));
            for (int k = 1; k <= n; k++) {
                int valor = n * j + (k + 1);
                newCard2.add(elements.get(valor - 1));
            }
            Cartas.add(newCard2);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Card newCard3 = new Card();
                newCard3.add(elements.get(i));
                for (int k = 1; k <= n; k++) {
                    int valor = n + 2 + n * (k - 1) + (((i - 1) * (k - 1) + j - 1) % n);
                    newCard3.add(elements.get(valor - 1));
                }
                Cartas.add(newCard3);
            }
        }
        if (maxC <= 0) {
            return Cartas;
        } else {
            ArrayList<Card> subCartas = new ArrayList<>();
            for (int i = 0; i < maxC; i++) {
                subCartas.add(Cartas.get(i));
            }
            return subCartas;
        }
    }

    // Permite determinar la cantidad de cartas en el set
    public int numCards() {
        return cardsSet.size();
    }

    // Obtiene la n-ésima (nth) carta desde el
    // conjunto de cartas partiendo desde 0 hasta (totalCartas-1).
    public boolean IsDobble() {
        // Se verifica que todas las cartas tengan el mismo tamaño
        Card firstCard = cardsSet.get(0);
        for (int i = 1; i < numCards(); i++) {
            Card nextCard = cardsSet.get(i);
            if (firstCard.size() != nextCard.size()) {
                return false;
            }
        }
        // Se verifica que las cartas tengan elementos distintos
        for (Card iCard : cardsSet) {
            for (int j = 0; j < iCard.size(); j++) {
                for (int k = j + 1; k < iCard.size(); k++) {
                    if (iCard.get(k) == iCard.get(j)) {
                        return false;
                    }
                }
            }
        }
        // Se verifica que la intersección entre dos cartas sea 1
        for (int i = 0; i < (numCards() - 1); i++) {
            for (int j = i + 1; j < numCards(); j++) {
                // Crea copias innecesarias y modifica desde la memoria dinámica
                Card aux = cardsSet.get(i);
                Card aux1 = new Card();
                aux1.addAll(aux);
                aux1.removeAll(cardsSet.get(j));
                if (aux1.size() != (aux.size() - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Card> missingCards() {
        Card firstCard = cardsSet.get(0);
        ArrayList<Card> aux = setConstructor(elements, firstCard.size(), -1);
        aux.removeAll(cardsSet);
        return aux;
    }

    public void AddCard(Integer Pos) {
        cardsSet.add(missingCards().get(Pos));
    }
    public ArrayList<Card> getCardsSet() {
        return cardsSet;
    }

    public ArrayList<String> getElements() {
        return elements;
    }
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < numCards(); i++) {
            cadena.append("Carta N° ").append(i + 1).append(": ").append(cardsSet.get(i)).append("\n");
        }
        return "El cardsSet es: \n" + cadena + "La lista de elementos usados es: " + elements + "\n";
    }

    @Override
    public boolean equals(Object DB1) {
        if (this == DB1) {
            return true;
        }
        if (DB1 == null) {
            return false;
        }
        if (DB1.getClass() != Dobble.class) {
            return false;
        }
        Dobble newDobble = (Dobble) DB1;
        return newDobble.getCardsSet().equals(this.cardsSet)
                && newDobble.getElements().equals(this.elements);
    }
}

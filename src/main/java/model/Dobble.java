package model;
import java.util.ArrayList;

public class Dobble extends ArrayList<Object> {
    public ArrayList<Card> cardsSet;
    public ArrayList<Object> elements;

    public Dobble(ArrayList<Object> elementos, Integer numE, Integer maxC) {
        this.cardsSet = setConstructor(elementos, numE, maxC);
        this.elements = elementos;
    }
    public ArrayList<Card> setConstructor(ArrayList<Object> elements, Integer numE, Integer maxC) {
        int n = numE - 1;
        Card newCard = new Card();
        ArrayList<Card> Cartas = new ArrayList<>();
        for (int i = 1; i <=n + 1; i++) {
            newCard.add(elements.get(i-1));
        }
        Cartas.add(newCard);
        for (int j = 1; j<=n; j++) {
            Card newCard2 = new Card();
            newCard2.add(elements.get(0));
            for (int k = 1; k <=n; k++) {
                int valor = n * j + (k + 1);
                newCard2.add(elements.get(valor-1));
            }
            Cartas.add(newCard2);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Card newCard3 = new Card();
                newCard3.add(i + 1);
                for (int k = 1; k <= n; k++) {
                    int valor = n + 2 + n * (k - 1) + (((i - 1) * (k - 1) + j - 1) % n);
                    newCard3.add(elements.get(valor-1));
                }
                Cartas.add(newCard3);
            }
        }
        if (maxC <= 0 || maxC > findTotalCards(newCard)){
            return Cartas;
        }
        else{
            ArrayList<Card> subCartas = new ArrayList<>();
            for(int i = 1; i <= maxC; i++){
                subCartas.add(Cartas.get(i));
            }
            return subCartas;
        }
    }
    // Permite determinar la cantidad de cartas en el set
    public int numCards(){
        return cardsSet.size();
    }
    // findTotalCards
    public int findTotalCards(Card carta) {
        int tamano = carta.size() - 1;
        return tamano * tamano + tamano + 1;
    }
    // requiredElements
    public int requiredElements(Card carta) {
        int tamano = carta.size() - 1;
        return tamano * tamano + tamano + 1;
    }
    // Obtiene la n-ésima (nth) carta desde el
    // conjunto de cartas partiendo desde 0 hasta (totalCartas-1).
    public Card nthCard(Integer pos){
        return cardsSet.get(pos);
    }
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
            for(int j = i + 1; j < numCards(); j++){
                // Crea copias innecesarias y modifica desde la memoria dinámica
                Card aux = cardsSet.get(i);
                Card aux1 = new Card();
                aux1.addAll(aux);
                aux1.removeAll(cardsSet.get(j));
                if (aux1.size() != (aux.size()-1)) {
                    return false;
                }}}
        return true;
    }
    public ArrayList<Card> missingCards(){
        Card firstCard = cardsSet.get(0);
        ArrayList<Card> aux = setConstructor(elements, firstCard.size(), -1);
        aux.removeAll(cardsSet);
        return aux;
    }
    public void DeleteCard(int i){
        cardsSet.remove(i);
    }



    @Override
    public String toString() {
        return "El cardsSet es: " + cardsSet + ", y la lista de elementos es: " + elements;
    }

    public ArrayList<Card> getCardsSet() {
        return cardsSet;
    }
    public ArrayList<Object> getElements() {
        return elements;
    }
}

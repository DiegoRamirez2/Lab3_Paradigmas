package DobbleGame;
import java.util.ArrayList;


public class main {
    public static void main(String[] args){
        ArrayList<Object> elementos = new ArrayList<>();
        elementos.add(1);
        elementos.add(2);
        elementos.add(3);
        elementos.add(4);
        elementos.add(5);
        elementos.add(6);
        elementos.add(7);
        Dobble newDobble = new Dobble(elementos, 3, -1);
        ArrayList<Card> missingC = newDobble.missingCards();
        //System.out.println(newDobble.nthCard(newDobble.cardsSet, 6));
        System.out.println(newDobble.cardsSet);
        System.out.println(missingC);
        System.out.println(newDobble.numCards());
        System.out.println(newDobble.IsDobble());
    }
}

package model;
import java.util.ArrayList;

public class Menu{
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
        //System.out.println(newDobble.nthCard(newDobble.cardsSet, 6));
        System.out.println(newDobble.cardsSet);
        DobbleGame newDobbleGame = new DobbleGame(4, newDobble, "StackMode");
        System.out.println(newDobbleGame);
        newDobbleGame.StackMode();
        System.out.println(newDobbleGame);
    }
}

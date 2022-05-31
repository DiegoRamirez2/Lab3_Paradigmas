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
        Card Card1 = new Card();
        Card1.add(1);
        Card1.add(2);
        Card1.add(3);
        Card1.add(4);
        ArrayList<Object> action = new ArrayList<>();
        Card Card2 = new Card();
        Card2.add(1);
        Card2.add(5);
        Card2.add(6);
        Card2.add(7);
        Card aux = new Card();
        aux.add(2);
        aux.add(4);
        aux.add(3);
        aux.add(7);
        Card aux1 = new Card();
        aux1.add(3);
        aux1.add(5);
        aux1.add(6);
        aux1.add(8);
        ArrayList<Card> cardS = new ArrayList<>();
        cardS.add(Card1);
        cardS.add(Card2);
        ArrayList<Card> cardS1 = new ArrayList<>();
        cardS1.add(aux);
        cardS1.add(aux1);
        Dobble newDobble = new Dobble(elementos, 3, -1);
        //System.out.println(newDobble.nthCard(newDobble.cardsSet, 6));
        DobbleGame newDobbleGame = new DobbleGame(4, newDobble, "StackMode");
        Player P1 = new Player("Diego");
        newDobbleGame.Register(P1);
        Player P2 = new Player("Alejandro");
        newDobbleGame.Register(P2);
        System.out.println(newDobbleGame);
        newDobbleGame.Null();
        System.out.println(newDobbleGame);
        newDobbleGame.pass();
        System.out.println(newDobbleGame);
        newDobbleGame.pass();
    }
}

package main;
import model.*;

import java.util.ArrayList;

/**
 * Clase principal del programa. Permite ejecutar el menu interactivo junto con sus funcionalidades
 * @version 2022.13.06
 * @autor: Diego Ramírez Vivas
 */
public class Main{
    public static void main(String[] args) {
        //Menu newMenu = new Menu();
        //newMenu.run();
        ArrayList<String> E = new ArrayList<>();
        E.add("1");
        E.add("2");
        E.add("3");
        Card C1 = new Card();
        C1.add("1");
        C1.add("2");
        Card C2 = new Card();
        C2.add("1");
        C2.add("3");
        Dobble newDobble = new Dobble(E, 2, -1);
        System.out.println("CardsSet: " + newDobble.cardsSet);
        System.out.println("Card faltante: " + newDobble.missingCards());
        newDobble.cardsSet.remove(0);
        System.out.println("CardsSet: " + newDobble.cardsSet);
        System.out.println("Card faltante: " + newDobble.missingCards());
        newDobble.cardsSet.remove(0);
        System.out.println("CardsSet: " + newDobble.cardsSet);
        System.out.println("Card faltante: " + newDobble.missingCards());


    }
}


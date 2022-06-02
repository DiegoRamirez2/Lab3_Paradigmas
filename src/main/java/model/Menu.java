package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    public static void main(String[] args) {
        String MainMenu = "### Bienvenido a este MARAVILLOSO juego llamado Dobble ###\n" +
                "Escoja su opción:\n" + "1. Crear un juego\n" + "2. Registrar jugador\n" +
                "3. Jugar\n" + "4. Visualizar estado completo del juego\n" +
                "5. Salir\n" + "INTRODUZCA SU OPCIÓN: ";
        String JugarMenu = "### Menu de Juego ###\n" + "Elija una opción:\n" +
                "1. Agregar una carta\n" + "2. Realizar volteo inicial de cartas\n" +
                "3. Pasar\n" + "4. Finalizar Juego\n" + "5. Salir\n" + "INTRODUZCA SU OPCIÓN: ";

        int opcion;
        do {
            System.out.println(MainMenu);
            Scanner entrada1 = new Scanner(System.in);
            opcion = entrada1.nextInt();
            if(opcion == 1) {
                Scanner entrada2 = new Scanner(System.in);
                System.out.println("¿Cuantos elementos desea por carta?: ");
                int numE = entrada2.nextInt();
                int requiredElements = (numE - 1) * (numE - 1) + (numE - 1) + 1;
                ArrayList<Object> elementos = new ArrayList<>();
                for (int i = 0; i < requiredElements; i++) {
                    Scanner entrada3 = new Scanner(System.in);
                    System.out.println("Ingrese un elemento: ");
                    String elemento = entrada3.nextLine();
                    elementos.add(elemento);
                }
                Scanner num_cartas = new Scanner(System.in);
                System.out.println("Ingrese el numero de cartas que desea en el mazo: ");
                int maxC = num_cartas.nextInt();
                Dobble newDobble = new Dobble(elementos, numE, maxC);
                Scanner num_players = new Scanner(System.in);
                System.out.println("Ingrese el maximo numero de jugadores que desea en el juego: ");
                int maxPlayer = num_players.nextInt();
                Scanner mode = new Scanner(System.in);
                System.out.println("Ingrese el modo de juego entre comillas: ");
                String gameMode = mode.nextLine();
                DobbleGame newDobbleGame = new DobbleGame(maxPlayer, newDobble, gameMode);
                System.out.println(newDobbleGame);
            }
        } while (opcion != 5);
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
        DobbleGame newDobbleGame = new DobbleGame(4, newDobble, "StackMode");
        System.out.println(newDobble);
        /*
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
         */
    }


}

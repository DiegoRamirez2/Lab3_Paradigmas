package model;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    public static String MainMessage = "### Bienvenido a este MARAVILLOSO juego llamado Dobble ###\n";
    public static String MainOptions = "Escoja su opción:\n" + "1. Crear un juego\n" + "2. Registrar jugador\n" +
            "3. Jugar\n" + "4. Visualizar estado completo del juego\n" +
            "5. Salir\n" + "INTRODUZCA SU OPCIÓN: ";
    public static String PlayOptions = "Hola";
    public ArrayList<DobbleGame> DobbleGameList;
    public ArrayList<Player> ListaPlayers;

    public Menu(){
        this.DobbleGameList = new ArrayList<>();
        this.ListaPlayers = new ArrayList<>();
    }

    public void run(){

    }
    public void Opcion1(){
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
        if(Objects.isNull(elementos)){
            System.out.println("Ha ocurrido un error, el juego no ha sido creado " +
                    "por ingresar una lista nula");
        }else{
            System.out.println("Se ha creado la lista de elementos con exito");
            Scanner num_cartas = new Scanner(System.in);
            System.out.println("Ingrese el numero de cartas que desea en el mazo: ");
            int maxC = num_cartas.nextInt();
            Dobble newDobble = new Dobble(elementos, numE, maxC);
            Scanner num_players = new Scanner(System.in);
            System.out.println("Ingrese el maximo numero de jugadores que desea en el juego: ");
            int maxPlayer = num_players.nextInt();
            if(maxPlayer <= 0){
                System.out.println("Ha ocurrido un error, el maximo número de jugadores " +
                        "debe ser mayor que zero");
            }else{
                Scanner mode = new Scanner(System.in);
                System.out.println("Ingrese el modo de juego entre comillas (StackMode es el único): ");
                String gameMode = mode.nextLine();
                if(Objects.isNull(gameMode)){
                    System.out.println("Ha ocurrido un error, el modo de juego null no existe, " +
                            "no se ha podido crear el juego");
                }else{
                    if(Objects.isNull(newDobble)){
                        System.out.println("Ha ocurrido un error, el set de cartas es nulo, " +
                                "no se ha podido crear el juego");
                    }else{
                        DobbleGame newDobbleGame = new DobbleGame(maxPlayer, newDobble, gameMode);
                        System.out.println(newDobbleGame);
                        DobbleGameList.add(newDobbleGame);
                        System.out.println("Se ha podido crear el juego exitosamente");
                    }
                }

            }
        }
    }
    public void RegisterP(Player User){
        if (ListaPlayers.size() != 0) {
            for (Player aux : ListaPlayers) {
                if (User.Username.equals(aux.Username)) {
                    System.out.println("Este jugadores ya se encuentra\n");
                    return;
                }
            }
        }
        ListaPlayers.add(User);
        System.out.println("Se ha registrado el usuario con exito\n");
    }
}


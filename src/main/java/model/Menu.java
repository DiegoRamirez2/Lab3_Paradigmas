package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Clase que simula un Menu interactivo. Posee cuatro String estáticos
 * y un DobbleGame
 */
public class Menu {

    static String MainMessage = "### Bienvenido a este MARAVILLOSO juego llamado Dobble ###\n";
    static String MainOptions = "Escoja su opción:\n" + "1. Crear un juego\n" + "2. Registrar jugador\n" +
            "3. Jugar\n" + "4. Visualizar estado completo del juego\n" +
            "5. Salir\n" + "INTRODUZCA SU OPCIÓN: ";
    static String PlayMessage = "### Bienvenido al área de juego ###\n";
    static String PlayOptions = "Escoja su opción: \n" + "1. Voltear cartas del mazo\n" + "2. Pasar turno\n" +
            "3. ¡Spot It! \n" + "4. Agregar cartas al mazo\n" + "5. Ver tabla de puntajes\n"+ "6. Finalizar juego\n" + "INTRODUZCA SU OPCIÓN: ";
    public DobbleGame Game;
    public Menu(){
        this.Game = null;
    }

    /**
     * Permite ejecutar las distintas funcionalidades del menu
     */
    public void run(){
        String MainOption;
        System.out.println(MainMessage);
        do{
            System.out.println(MainOptions);
            Scanner EntOption = new Scanner(System.in);
            MainOption = EntOption.nextLine();
            switch (MainOption) {
                case "1":
                    Opcion1();
                    break;
                case "2":
                    Opcion2();
                    break;
                case "3":
                    Opcion3();
                    break;
                case "4":
                    Opcion4();
                    break;
                default:
                    System.out.println("Opcion invalida, ingrese una opción nuevamente\n");
                    break;
            }
        }while(!MainOption.equals("5"));
        System.out.println("Gracias por haber jugado este MARAVILLOSO JUEGO");
        System.exit(0);
    }

    /**
     * Opcion 1 del Menu que permite al usuario generar un DobbleGame solicitándole
     * los distintos parametros necesarios para construir el objeto de manera correcta
     */
    public void Opcion1(){
        Scanner entrada2 = new Scanner(System.in);
        System.out.println("¿Cuantos elementos desea por carta?: ");
        int numE = entrada2.nextInt();
        int requiredElements = (numE - 1) * (numE - 1) + (numE - 1) + 1;
        ArrayList<String> elementos = new ArrayList<>();
        for (int i = 0; i < requiredElements; i++) {
            Scanner entrada3 = new Scanner(System.in);
            System.out.println("Ingrese un elemento: ");
            String elemento = entrada3.nextLine();
            elementos.add(elemento);
        }
        if(elementos.size() != requiredElements){
            System.out.println("Ha ocurrido un error, el juego no ha sido creado " +
                    "por ingresar una lista nula");
        }else{
            System.out.println("Se ha creado la lista de elementos con exito");
            boolean flag = true;
            boolean correctP = true;
            System.out.println("Ingrese el numero de cartas que desea en el mazo: ");
            do{
                Scanner num_cartas = new Scanner(System.in);
                int maxC = num_cartas.nextInt();
                if(requiredElements != elementos.size() || maxC > requiredElements){
                    System.out.println("El mazo de cartas\n");
                    System.out.println("Ingrese nuevamente el número de cartas que desea en el mazo:");
                } else {
                    Dobble newDobble = new Dobble(elementos, numE, maxC);
                    if(newDobble.IsDobble()){
                        System.out.println("Se ha creado con exito el mazo de cartas");
                        do{
                            Scanner num_players = new Scanner(System.in);
                            System.out.println("Ingrese el maximo numero de jugadores que desea en el juego: ");
                            int maxPlayer = num_players.nextInt();
                            if(maxPlayer > 1){
                                correctP = false;
                            }
                            if(maxPlayer <= 1){
                                System.out.println("Ha ocurrido un error, el maximo número de jugadores " +
                                        "debe ser mayor que uno");
                            } else {
                                System.out.println("Se ha podido registrar con exito el número de jugadores");
                                Scanner mode = new Scanner(System.in);
                                System.out.println("Ingrese el modo de juego (StackMode es el único): ");
                                String gameMode = mode.nextLine();
                                if (Objects.isNull(gameMode)) {
                                    System.out.println("Ha ocurrido un error, el modo de juego null no existe, " +
                                            "no se ha podido crear el juego\n");
                                } else {
                                    DobbleGame newDobbleGame = new DobbleGame(maxPlayer, newDobble, gameMode);
                                    setGame(newDobbleGame);
                                    System.out.println("Se ha podido crear el juego exitosamente\n");
                                    flag = false;
                                }
                            }
                        }while(correctP);
                    } else{
                        System.out.println("\nEl set de cartas ingresado ingresado no es valido");
                        System.out.println("Ha ocurrido un error al crear el juego, intente nuevamente\n");
                        flag = false;

                    }
                }
            }while (flag);
        }
    }

    /**
     * Opcion 2 que le permite al usuario registrar jugadores dentro del juego
     * si es que estos no se encuentran ya registrados y/o no se excede el
     * máximo número de jugadores fijado durante la creación del DobbleGame
     */
    public void Opcion2(){
        if(Game == null){
            System.out.println("No se pueden registrar jugadores porque no hay un juego creado\n");
        } else {
            System.out.println("Ingrese el nombre del usuario a registrar: ");
            Scanner nombre = new Scanner(System.in);
            String userName = nombre.nextLine();
            int aux = Game.ListPlayers.size();
            Game.Register(new Player(userName));
            if(aux + 1 == Game.ListPlayers.size()){
                System.out.println("Se ha registrado el usuario con exito\n");
            }
            if(aux == Game.ListPlayers.size()){
                System.out.println("No se pudo registrar el usuario\n");
            }
        }
    }

    /**
     * Opcion 3 del menu que permite al usuario realizar las distintas jugadas
     * que se pueden realizar en el juego DobbleGame creado y además puede
     * solicitar visualizar la lista de puntajes actual
     */
    public void Opcion3(){
        if(Game == null){
            System.out.println("No existen juegos creados para jugar\n\n");
        } else if(Game.ListPlayers.size() < 2){
            System.out.println("No existen jugadores suficientes para jugar\n");
        } else {
            String Opcion_jugar;
            System.out.println(PlayMessage);
            do{
                System.out.println("### Es el turno de " + Game.whoseTurnsIsIt().getUsername() + " ###\n");
                System.out.println(PlayOptions);
                Scanner EntPlay = new Scanner(System.in);
                Opcion_jugar = EntPlay.nextLine();
                if(Game.Status().equals("Terminado")){
                    System.out.println("¡El juego ha terminado!, no se pueden realizar más jugadas\n");
                }
                if(!(Game.Status().equals("Terminado"))) {
                    if(Opcion_jugar.equals("1")) {
                        if (Game.GameArea.size() == 2) {
                            System.out.println("Ya existen cartas en el area de juego\n");
                        } else {
                            if(Game.DobbleSet.cardsSet.size() < 2){
                                System.out.println("No se puede realizar el volteo de cartas, deben haber " +
                                        "al menos 2 cartas\n");
                            } else {
                                Game.Null();
                                System.out.println("Se ha realizado el volteo inicial de cartas con exito\n");
                                System.out.println("Las cartas volteadas son: ");
                                System.out.println(Game.GameArea + "\n");
                            }
                        }
                    }
                    if(Opcion_jugar.equals("2")){
                        System.out.println("Se he realizado con exito el pase de turno");
                        if(Game.GameArea.size() >= 2){
                            System.out.println("Las cartas han sido devueltas a su lugar\n");
                        }
                        Game.pass();
                    }
                    if(Opcion_jugar.equals("3")){
                        if(Game.GameArea.size() < 2){
                            System.out.println("No hay suficientes cartas volteadas " +
                                    "realizar la comparacion de cartas\n");
                        } else {
                            String jugada;
                            int puntos;
                            puntos = Game.Score(Game.whoseTurnsIsIt().getUsername());
                            System.out.println("Las cartas volteadas son: ");
                            System.out.println(Game.GameArea + "\n");
                            System.out.println("Ingrese el elemento que cree correcto: ");
                            Scanner ent_elemento  = new Scanner(System.in);
                            jugada = ent_elemento.nextLine();
                            Game.spotIt(jugada);
                            if(puntos == Game.ListPlayers.get(Game.ListPlayers.size() - 1).ObtainPoint()){
                                System.out.println("¡Que lastima!, no ha acertado en su elección\n");
                            } else {
                                System.out.println("¡Felicidades!, ha acertado en su elección\n");
                            }
                        }
                    }
                    if(Opcion_jugar.equals("4")) {
                        ArrayList<Card> Aux_Missing = Game.DobbleSet.missingCards();
                        System.out.println("Este es el Aux_Missing = " + Aux_Missing);
                        Opcion4();
                        if (Aux_Missing.size() == 0) {
                            System.out.println("No existen cartas validas faltantes\n");
                        } else {
                            System.out.println("Puede agregar las siguientes cartas al mazo:");
                            for (int i = 0; i < Aux_Missing.size(); i++) {
                                System.out.println("Carta N° " + (i + 1) + ": "
                                        + Aux_Missing.get(i));
                            }
                            System.out.println("Ingrese el número de carta que quiere agregar");
                            Scanner pos_card = new Scanner(System.in);
                            int card_m = pos_card.nextInt();
                            if (card_m > Aux_Missing.size() || card_m < 0) {
                                System.out.println("Ha ingresado un número de carta no válido");
                            } else {
                                Game.DobbleSet.AddCard(card_m - 1);
                            }
                        }
                    }
                    if(Opcion_jugar.equals("5")){
                        System.out.println(Game.Puntajes());
                    }
                }
                if(Opcion_jugar.equals("6")) {
                    System.out.println("¡El juego ha finalizado!\n" + "Estos son los puntajes:\n");
                    Game.finish();
                }
            }while(!Opcion_jugar.equals("6"));
        }
    }

    /**
     * Opcion 4 que permite visualizar los elementos del DobbleGame creado,
     * los cuales son las cartas del mazo, la lista de jugadores registrados,
     * los elementos usados en las cartas, entre otros.
     */
    public void Opcion4(){
        if(!(Game == null)){
            System.out.println("\n------------### GAME Dobble ###------------\n");
            System.out.println(Game);
            System.out.println("------------### GAME Dobble ###------------\n");
        } else{
            System.out.println("No existe un juego creado para visualizar\n");
        }
    }

    /**
     * Modifica el juego (DobbleGame) almacenado en el Menu interactivo
     * @param game (DobbleGame) Un juego cualquiera a fijar
     */
    public void setGame(DobbleGame game) {
        Game = game;
    }
}
package main;

import model.*;

/**
 * Clase principal del programa. Permite ejecutar el menu interactivo junto con sus funcionalidades
 * @version 2022.16.06
 * @autor: Diego Ramírez Vivas
 */
public class Main{
    /**
     * Aqui se ejecuta el menu del juego
     * @param args En este caso no se necesitan parametros apartes en main
     */
    public static void main(String[] args) {
        Menu newMenu = new Menu();
        newMenu.run();
    }
}
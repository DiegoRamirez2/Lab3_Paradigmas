package model;

import interfaces.PlayerInterface;
import java.util.ArrayList;

/**
 * Clase que simula un Player, el cual tiene un String, un ArrayList<Card>
 * @version 2022.16.06
 * @autor: Diego Ramírez Vivas
 */
public class Player implements Comparable<Player>, PlayerInterface {
    public String Username;
    public ArrayList<Card> Cartas;

    public Player(String Username) {
        this.Username = Username;
        this.Cartas = new ArrayList<>();
    }

    /**
     * Obtiene la cantidad de cartas (Integer) que posee un Player
     * @return Integer Si se obtiene la cantidad de cartas
     */
    public int ObtainPoint(){
        return Cartas.size();
    }

    /**
     * Transforma todo el contenido de un Player a String
     * @return String Si se convierte todo el contenido de un Player a String
     */
    @Override
    public String toString() {
        return Username + " " + Cartas;
    }

    /**
     * Transforma el nombre de usuario del Player y sus puntos a String
     * @return String Si se convierte el nombre de usuario del Player y sus puntos a String
     */
    public String PlayerAndPoints(){
        return Username + ": " + ObtainPoint() + " puntos";
    }

    /**
     * Obtiene el Username (String) único de un Player
     * @return String Si se obtiene el Username único de un Player
     */
    public String getUsername() {
        return Username;
    }

    /**
     * Compara este Player con otro para verificar que sean iguales
     * @param P1 Un jugador (Player) cualquiera
     * @return Boolean Si se comparan los dos Player
     */
    @Override
    public boolean equals(Object P1) {
        if(this == P1){
            return true;
        }
        if(P1 == null){
            return false;
        }
        if(P1.getClass() != Player.class){
            return false;
        }
        Player jugador = (Player) P1;
        return jugador.getUsername().equals(this.Username);

    }

    /**
     * Compara este Player con otro para determinar cuál tiene más puntos
     * @param Jugador Un jugador (Player) cualquiera
     * @return Boolean Si se comparan los dos Player
     */
    @Override
    public int compareTo(Player Jugador) { return Integer.compare(Jugador.ObtainPoint(), ObtainPoint());
    }
}
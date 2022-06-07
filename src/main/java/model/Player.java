package model;

import java.util.ArrayList;

public class Player {
    public String Username;
    public ArrayList<Card> Cartas;

    public Player(String Username) {
        this.Username = Username;
        this.Cartas = new ArrayList<>();
    }
    public int ObtainPoint(){
        return Cartas.size() / 2;
    }

    @Override
    public String toString() {
        return "[" + Username + ", " + Cartas + "]";
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public ArrayList<Card> getCartas() {
        return Cartas;
    }
    public void setCartas(ArrayList<Card> cartas) {
        Cartas = cartas;
    }
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
        return jugador.getUsername().equals(this.Username) &&
                jugador.getCartas().equals(this.Cartas);

    }

}


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
}


package model;
import java.util.ArrayList;

public class Player implements Comparable<Player> {
    public String Username;
    public ArrayList<Card> Cartas;

    public Player(String Username) {
        this.Username = Username;
        this.Cartas = new ArrayList<>();
    }
    public int ObtainPoint(){
        return Cartas.size();
    }

    @Override
    public String toString() {
        return Username + " " + Cartas;
    }
    public String PlayerAndPoints(){
        return Username + ": " + ObtainPoint() + " puntos";
    }
    public String getUsername() {
        return Username;
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
        return jugador.getUsername().equals(this.Username);

    }

    @Override
    public int compareTo(Player Jugador) {
        return Integer.compare(Jugador.ObtainPoint(), ObtainPoint());
    }
}


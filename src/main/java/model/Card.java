package model;
import java.util.ArrayList;
import java.util.function.IntFunction;

public class Card extends ArrayList<Object> {
    public ArrayList<Object> carta;

    // Métodos
    // Constructor
    public Card() {
        this.carta = new ArrayList<>();
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return (T[]) super.toArray(Object[]::new);
    }

}





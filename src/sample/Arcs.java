package sample;

import javafx.util.Pair;

import java.nio.Buffer;
import java.util.Scanner;

public class Arcs {
    private Pair<String,String> direction;
    private int weight;

    public Arcs(Pair<String, String> direction, int weight) {
        this.direction = direction;
        this.weight = weight;
    }


    public Pair<String, String> getDirection() {
        return direction;
    }

    public int getWeight() {
        return weight;
    }

    public void setDirection(Pair<String, String> direction) {
        this.direction = direction;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}

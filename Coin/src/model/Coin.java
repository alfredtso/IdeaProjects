package model;

public class Coin {

    private String side;
    private double prob;

    public Coin() {
        side = "Head";
    }

    public void flip() {
        prob = Math.random();
        if (prob > 0.5) {
            side = "Head";
        } else {
            side = "Tail";
        }
    }

    public String checkStatus() {
        return side;
    }
}

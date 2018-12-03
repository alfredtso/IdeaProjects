package model;

import model.VegType;
import model.Vegetable;

public class Lettuce extends Vegetable {

    public Lettuce () {
        super("Lettuce", VegType.LEAF);
        this.setInstructions("Lettuce 101");
    }

    @Override
    public void feed() {
        System.out.println("feeding lettuce with sth");
    }

    @Override
    public void water() {
        System.out.println("feeding lettuce with water");
    }

    @Override
    public void harvest() {
        System.out.println("harvesting lettuce");
    }

}

package ui;

import model.Coin;

public class Main {

    public static void main(String[] args){

        Coin x = new Coin();
        x.flip();
        System.out.println(x.checkStatus());
    }
}

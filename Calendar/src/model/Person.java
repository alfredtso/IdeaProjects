package model;

public abstract class Person implements Traceable {
    private String name;
    // etc ..

    public Person(String name){
        this.name = name;
    }
}

package model;

import java.awt.*;

public class Reminder extends Entry{

    String notes;

    public Reminder(){
        super();
    }

    //TODO: getter and sette for additional notes
    public String getAdditionalNotes() { return notes;}

    public void setAdditionalNotes(String something) { this.notes = something;}

    public static void main(String[] args) {
        Reminder remindme = new Reminder();
        Date date = new Date(12,1,1991);
        Time time = new Time(12,43);
        Label label = new Label("Diu");
        remindme.newEntry(date,time,label);
        System.out.println(remindme.getDate());
    }
}

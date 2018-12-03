package model;

import java.awt.*;

public class Reminder extends Entry{

    String notes;
    public Reminder(Date date, Time time, Label label, String notes){
        super(date,time,label);
        this.notes = notes;
    };
/*    public Reminder(Date date, Time time, Label label){
        super(date, time, label);
    }*/

    //TODO: getter and sette for additional notes
    public String getAdditionalNotes() { return notes;}

    public void setAdditionalNotes(String something) { this.notes = something;}

    public static void main(String[] args) {
        Date date = new Date(12,1,1991);
        Time time = new Time(12,43);
        Label label = new Label("Diu");
        Reminder remindme = new Reminder(date,time,label, "jomud9");
        System.out.println(((Reminder) remindme).getAdditionalNotes());
        System.out.println(((Reminder) remindme).getDate().getDateLong());
        System.out.println(((Reminder) remindme).isRepeating());
    }
}

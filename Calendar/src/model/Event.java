package model;

import java.awt.*;

public class Event extends Entry {

    private Reminder reminder;

    public Event(Date date, Time time, Label label) {
        super(date, time, label);
        this.reminder = new Reminder(date, time, label, "");
    }

    // Ger reminder
    public Reminder getReminder() {
        return reminder;
    }

    // Set reminder
    public void setReminder(Reminder newreminder) {
        this.reminder = newreminder;
    }

    public static void main(String[] args) {
        Date date = new Date(12, 1, 1991);
        Time time = new Time(12, 43);
        Label label = new Label("Diu");
        Event testing = new Event(date, time, label);
        testing.reminder.setAdditionalNotes("diu nei");
        System.out.println(testing.getReminder().getAdditionalNotes());
    }
}


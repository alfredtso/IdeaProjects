package model;

public class Event extends Entry{

    private Reminder reminder;

    // Ger reminder
    public Reminder getReminder() { return reminder;}

    // Set reminder
    public void setReminder(Reminder newreminder) { this.reminder = newreminder;}
}


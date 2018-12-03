package model;

import java.awt.*;

public abstract class Entry {

    Date date;
    Time time;
    Label label;
    int repeatday = 0;

    public Entry(Date date, Time time, Label label) {
        this.date = date;
        this.time = time;
        this.label = label;
    }

    //TODO: Getters for Date, Time and label
    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public Label getLabel() {
        return label;
    }

    //TODO: Getter and setter for interval of repetition
    public int getIntervalOfRepetition(){ return repeatday; }

    public void setIntervalOfRepetition(int days){ this.repeatday = days;}

    //TODO: Getter for whether the entry is repeating
    public boolean isRepeating() { return repeatday > 0;}
}

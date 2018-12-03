package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private Date currentdate;
    private String email;
    private List<Entry> CalendarItems;

    public Calendar (Date date, String assoemail) {
        this.currentdate = date;
        this.email = assoemail;
        this.CalendarItems = new ArrayList<Entry>();
    }

    public Date getCurrentDate() { return currentdate; }

    public String getEmail() { return email; }

    public void addEntry(Entry entry) {
        this.CalendarItems.add(entry);
        System.out.println("Added entry to Calendar!");
    }

    public Entry getEntryUsingDate(Date date) {
        for (Entry item : CalendarItems) {
            if (item.getDate().getDateLong().equals(date.getDateLong())) {
                System.out.println("Found!");
                return item;
            }
        }
        System.out.println("Entry not found!");
        return null;
    }

    public void getAllMeetings() {
        List<Entry> allMeetings = new ArrayList<>();

        Class c = Meeting.class;

        for (Entry item : CalendarItems){

            if (item.getClass() == c) {
                allMeetings.add(item);
            }
        }

        for (Entry item: allMeetings){
            System.out.println("Getting Meetings");
            System.out.println(item.getLabel());
        }
    }
    //public void addEntry(Reminder reminder) { this.CalendarItems.add(reminder); }

    //public void addEntry(Event event) { this.CalendarItems.add(event); }

    //public void addEntry(Meeting meeting) { this.CalendarItems.add(meeting); }

    //

    // Unit Test
   public static void main(String[] args) {
       Date date = new Date(12,3,1991);
       Time time = new Time(12,43);
       Label label = new Label("Diu");
       Date myDate = new Date(1,12,2018);
       String myEmail = "testing@gmail.com";
       Calendar myCal = new Calendar(myDate,myEmail);
       Entry myevent = new Event(date,time,label);
       Date today = myCal.getCurrentDate();
       myCal.addEntry(myevent);
       System.out.println(myCal.getEmail());
       System.out.println(myCal.getCurrentDate().getDateShort());
       System.out.println(myCal.getEntryUsingDate(today));
   }
}

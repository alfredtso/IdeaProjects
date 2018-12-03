package model;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    Date currentdate;
    String email;
    List<Entry> CalendarItems;

    public Calendar (Date date, String assoemail) {
        this.currentdate = date;
        this.email = assoemail;
        this.CalendarItems = new ArrayList<Entry>();
    }

    public Date getCurrentDate() { return currentdate; }

    public String getEmail() { return email; }

    public void addEntry(Entry entry) { this.CalendarItems.add(entry);}

   /*
    public void addEntry(Reminder reminder) { this.CalendarItems.add(reminder); }
    public void addEntry(Event event) { this.CalendarItems.add(event); }
    public void addEntry(Meeting meeting) { this.CalendarItems.add(meeting); }
    */

   // Unit Test
   public static void main(String[] args) {
       Date myDate = new Date(1,12,2018);
       String myEmail = "testing@gmail.com";
       Calendar myCal = new Calendar(myDate,myEmail);
       System.out.println(myCal.getEmail());
       System.out.println(myCal.getCurrentDate());
       Reminder myTest = new Reminder(12,2
   }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event{

    List<String> ListOfEmail = new ArrayList<String>();
    List<String> ListOfAttendees = new ArrayList<String>();

    public List<String> getListOfEmail() { return this.ListOfEmail;}

    public void addAttendees(String newattendee) {
        this.ListOfAttendees.add(newattendee);
    }

    public void removeAttendees(String attendee) {
        this.ListOfAttendees.remove(attendee);
    }

    public void sendInvitation() {
        int n = ListOfEmail.size();
        for ( int i = 0; i < n; i++){
            String invite = ListOfAttendees.get(i);
            String email = ListOfEmail.get(i);
            String message = String.format("Inviting: %s", invite);
            System.out.println(message);
        }
        System.out.println("End Of List");
    }
}

package Main;
import model.*;
import model.Event;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        Date Rachocho =  new Date(2,17,2017);
        Time sexytime = new Time(14,25);
        Label firsttime = new Label("firsttime");
        Date today = new Date(12,2,2018);
        String myEmail = "testing@gmail.com";
        Calendar myCal = new Calendar(today, myEmail);
        Entry cherry = new Event(Rachocho, sexytime, firsttime);
        myCal.addEntry(cherry);

    }
}

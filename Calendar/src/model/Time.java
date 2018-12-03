package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        if (!(hours >= 0 && hours <=24)) throw new IllegalArgumentException("Should be within 0 - 24");
        else if (!(minutes >= 0 && minutes <=60)) throw new IllegalArgumentException("Invalid Min");
        this.hours = hours;
        this.minutes = minutes;
    }

    public void setTime(int hours, int min){
        if (!(hours >= 0 && hours <=24)) throw new IllegalArgumentException("Should be within 0 - 24");
        else if (!(min >= 0 && min <=60)) throw new IllegalArgumentException("Invalid Min");
        this.hours = hours;
        this.minutes = min;
    }

    //TODO: get time
    public String getTime() {
        String H;
        String M;
        if (hours <= 9) { H =  "0" + String.valueOf(hours);}
        else H = String.valueOf(hours);
        if (minutes <=9) { M = "0" + String.valueOf(minutes);}
        else M = String.valueOf(minutes);
        return H+ ":" + M;
    }

    //TODO: return time in pm/am indicator
    public String getTimeAMPM(){
        String H;
        String M;
        String A;
        if (hours <= 9 ) { H = "0" + String.valueOf(hours);}
        else if (hours > 12) { H = String.valueOf( hours % 12);}
        else H = String.valueOf(hours);
        if (hours <= 11) A = "am";
        else A = "pm";
        if (minutes <=9) { M = "0" + String.valueOf(minutes);}
        else M = String.valueOf(minutes);
        return H + ":" + M + " " + A;
    }

    //TODO: Unit Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (1 != 0) {
            System.out.print("Hour: ");
            int h = scanner.nextInt();
            System.out.print("Minutes: ");
            int m = scanner.nextInt();
            Time t = new Time(h, m);
            System.out.println(t.getTime());
            System.out.println(t.getTimeAMPM());
        }
    }


}

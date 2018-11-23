package model;

public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void getDateShort() {
        String result = String.format("{0}/{1}/{2}", month, day, year);
        System.out.println(result);
    }

    public void getDateLong() {
        String monthString;
        switch (month) {
            case 1: monthString = "January";
                    break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }

        String result = String.format("{0} {1}, {2}", monthString, day, year);
        System.out.println(result);
    }
}

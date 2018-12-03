package test;

import junit.framework.Assert;
import model.Time;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TimeTest {
    Time t;

    @Before
    public void setup() {
        t = new Time(00, 00);
    }

    // Border case
    @Test
    public void setTimeTest() {
        System.out.println("Setting Time to 12:43");
        t.setTime(12, 43);
        assertEquals(t.getTime(), "12:43");
    }

    @Test
    public void setTimeException() {
        System.out.println("Setting Time to 25:43");
        try {
            t.setTime(25, 43);
            assertEquals(t.getTime(), "25:43");
        } catch (Exception e) {
            String expectedMessage = "Should be within 0 - 24";
            assertEquals("Exception message", expectedMessage, e.getMessage());
        }
    }

    @Test
    public void getTime() {
        System.out.println("get Time for 09:09");
        t.setTime(9,9);
        assertEquals(t.getTime(),"09:09");
    }

    @Test
    public void getTime2() {
        System.out.println("get Time for 12:09");
        t.setTime(12,9);
        assertEquals(t.getTime(),"12:09");
    }

    @Test
    public void getTimeAM() {
        System.out.println("get Time for 09:09");
        t.setTime(9,9);
        assertEquals(t.getTimeAMPM(),"09:09 am");
    }

    @Test
    public void getTimePM() {
        System.out.println("get Time for 12:09");
        t.setTime(12,9);
        assertEquals(t.getTimeAMPM(),"12:09 pm");
    }

/*    @Test
    public void getTime() {
        System.out.println("Getting Time in 24 format");
        assertEquals(t.getTime(), "00:00");
    }


    @Test
    public void getTimeAMPM() {
    }*/
}



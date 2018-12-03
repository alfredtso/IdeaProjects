package model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TimeTest {
    Time t;
    @Before
    public void setup() {
        t = new Time(00,00);
    }

    // Border case
    @Test
    public void setTimeTest() {
        System.out.println("Setting Time to 12:43");
        t.setTime(12,43);
        assertEquals(t.getTime(),"12:43");
    }

    @Test
    public void setTime() {
        System.out.println("Setting Time to 12:43");
        t.setTime(12,43);
        assertEquals(t.getTime(),"12:43");
    }

    @Test
    public void getTime() {
        System.out.println("Getting Time in 24 format");
        assertEquals(t.getTime(),"00:00");
    }


    @Test
    public void getTimeAMPM() {
    }
}



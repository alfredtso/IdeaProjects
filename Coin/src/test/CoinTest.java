package test;

import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CoinTest {
    Coin cointest;

    @Before
    public void setup(){
        cointest = new Coin();
    }

    @Test
    public void testFlipedHeadsandTails(){
        int timeschanged = 0;
        String lastStatus = "Heads";
        for (int i=0; i<10; i++){
            cointest.flip();
            String status = cointest.checkStatus();
            System.out.println(status);
            if (!status.equals(lastStatus)){
                timeschanged++;
                lastStatus=status;
            }
        }
        assertFalse(timeschanged==0);
    }

}

package backend;

import org.junit.Test;
import static org.junit.Assert.*;

public class StrategyTest {

    @Test
    public void lowRiskTest(){
        assertEquals(1, Strategy.LOW_RISK);
    }

    @Test
    public void mediumRiskTest(){
        assertEquals(2, Strategy.MEDIUM_RISK);
    }

    @Test
    public void highRiskTest(){
        assertEquals(3, Strategy.HIGH_RISK);
    }

}
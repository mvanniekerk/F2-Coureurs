package backend;

import org.junit.Test;
import static org.junit.Assert.*;

public class SetupTest {

    @Test
    public void lowRiskTest(){
        assertEquals(1, Setup.LOW_RISK);
    }

    @Test
    public void mediumRiskTest(){
        assertEquals(2, Setup.MEDIUM_RISK);
    }

    @Test
    public void highRiskTest(){
        assertEquals(3, Setup.HIGH_RISK);
    }
}
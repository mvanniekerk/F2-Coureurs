package backend;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StrategyTest {
    private Strategy strategy;
    private Strategy sameStrategy;
    private Strategy otherStrategy;

    @Before
    public void SetUp() {
        strategy = new Strategy(Strategy.HIGH_RISK);
        sameStrategy = new Strategy(Strategy.HIGH_RISK);
        otherStrategy = new Strategy(Strategy.LOW_RISK);
    }

    @Test
    public void riskTest() {
        assertEquals(Strategy.HIGH_RISK, strategy.getRisk());
    }

    @Test
    public void sameEquals() {
        assertEquals(strategy, strategy);
    }

    @Test
    public void otherEquals() {
        assertNotEquals(strategy, otherStrategy);
    }

    @Test
    public void sameEqualsAttr() {
        assertEquals(strategy, sameStrategy);
    }

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
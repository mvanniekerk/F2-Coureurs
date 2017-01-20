package backend;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StrategyTest {
    private Strategy strategy;
    private Strategy sameStrategy;
    private Strategy otherStrategy;
    private Strategy mediumRisk;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void SetUp() {
        strategy = new Strategy(Strategy.HIGH_RISK);
        sameStrategy = new Strategy(Strategy.HIGH_RISK);
        otherStrategy = new Strategy(Strategy.LOW_RISK);
        mediumRisk = new Strategy(Strategy.MEDIUM_RISK);
    }

    @Test
    public void highRisk() {
        assertEquals(Strategy.HIGH_RISK, strategy.getRisk());
    }

    @Test
    public void lowRisk() {
        assertEquals(Strategy.LOW_RISK, otherStrategy.getRisk());
    }

    @Test
    public void mediumRisk() {
        assertEquals(Strategy.MEDIUM_RISK, mediumRisk.getRisk());
    }

    @Test
    public void riskLowerError() {
        expectedException.expect(IllegalArgumentException.class);
        new Strategy(0);
    }

    @Test
    public void riskHigherError() {
        expectedException.expect(IllegalArgumentException.class);
        new Strategy(4);
    }

    @Test
    public void calculateLowRiskTest() {
        Strategy strategy = new Strategy(Strategy.LOW_RISK);

        float result = strategy.calculateRisk();

        float min = 0.4f;
        float max = 0.6f;

        System.out.println("Range: [" + min + ", " + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
    }

    @Test
    public void calculateMediumRiskTest() {
        Strategy strategy = new Strategy(Strategy.MEDIUM_RISK);

        float result = strategy.calculateRisk();

        float min = 0.2f;
        float max = 0.8f;

        System.out.println("Range: [" + min + ", " + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
    }

    @Test
    public void calculateHighRiskTest() {
        Strategy strategy = new Strategy(Strategy.HIGH_RISK);

        float result = strategy.calculateRisk();

        float min = 0.0f;
        float max = 1.0f;

        System.out.println("Range: [" + min + ", " + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
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

    @Test
    public void equalsOtherObject() {
        assertNotEquals(strategy, new String());
    }

    @Test
    public void equalsNullTest() {
        assertFalse(strategy.equals(null));
    }
}
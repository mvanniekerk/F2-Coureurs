package backend;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static org.junit.Assert.*;

public class SetupTest {
    private Setup setup;
    private Setup sameSetup;
    private Setup otherSetup;
    private Setup highRisk;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void SetUp() {
        setup = new Setup(Setup.LOW_RISK);
        sameSetup = new Setup(Setup.LOW_RISK);
        otherSetup = new Setup(Setup.MEDIUM_RISK);
        highRisk = new Setup(Setup.HIGH_RISK);
    }

    @Test
    public void highRisk() {
        assertEquals(Setup.HIGH_RISK, highRisk.getRisk());
    }

    @Test
    public void lowRisk() {
        assertEquals(Setup.LOW_RISK, setup.getRisk());
    }

    @Test
    public void mediumRisk() {
        assertEquals(Setup.MEDIUM_RISK, otherSetup.getRisk());
    }

    @Test
    public void riskLowerError() {
        expectedException.expect(IllegalArgumentException.class);
        new Setup(0);
    }

    @Test
    public void riskHigherError() {
        expectedException.expect(IllegalArgumentException.class);
        new Setup(4);
    }

    @Test
    public void calculateLowRiskTest() {
        Setup setup = new Setup(Setup.LOW_RISK);

        float result = setup.calculateRisk();

        float min = 0.4f;
        float max = 0.6f;

        System.out.println("Range: [" + min + ", " + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
    }

    @Test
    public void calculateMediumRiskTest() {
        Setup setup = new Setup(Setup.MEDIUM_RISK);

        float result = setup.calculateRisk();

        float min = 0.2f;
        float max = 0.8f;

        System.out.println("Range: [" + min + ", " + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
    }

    @Test
    public void calculateHighRiskTest() {
        Setup setup = new Setup(Setup.HIGH_RISK);

        float result = setup.calculateRisk();

        float min = 0.0f;
        float max = 1.0f;

        System.out.println("Range: [" + min + ", " + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
    }

    @Test
    public void sameEquals() {
        assertEquals(setup, setup);
    }

    @Test
    public void otherEquals() {
        assertNotEquals(setup, otherSetup);
    }

    @Test
    public void sameEqualsAttr() {
        assertEquals(setup, sameSetup);
    }

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

    @Test
    public void equalsOtherObject() {
        assertNotEquals(setup, new String());
    }

    @Test
    public void equalsNullTest() {
        assertFalse(setup.equals(null));
    }
}
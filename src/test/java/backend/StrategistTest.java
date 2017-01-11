package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StrategistTest {

    private Strategist strategist;
    private Strategist sameStrategist;
    private Strategist otherStrategist;

    @Before
    public void setUp() {
        strategist = new Strategist("Anonyme", 1000000, 10000000, 80);
        sameStrategist = new Strategist("Anonyme", 1000000, 10000000, 80);
        otherStrategist = new Strategist("some guy", 10000, 1000000, 80);
    }

    @Test
    public void getJobDescription() {
        assertEquals("strategist", strategist.getJobTitle());
    }

    @Test
    public void constructorTestname () {
        assertEquals("Anonyme", strategist.getName());
    }

    @Test
    public void constructorTest_salary() {
        assertEquals(1000000, strategist.getSalary());
    }

    @Test
    public void qualityTest() {
        assertEquals(80, strategist.getQuality(), 0.001);
    }

    @Test
    public void sameEquals() {
        assertEquals(strategist, strategist);
    }

    @Test
    public void differentEquals() {
        assertNotEquals(strategist, otherStrategist);
    }

    @Test
    public void sameEqualsAttr() {
        assertEquals(strategist, sameStrategist);
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(strategist, new String());
    }
}
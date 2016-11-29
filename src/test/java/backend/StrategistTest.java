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
        strategist = new Strategist("Anonyme", 1000000);
        sameStrategist = new Strategist("Anonyme", 1000000);
        otherStrategist = new Strategist("some guy", 10000);
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
        assertEquals(0, strategist.getQuality());
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
}
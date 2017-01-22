package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MechanicTest {

    private Mechanic mechanic;
    private Mechanic sameMechanic;
    private Mechanic otherMechanic;

    @Before
    public void setUp() {
        mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 50, 50, 50);
        sameMechanic = new Mechanic("Steve Matchett", 100000, 1000000, 50, 50, 50);
        otherMechanic = new Mechanic("Bill Murray", 120000, 1000000, 80, 40, 40);
    }

    @Test
    public void constructorNullReliability() {
        assertEquals(new Mechanic(), new Mechanic());
    }

    @Test
    public void constructorTest_name() {
        assertEquals("Steve Matchett", mechanic.getName());
    }

    @Test
    public void getJobDescription() {
        assertEquals("mechanic", mechanic.getJobTitle());
    }

    @Test
    public void constructorTest_salary() {
        assertEquals(100000, mechanic.getSalary());
    }

    @Test
    public void qualityTest() {
        assertEquals(50f, mechanic.getQuality(), 0.001);
    }

    @Test
    public void sameEquals() {
        assertEquals(mechanic, mechanic);
    }

    @Test
    public void otherEquals() {
        assertNotEquals(mechanic, otherMechanic);
    }

    @Test
    public void sameEqualsAttr() {
        assertEquals(mechanic, sameMechanic);
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(mechanic, new String());
    }

    @Test
    public void reliabilityDiffersTest() {
        Mechanic almostMechanic = new Mechanic("Steve Matchett", 100000, 1000000, 40, 50, 50);
        assertNotEquals(mechanic, almostMechanic);
    }

    @Test
    public void differentReliabilityTest() {
        Mechanic mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 40, 50, 50);
        Mechanic sameMechanic = new Mechanic("Steve Matchett", 100000, 1000000, 30, 50, 50);

        assertFalse(mechanic.equals(sameMechanic));
    }

    @Test
    public void differentPartFixingTest() {
        Mechanic mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 40, 50, 50);
        Mechanic sameMechanic = new Mechanic("Steve Matchett", 100000, 1000000, 40, 40, 50);

        assertFalse(mechanic.equals(sameMechanic));
    }

    @Test
    public void differentPitstopsTest() {
        Mechanic mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 40, 50, 50);
        Mechanic sameMechanic = new Mechanic("Steve Matchett", 100000, 1000000, 40, 50, 30);

        assertFalse(mechanic.equals(sameMechanic));
    }

    @Test
    public void sameMechanicTest() {
        Mechanic mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 50, 50, 50);

        assertTrue(mechanic.equals(mechanic));
    }

    @Test
    public void equalsnull() {
        assertNotEquals(null, mechanic);
    }

    @Test
    public void equalsNullTest() {
        assertFalse(mechanic.equals(null));
    }
}

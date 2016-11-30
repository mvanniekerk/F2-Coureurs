package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MechanicTest {

    private Mechanic mechanic;
    private Mechanic sameMechanic;
    private Mechanic otherMechanic;

    @Before
    public void setUp() {
        mechanic = new Mechanic("Steve Matchett", 100000, 50, 50, 50);
        sameMechanic = new Mechanic("Steve Matchett", 100000, 50, 50, 50);
        otherMechanic = new Mechanic("Bill Murray", 120000, 80, 40, 40);
    }

    @Test
    public void constructorTest_name() {
        assertEquals("Steve Matchett", mechanic.getName());
    }

    @Test
    public void constructorTest_salary() {
        assertEquals(100000, mechanic.getSalary());
    }

    @Test
    public void qualityTest() {
        assertEquals(0, mechanic.getQuality());
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
}

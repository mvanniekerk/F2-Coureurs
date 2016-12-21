package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class  AerodynamicistTest {

    private Aerodynamicist aerodynamicist;
    private Aerodynamicist sameAero;
    private Aerodynamicist otherAero;


    @Before
    public void setUp() {
        aerodynamicist = new Aerodynamicist("Dan Fallows", 700000, 1000000);
        sameAero = new Aerodynamicist("Dan Fallows", 700000, 1000000);
        otherAero = new Aerodynamicist("Peter Prodromou", 80000, 1000000);
    }

    @Test
    public void constructorTest_name() {
        assertEquals("Dan Fallows", aerodynamicist.getName());
    }

    @Test
    public void constructorTest_salary() {
        assertEquals(700000, aerodynamicist.getSalary());
    }

    @Test
    public void qualityTest() {
        assertEquals(50, aerodynamicist.getQuality(), 0.001);
    }

    @Test
    public void equalsSame() {
        assertEquals(aerodynamicist, aerodynamicist);
    }

    @Test
    public void equalsDifferent() {
        assertNotEquals(aerodynamicist, otherAero);
    }

    @Test
    public void equalsSameAttr() {
        assertEquals(aerodynamicist, sameAero);
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(aerodynamicist, new String());
    }

    @Test
    public void getQualityStringTest() {
        System.out.println(aerodynamicist.getQuality());
        assertEquals(aerodynamicist.getQualityString(), "★★");
    }

}
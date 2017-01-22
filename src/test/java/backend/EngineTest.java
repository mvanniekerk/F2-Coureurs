package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EngineTest {
    private Engine engine;
    private Engine sameEngine;
    private Engine otherEngine;
    private Engine qualityEngine;

    @Before
    public void setUp() {
        engine = new Engine(900, 70, 80, "Mercedes");
        sameEngine = new Engine(900, 70, 80, "Mercedes");
        otherEngine = new Engine (700, 50,100, "Honda");
        qualityEngine = new Engine(81, 92, 12, "Ferrari");
    }

    @Test
    public void setPowerTest() {
        Engine eng = new Engine(800, 70, 80, "Mercedes");
        eng.setPower(900);
        assertEquals(engine, eng);
    }

    @Test
    public void setDrivabilityTest() {
        Engine eng = new Engine(900, 80, 80, "Mercedes");
        eng.setDrivability(70);
        assertEquals(engine, eng);
    }

    @Test
    public void setFuelConsumptionTest() {
        Engine eng = new Engine(900, 70, 70, "Mercedes");
        eng.setFuelConsumption(80);
        assertEquals(engine, eng);
    }

    @Test
    public void setNameTest() {
        Engine eng = new Engine(900, 70, 80, "Ferrari");
        eng.setName("Mercedes");
        assertEquals(engine, eng);
    }

    @Test
    public void getPriceTest() {
        assertEquals(2000000, engine.getPrice());
    }

    @Test
    public void getQualityString() {
        assertEquals("★★★", qualityEngine.getQualityString());
    }

    @Test
    public void getQualityTest() {
        assertEquals(61.666f, qualityEngine.getQuality(), 0.001);
    }

    @Test
    public void testConstructor1() {
        assertEquals(900, engine.getPower());
    }

    @Test
    public void testConstructor2() {
        assertEquals(70, engine.getDrivability());
    }

    @Test
    public void testConstructor3() {
        assertEquals(80, engine.getFuelConsumption());
    }

    @Test
    public void testConstructor4() {
        assertEquals("Mercedes", engine.getName());
    }

    @Test
    public void testEquals_self() {
        assertTrue(engine.equals(engine));
    }

    @Test
    public void testEquals_same() {
        assertTrue(engine.equals(sameEngine));
    }

    @Test
    public void testEquals_other() {
        assertFalse(engine.equals(otherEngine));
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(engine, new String());
    }

    @Test
    public void mercedesEquals() {
        Engine engine1 = new Engine(80, 90, 50, "Mercedes");
        Engine engine2 = new Engine(80, 90, 50, "Mercedes");
        assertEquals(engine1, engine2);
    }

    @Test
    public void differentNameTest() {
        Engine engine1 = new Engine(80, 90, 50, "Mercedes");
        Engine engine2 = new Engine(80, 90, 50, "Ferrari");
        assertFalse(engine1.equals(engine2));
    }

    @Test
    public void differentPowerTest() {
        Engine engine1 = new Engine(80, 90, 50, "Mercedes");
        Engine engine2 = new Engine(30, 90, 50, "Mercedes");
        assertFalse(engine1.equals(engine2));
    }

    @Test
    public void differentDrivabilityTest() {
        Engine engine1 = new Engine(80, 90, 50, "Mercedes");
        Engine engine2 = new Engine(80, 80, 50, "Mercedes");
        assertFalse(engine1.equals(engine2));
    }

    @Test
    public void differentFuelConsumptionTest() {
        Engine engine1 = new Engine(80, 90, 50, "Mercedes");
        Engine engine2 = new Engine(80, 90, 40, "Mercedes");
        assertFalse(engine1.equals(engine2));
    }

    @Test
    public void equalsNullTest() {
        assertFalse(engine.equals(null));
    }

    @Test
    public void hashcode() {
        assertEquals(-413857432, engine.hashCode());
    }

    @Test public void constructorNullReliability() { assertNotEquals(engine, new Engine()); }
}
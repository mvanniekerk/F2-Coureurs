package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DriverTest {

    private Driver driver;
    private Driver sameDriver;
    private Driver otherDriver;


    @Before
    public void setUp() {
        driver = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
        sameDriver = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
        otherDriver = new Driver("Lewis Hamilton", 18, 58, 52, 40, true);
    }

    @Test
    public void constructorTest_name() {
        assertEquals("Kimi Raikkonen", driver.getName());
    }

    @Test
    public void constructorTest_salary() {
        assertEquals(16, driver.getSalary());
    }

    @Test
    public void qualityTest() {
        assertEquals(0, driver.getQuality());
    }

    @Test
    public void equalsSame() {
        assertEquals(driver, driver);
    }

    @Test
    public void equalsDifferent() {
        assertNotEquals(driver, otherDriver);
    }

    @Test
    public void equalsSameAttr() {
        assertEquals(driver, sameDriver);
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(driver, new String());
    }
}
package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DriverTest {

    private Driver driver;
    private Driver sameDriver;
    private Driver otherDriver;
    private Driver salaryDifferent;
    private Driver speedDifferent;
    private Driver raceCraftDifferent;
    private Driver insightDifferent;
    private Driver championDiffers;


    @Before
    public void setUp() {
        driver = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
        sameDriver = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
        salaryDifferent = new Driver("Kimi Raikkonen", 17, 50, 50, 50, false);
        speedDifferent = new Driver("Kimi Raikkonen", 16, 51, 50, 50, false);
        raceCraftDifferent = new Driver("Kimi Raikkonen", 16, 50, 51, 50, false);
        insightDifferent = new Driver("Kimi Raikkonen", 16, 50, 50, 51, false);
        championDiffers = new Driver("Kimi Raikkonen", 16, 50, 50, 50, true);
        otherDriver = new Driver("Kimi Raikkonen", 16, 58, 52, 40, true);
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
    public void equalsNull() {
        assertNotEquals(driver, new String());
    }

    @Test
    public void differsChampion() {
        assertNotEquals(driver, championDiffers);
    }

    @Test
    public void salaryDiffers() {
        assertNotEquals(driver, salaryDifferent);
    }

    @Test
    public void speedDiffers() {
        assertNotEquals(driver, speedDifferent);
    }

    @Test
    public void raceCraftDiffers() {
        assertNotEquals(driver, raceCraftDifferent);
    }

    @Test
    public void insightDiffers() {
        assertNotEquals(driver, insightDifferent);
    }

    @Test
    public void raceWinsDiffers() {
        Driver dr = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
        dr.setRaceWins(1);
        assertNotEquals(this.driver, dr);
    }

    @Test
    public void pointsDiffers() {
        Driver dr= new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
        dr.setPoints(1);
        assertNotEquals(this.driver, dr);
    }

}
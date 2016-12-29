package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    private Driver driver;
    private Driver sameDriver;
    private Driver otherDriver;
    private Driver salaryDifferent;
    private Driver speedDifferent;
    private Driver raceCraftDifferent;
    private Driver insightDifferent;
    private Driver championDiffers;
    private Aerodynamicist aerodynamicist;
    private Mechanic mechanic;
    private Strategist strategist;
    private Engine engine;
    private Team team;
    private Season season;

    @Before
    public void setUp() {
        driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        sameDriver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        salaryDifferent = new Driver("Kimi Raikkonen", 17, 100, 50, 50, 50, false);
        speedDifferent = new Driver("Kimi Raikkonen", 16, 100, 51, 50, 50, false);
        raceCraftDifferent = new Driver("Kimi Raikkonen", 16, 100, 50, 51, 50, false);
        insightDifferent = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 51, false);
        championDiffers = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, true);
        otherDriver = new Driver("Kimi Raikkonen", 16, 100, 58, 52, 40, true);

        aerodynamicist = new Aerodynamicist("Dan Fallows", 700000, 1000000);
        mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 50, 50, 50);
        strategist = new Strategist("Anonyme", 1000000, 1000000);
        engine = new Engine(900, 70, 80, "Mercedes");
        team = new Team("F2", "User", 2500000,
                engine, aerodynamicist, mechanic, strategist);
        team.setFirstDriver(driver);
        team.setSecondDriver(otherDriver);

        season = new Season();
        season.addTeam(team);

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
        assertEquals(50f, driver.getQuality(), 0.001);
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
        Driver dr = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        dr.setRaceWins(1);
        assertNotEquals(this.driver, dr);
    }

    @Test
    public void getQualityStringTest() {
        assertEquals(driver.getQualityString(), "★★");
    }

    @Test
    public void getBuyoutTest() {
        assertEquals(100, driver.getBuyoutClause(season));
    }

    @Test
    public void getZeroBuyoutTest() {
        assertEquals(0, salaryDifferent.getBuyoutClause(season));
    }

    @Test
    public void getTeam() {
        assertEquals(team, driver.getTeam(season));
    }

    @Test
    public void getTeamFail() {
        assertEquals(null, salaryDifferent.getTeam(season));
    }

    @Test
    public void getTeamName() {
        assertEquals("F2", driver.getTeamName(season));
    }

    @Test
    public void getTeamNameFail() {
        assertEquals("contract", salaryDifferent.getTeamName(season));
    }

    @Test
    public void isSecondDriver() {
        assertTrue(otherDriver.isSecondDriver(season));
    }

    @Test
    public void isSecondDriverFalse() {
        assertFalse(driver.isSecondDriver(season));
    }

    @Test
    public void isSecondDriverFail() {
        assertFalse(salaryDifferent.isSecondDriver(season));
    }

    @Test
    public void pointsDiffers() {
        Driver dr= new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        dr.setPoints(1);
        assertNotEquals(this.driver, dr);
    }

    @Test
    public void setSpeedTest() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        driver.setSpeed(23);

        assertEquals(23, driver.getSpeed());
    }

    @Test
    public void getSpeedTest() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);

        assertEquals(50, driver.getSpeed());
    }

    @Test
    public void setRaceCraftTest() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        driver.setRaceCraft(23);

        assertEquals(23, driver.getRaceCraft());
    }

    @Test
    public void getRaceCraftTest() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);

        assertEquals(50, driver.getRaceCraft());
    }

    @Test
    public void setStrategryInsight() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        driver.setStrategyInsight(23);

        assertEquals(23, driver.getStrategyInsight());
    }

    @Test
    public void getAndSetScoreTest() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        driver.setScore(23);

        assertEquals(23, driver.getScore(), 0.001);
    }

    @Test
    public void getStrategyInsight() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);

        assertEquals(50, driver.getStrategyInsight());
    }
}
package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceTest {
    private Race race;
    private Race sameRace;
    private Race otherRace;

    @Before
    public void setUp() {
        race = new Race(new Setup(Setup.LOW_RISK), new Strategy(Strategy.HIGH_RISK), "Circuit de Monaco", 8);
        sameRace = new Race(new Setup(Setup.LOW_RISK), new Strategy(Strategy.HIGH_RISK), "Circuit de Monaco", 8);
        otherRace = new Race(new Setup(Setup.MEDIUM_RISK), new Strategy(Strategy.MEDIUM_RISK), "Silverstone Circuit", 2);
    }

    @Test
    public void calculatePointsOfDriverTest() {
        Driver driver = new Driver("Kimi Raikkonen", 16, 100, 50, 50, 50, false);
        Engine engine = new Engine(90, 70, 80, "Ferrari");
        Mechanic mechanic = new Mechanic("Steve Matchett", 100000, 1000000, 50, 50, 50);
        Aerodynamicist aerodynamicist =  new Aerodynamicist("Dan Fallows", 700000, 1000000, 80);
        Strategist strategist = new Strategist("Toto Wolff", 1000000, 10000000, 80);
        Setup setup = new Setup(Setup.HIGH_RISK);
        Strategy strategy = new Strategy(Strategy.HIGH_RISK);

        float result = race.calculatePointsOfDriver(driver, engine, mechanic, strategist, aerodynamicist, setup, strategy);

        float minDriverWeight = driver.getQuality() * 0.5f; // 25
        float maxDriverWeight = driver.getQuality(); // 50
        float engineWeight = engine.getQuality(); // 80
        float carWeight = aerodynamicist.getQuality(); // 50
        float minSetUpWeight = mechanic.getQuality() * 0.0f; // 0
        float maxSetUpWeight = mechanic.getQuality() * 1.0f; // 50
        float minStrategyWeight = strategist.getQuality() * 0.0f; // 0
        float maxStrategyWeight = strategist.getQuality() * 1.0f; // 78

        float min = 0.2f * (minDriverWeight + engineWeight + carWeight + minSetUpWeight + minStrategyWeight);
        float max = 0.2f * (maxDriverWeight + engineWeight + carWeight + maxSetUpWeight + maxStrategyWeight);

        System.out.println("Range: [" + min + "," + max + "]");
        System.out.println("Result: " + result);

        assertTrue(min <= result && result <= max);
    }

    @Test
    public void setupTest() {
        assertEquals(Setup.LOW_RISK, race.getSetup().getRisk());
    }

    @Test
    public void strategyTest() {
        assertEquals(Strategy.HIGH_RISK, race.getStrategy().getRisk());
    }

    @Test
    public void tracknameTest() {
        assertEquals("Circuit de Monaco", race.getTrackName());
    }

    @Test
    public void roundTest() {
        assertEquals(8, race.getRoundInChampionship());
    }

    @Test
    public void equalSame() {
        assertEquals(race, race);
    }

    @Test
    public void equalsDifferent() {
        assertNotEquals(race, otherRace);
    }

    @Test
    public void equalsNull() { assertNotEquals(race, null); }

    @Test
    public void equalsSameAttr() {
        assertEquals(race, sameRace);
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(race, new String());
    }

    @Test
    public void diffSetupTest() {
        Race diffSetup = new Race(new Setup(Setup.HIGH_RISK), new Strategy(Strategy.HIGH_RISK), "Circuit de Monaco", 8);
        assertNotEquals(diffSetup, race);
    }

    @Test
    public void diffStrategyTest() {
        Race diffStrategy = new Race(new Setup(Setup.LOW_RISK), new Strategy(Strategy.LOW_RISK), "Circuit de Monaco", 8);
        assertNotEquals(diffStrategy, race);
    }

    @Test
    public void diffTrackNameTest() {
        Race diffTrack = new Race(new Setup(Setup.LOW_RISK), new Strategy(Strategy.HIGH_RISK), "Silverstone Circuit", 8);
        assertNotEquals(diffTrack, race);
    }
}
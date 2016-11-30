package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void equalsSameAttr() {
        assertEquals(race, sameRace);
    }
}
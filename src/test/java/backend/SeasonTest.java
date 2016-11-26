package backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeasonTest {
    private Season season;

    @before
    public void setUp() {
        this.season = new Season();

    }

    @Test
    public void currentRoundTest() {
        assertEquals(0, season.currentRound);
    }

}

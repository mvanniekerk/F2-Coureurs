package backend;

import com.google.gson.JsonSyntaxException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SeasonTest {
    private Season season;
    private Season sameSeason;
    private Season otherSeason;
    private String jsonString;

    @Before
    public void setUp() {
        this.season = new Season();
        this.sameSeason = new Season();
        this.otherSeason = new Season();
        otherSeason.setCurrentRound(5);
        this.jsonString = "{\"currentRound\":0}";

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void currentRoundTest() {
        assertEquals(0, season.getCurrentRound());
    }

    @Test
    public void setCurrentRoundTest() {
        assertEquals(5, otherSeason.getCurrentRound());
    }

    @Test
    public void equalsSame() {
        assertEquals(season, sameSeason);
    }

    @Test
    public void equalsDifferent() {
        assertNotEquals(season, otherSeason);
    }

    @Test
    public void equalsSameMemory() {
        assertEquals(season, season);
    }

    @Test
    public void toJsonTest() {
        assertEquals(jsonString, season.toJson());
    }

    @Test
    public void fromJsonTest() {
        assertEquals(season, Season.fromJson(jsonString));
    }

    @Test
    public void fromJsonFail() {
        expectedException.expect(JsonSyntaxException.class);
        Season.fromJson("unexpected string");
    }

    @Test
    public void readFromJsonFileTest() throws IOException {
        InputStream is = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
        Scanner sc = new Scanner(is);

        assertEquals(season, Season.readFromJsonFile(sc));
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(season, new String());
    }
}

package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameEngineTest {
    @Before
    public void SetUp() {
        new GameEngine.GameEngineBuilder("testSave.json").build();
    }

    @Test
    public void getGameEngine() {
        assertEquals("testSave.json", GameEngine.getInstance().getSaveName());
    }
}

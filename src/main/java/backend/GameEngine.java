package backend;

import java.io.InputStream;

public class GameEngine {
    private static GameEngine instance = null;
    private Season season;

    private GameEngine() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream seasonStart = loader.getResourceAsStream("seasonStart.json");
        season = Season.readFromJsonFile(seasonStart);

    }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    public Season getSeason() {
        return season;
    }
}

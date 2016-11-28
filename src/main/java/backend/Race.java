package backend;

public class Race {
    private Setup setup;
    private Strategy strategy;
    private String trackName;
    private int roundInChampionship;

    public Race(Setup setup, Strategy strategy, String trackName, int roundInChampionship) {
        this.setup = setup;
        this.strategy = strategy;
        this.trackName = trackName;
        this.roundInChampionship = roundInChampionship;
    }
}

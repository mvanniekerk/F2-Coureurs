package backend;

public class Race {
    private Setup setup;
    private Strategy strategy;
    private String trackName;
    private int roundInChampionship;

    /**
     * Create a new Race.
     *
     * @param setup the setup used in the race
     * @param strategy the strategy used in the race
     * @param trackName the name of the track
     * @param roundInChampionship the round in the championship
     */
    public Race(Setup setup, Strategy strategy, String trackName, int roundInChampionship) {
        this.setup = setup;
        this.strategy = strategy;
        this.trackName = trackName;
        this.roundInChampionship = roundInChampionship;
    }
}

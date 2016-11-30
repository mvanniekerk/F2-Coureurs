package backend;

import java.util.Objects;

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

    /**
     * Gets the setup of the race.
     *
     * @return the Setup
     */
    public Setup getSetup() {
        return setup;
    }

    /**
     * Gets the strategy of the race.
     *
     * @return the Strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * Gets the trackName of the race.
     *
     * @return the TrackName
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Gets the round in the Championship.
     *
     * @return the round in the championship
     */
    public int getRoundInChampionship() {
        return roundInChampionship;
    }

    /**
     * Checks for equality between the object and its attributes.
     *
     * @param other object to check against
     * @return true if all attributes are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Race race = (Race) other;
        return roundInChampionship == race.roundInChampionship
                && Objects.equals(setup, race.setup)
                && Objects.equals(strategy, race.strategy)
                && Objects.equals(trackName, race.trackName);
    }
}

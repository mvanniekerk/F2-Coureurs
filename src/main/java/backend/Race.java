package backend;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Race {
    private Setup userSetup;
    private Strategy userStrategy;
    private String trackName;
    private int roundInChampionship;
    private List<Driver> result;

    /**
     * Create a new Race.
     *
     * @param setup the setup used in the race
     * @param strategy the strategy used in the race
     * @param trackName the name of the track
     * @param roundInChampionship the round in the championship
     */
    public Race(Setup setup, Strategy strategy, String trackName, int roundInChampionship) {
        this.userSetup = setup;
        this.userStrategy = strategy;
        this.trackName = trackName;
        this.roundInChampionship = roundInChampionship;
    }

    /**
     * Calculate the race score of a driver.
     *
     * @param driver the driver
     * @param engine the engine
     * @param mechanic the mechanic of the team
     * @param strategist the strategist of the team
     * @param aerodynamicist the aerodynamicist of the team
     */
    public float calculatePointsOfDriver(Driver driver, Engine engine, Mechanic mechanic,
                                          Strategist strategist, Aerodynamicist aerodynamicist,
                                          Setup setup, Strategy strategy) {

        Random random = new Random();
        float driverRisk = random.nextFloat() * (1.0f - 0.5f) + 0.5f;

        float driverWeight = driver.getQuality() * driverRisk;
        float engineWeight = engine.getQuality();
        float carWeight = aerodynamicist.getQuality();
        float setUpWeight = mechanic.getQuality() * setup.calculateRisk();
        float strategyWeight = strategist.getQuality() * strategy.calculateRisk();

        return 0.2f * (driverWeight
                + engineWeight
                + carWeight
                + setUpWeight
                + strategyWeight);
    }

    /**
     * Gets the setup of the race.
     *
     * @return the Setup
     */
    public Setup getSetup() {
        return userSetup;
    }

    /**
     * Sets the setup of the race.
     *
     * @param userSetup the user setup
     */
    public void setSetup(Setup userSetup) {
        this.userSetup = userSetup;
    }

    /**
     * Gets the strategy of the race.
     *
     * @return the Strategy
     */
    public Strategy getStrategy() {
        return userStrategy;
    }

    /**
     * Sets the strategy of the race.
     *
     * @param userStrategy the user setup
     */
    public void setStrategy(Strategy userStrategy) {
        this.userStrategy = userStrategy;
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
     * Sets the track name.
     *
     * @param trackName the new track name
     */
    public void setTrackName(String trackName) {
        this.trackName = trackName;
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
     * Sets the round in the Championship.
     *
     * @param roundInChampionship the round
     */
    public void setRoundInChampionship(int roundInChampionship) {
        this.roundInChampionship = roundInChampionship;
    }

    /** Set the result of the race.
     *
     * @param drivers the ordered list of drivers
     */
    public void setResult(List<Driver> drivers) {
        this.result = drivers;
    }

    /**
     * Get result of the race.
     *
     * @return the result of the race
     */
    public List<Driver> getResult() {
        return result;
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
                && Objects.equals(userSetup, race.userSetup)
                && Objects.equals(userStrategy, race.userStrategy)
                && Objects.equals(trackName, race.trackName);
    }
}

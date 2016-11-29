package backend;

public class Driver extends Staff {
    private int speed;
    private int raceCraft;
    private int strategyInsight;
    private int raceWins;
    private int points;
    private boolean championLastYear;

    /**
     * Create a new driver.
     *
     * @param name the name of the staff member
     * @param salary the salary per race
     * @param speed the speed of the driver (0-100)
     * @param raceCraft the raceCraft of the driver (0-100)
     * @param strategyInsight the strategy insight of the driver (0-100)
     * @param championLastYear true if the driver was the champion last year
     */
    public Driver(String name, int salary, int speed, int raceCraft, int strategyInsight,
            boolean championLastYear) {
        super(name, salary);

        this.speed = speed;
        this.raceCraft = raceCraft;
        this.strategyInsight = strategyInsight;
        this.championLastYear = championLastYear;
    }

    /**
     * Finds the quality of the driver by combining all its attributes.
     *
     * @return the quality of the driver, an int between 0 and 100
     */
    @Override
    public int getQuality() {
        //TODO: Decide how to calculate driver quality
        return 0;
    }

    /**
     * Checks for equality between the object and its attributes.
     *
     * @param other object to check against
     * @return true if all attributes are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        // using java 7 equals/hashcode generator
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Driver driver = (Driver) other;
        return speed == driver.speed
                && raceCraft == driver.raceCraft
                && strategyInsight == driver.strategyInsight
                && raceWins == driver.raceWins
                && points == driver.points
                && championLastYear == driver.championLastYear;
    }
}

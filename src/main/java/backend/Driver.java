package backend;

public class Driver extends Staff {
    private int speed;
    private int raceCraft;
    private int strategyInsight;
    private int raceWins;
    private int points;
    private boolean championLastYear;
    private float score;

    /**
     * Create a new driver.
     *
     * @param name             the name of the staff member
     * @param salary           the salary per race
     * @param speed            the speed of the driver (0-100)
     * @param raceCraft        the raceCraft of the driver (0-100)
     * @param strategyInsight  the strategy insight of the driver (0-100)
     * @param championLastYear true if the driver was the champion last year
     */
    public Driver(String name, int salary, int buyoutClause, int speed, int raceCraft,
                  int strategyInsight, boolean championLastYear) {
        super(name, salary, buyoutClause);

        this.speed = speed;
        this.raceCraft = raceCraft;
        this.strategyInsight = strategyInsight;
        this.championLastYear = championLastYear;
        this.raceWins = 0;
        this.points = 0;
        this.score = 0.0f;
    }

    /**
     * set the race wins.
     *
     * @param raceWins must be between 0 and 100
     */
    public void setRaceWins(int raceWins) {
        //TODO: Enforce between 0 and 100?
        this.raceWins = raceWins;
    }

    /**
     * Set the points of the driver.
     *
     * @param points must be between 0 and 100
     */
    public void setPoints(int points) {
        //TODO: Enforce between 0 and 100
        this.points = points;
    }

    /**
     * Get the speed of the driver.
     *
     * <p>The value of speed is between 0 and 100.</p>
     *
     * @return the speed of the driver
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set the speed of the driver.
     *
     * <p>The value of speed has to be between 0 and 100.</p>
     *
     * @param speed the speed of the driver
     */
    public void setSpeed(int speed) {
        if (speed < 0 || speed > 100) {
            throw new IllegalArgumentException("Speed has to be between 0 and 100");
        }
        this.speed = speed;
    }

    /**
     * Get the race craft of the driver.
     *
     * <p>The value of speed is between 0 and 100.</p>
     *
     * @return the race craft
     */
    public int getRaceCraft() {
        return raceCraft;
    }

    /**
     * Set the race craft of the driver.
     *
     * <p>The value of race craft has to be between 0 and 100.</p>
     *
     * @param raceCraft the race craft
     */
    public void setRaceCraft(int raceCraft) {
        this.raceCraft = raceCraft;
    }

    /**
     * Get the strategy insight capabilities of the driver.
     *
     * <p>The value of speed is between 0 and 100.</p>
     *
     * @return the strategy insight of the driver
     */
    public int getStrategyInsight() {
        return strategyInsight;
    }

    /** Set the strategy insight capabilities of the driver.
     *
     * <p>The value of race craft has to be between 0 and 100.</p>
     *
     * @param strategyInsight the strategy insight
     */
    public void setStrategyInsight(int strategyInsight) {
        this.strategyInsight = strategyInsight;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    /**
     * Finds the quality of the driver by combining all its attributes.
     *
     * @return the quality of the driver, an int between 0 and 100
     */
    @Override
    public float getQuality() {
        return (this.speed + this.raceCraft + this.strategyInsight) / 3f;
    }

    /**
     * Finds out if a driver is the second driver of a team.
     * returns false if the driver is not in a team.
     *
     * @param season the season
     * @return true if the driver is a second driver, false otherwise
     */
    public boolean isSecondDriver(Season season) {
        Team team = getTeam(season);
        if (team != null) {
            return equals(team.getSecondDriver());
        }
        return false;
    }

    /**
     * Checks for equality between the object and its attributes.
     *
     * @param other object to check against
     * @return true if all attributes are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Driver) {
            Driver that = (Driver) other;
            boolean boSpeed = this.speed == that.speed;
            boolean boCraft = this.raceCraft == that.raceCraft;
            boolean boInsight = this.strategyInsight == that.strategyInsight;
            boolean boWins = this.raceWins == that.raceWins;
            boolean boPoints = this.points == that.points;
            boolean boChampion = this.championLastYear == that.championLastYear;
            boolean boAll = boSpeed && boCraft && boInsight && boWins && boPoints && boChampion;
            return boAll && super.equals(other);
        } else {
            return false;
        }
    }
}

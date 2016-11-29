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
}

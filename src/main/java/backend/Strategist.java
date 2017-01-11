package backend;

public class Strategist extends Staff {
    private int quality;

    /**
     *  Create a new strategist.
     *
     *  @param name the name of the staff member
     *  @param salary the salary per race
     */
    public Strategist(String name, int salary, int buyoutClause, int quality) {
        super(name, salary, buyoutClause);
        this.quality = quality;

    }

    public String getJobTitle() {
        return "strategist";
    }

    /**
     * Finds the quality of the strategist by combining all its attributes.
     *
     * @return the quality of the strategist, an int between 0 and 100
     */
    @Override
    public float getQuality() {
        return quality;
    }
}
package backend;

public class Strategist extends Staff {

    /**
     *  Create a new strategist.
     *
     *  @param name the name of the staff member
     *  @param salary the salary per race
     */
    public Strategist(String name, int salary) {
        super(name, salary);
    }

    /**
     * Finds the quality of the strategist by combining all its attributes.
     *
     * @return the quality of the strategist, an int between 0 and 100
     */
    @Override
    public int getQuality() {
        //TODO: Decide how to calculate Mechanic quality
        return 0;
    }
}
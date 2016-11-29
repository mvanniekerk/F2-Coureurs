package backend;

public class Aerodynamicist extends Staff {

    /**
     *  Create a new Aerodynamicist.
     *
     *  @param name the name of the staff member
     *  @param salary the salary per race
     */
    public Aerodynamicist(String name, int salary) {
        super(name, salary);
    }

    /**
     * Finds the quality of the aerodynamicist by combining all its attributes.
     *
     * @return the quality of the aerodynamicist, an int between 0 and 100
     */
    @Override
    public int getQuality() {
        //TODO: Decide how to calculate Aerodynamicist quality
        return 0;
    }
}
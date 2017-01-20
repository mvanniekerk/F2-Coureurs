package backend;

public class Aerodynamicist extends Staff {
    private int quality;

    /**
     *  Create a new Aerodynamicist.
     *
     *  @param name the name of the staff member
     *  @param salary the salary per race
     */
    public Aerodynamicist(String name, int salary, int buyoutClause, int quality) {
        super(name, salary, buyoutClause);
        this.quality = quality;
    }

    public Aerodynamicist() {
        super();
        this.quality = 0;
    }

    public String getJobTitle() {
        return "aerodynamicist";
    }

    /**
     * Finds the quality of the aerodynamicist by combining all its attributes.
     *
     * @return the quality of the aerodynamicist, an int between 0 and 100
     */
    @Override
    public float getQuality() {
        return quality;
    }
}
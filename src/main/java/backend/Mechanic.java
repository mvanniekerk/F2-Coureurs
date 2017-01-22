package backend;

public class Mechanic extends Staff {
    private int reliability;
    private int partFixing;
    private int pitstops;

    /**
     * Create a new mechanic.
     *
     * @param name the name of the staff member
     * @param salary the salary per race
     * @param reliability the reliability of the mechanic (0-100)
     * @param partFixing the speed that the mechanic fixes a part (0-100)
     * @param pitstops the workflow in pitstops
     */
    public Mechanic(String name, int salary, int buyoutClause, int reliability,
                    int partFixing, int pitstops) {
        super(name, salary, buyoutClause);

        this.reliability = reliability;
        this.partFixing = partFixing;
        this.pitstops = pitstops;
    }

    /**
     * Empty constructor for Mechanic. Use for "null" Mechanic.
     */
    public Mechanic() {
        super();
        this.reliability = 0;
        this.partFixing = 0;
        this.pitstops = 0;
    }

    /**
     * Finds the quality of the mechanic by combining all its attributes.
     *
     * @return the quality of the mechanic, an int between 0 and 100
     */
    @Override
    public float getQuality() {
        return (reliability + partFixing + pitstops) / 3f;
    }

    public String getJobTitle() {
        return "mechanic";
    }

    /**
     * Checks for equality between the object and its attributes.
     *
     * @param other object to check against
     * @return true if all attributes are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Mechanic mechanic = (Mechanic) other;
        return reliability == mechanic.reliability
                && partFixing == mechanic.partFixing
                && pitstops == mechanic.pitstops;
    }
}

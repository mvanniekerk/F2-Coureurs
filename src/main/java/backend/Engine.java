package backend;

public class Engine {
    private int power;
    private int drivability;
    private int fuelConsumption;
    private String name;

    /**
     * Create a new engine.
     *
     * @param power the power of the engine in hbp
     * @param drivability the drivability of the engine (0-100)
     * @param fuelConsumption the fuelconsumption of the engine in kg/h
     * @param name the name of the engine
     */
    public Engine(int power, int drivability, int fuelConsumption, String name) {
        this.power = power;
        this.drivability = drivability;
        this.fuelConsumption = fuelConsumption;
        this.name = name;
    }

    /**
     * Get the quality of the engine.
     *
     * @return the quality
     */
    public float getQuality() {
        return (power + drivability + fuelConsumption) / 3f;
    }

    /**
     * Gets the price to replace the engine for another.
     *
     * @return replacement price
     */
    public int getPrice() {
        // TODO discuss price
        return 2000000;
    }

    /**
     * Gets the quality as a human readable string (of stars).
     *
     * @return 1 to 5 stars
     */
    public String getQualityString() {
        int numStars = (int) getQuality() / 20;
        return new String(new char[numStars]).replace("\0", "★");
    }

    /**
     * Get the power of the engine.
     *
     * @return the power of the engine
     */
    public int getPower() {
        return power;
    }

    /**
     * Set the power of the engine.
     *
     * @param power the power of the engine
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Get the drivability of the engine.
     *
     * @return the drivability of the engine
     */
    public int getDrivability() {
        return drivability;
    }

    /**
     * Set the drivability of the engine.
     *
     * @param drivability the drivabilty of the engine
     */
    public void setDrivability(int drivability) {
        this.drivability = drivability;
    }

    /**
     * Get the fuel consumption of the engine.
     *
     * @return the fuel consumption of the engine
     */
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Set the fuel consumption of the engine.
     *
     * @param fuelConsumption the fuel consumption
     */
    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Get the name of the engine.
     *
     * @return the name of the engine
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the engine.
     *
     * @param name the name of the engine
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Generates the hashcode of the engine.
     * Necessary for stream distinct to work apparently...
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = power;
        result = 31 * result + drivability;
        result = 31 * result + fuelConsumption;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Engine engine = (Engine) other;
        return power == engine.power
            && drivability == engine.drivability
            && fuelConsumption == engine.fuelConsumption
            && name.equals(engine.name);
    }
}

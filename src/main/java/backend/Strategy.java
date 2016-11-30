package backend;

public class Strategy {
    public static final int LOW_RISK = 1;
    public static final int MEDIUM_RISK = 2;
    public static final int HIGH_RISK = 3;
    private int risk;

    /**
     * Initializes the strategy. Risk must be 1, 2 or 3.
     * @param risk must be 1, 2 or 3
     * @throws if risk is not 1, 2 or 3
     */
    public Strategy(int risk) {
        if (risk == 1 || risk == 2 || risk == 3) {
            this.risk = risk;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Gets the risk of the strategy.
     *
     * @return the risk of the strategy
     */
    public int getRisk() {
        return this.risk;
    }

    /**
     * Checks to see if two objects have the same type and attributes.
     *
     * @param other The object to check against
     * @return True if both objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Strategy strategy = (Strategy) other;
        return risk == strategy.risk;
    }
}

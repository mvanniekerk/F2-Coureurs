package backend;

import java.util.Random;

public class Setup {
    public static final int LOW_RISK = 1;
    public static final int MEDIUM_RISK = 2;
    public static final int HIGH_RISK = 3;
    private int risk;

    /**
     * Initializes the setup. Risk must be 1, 2 or 3.
     * @param risk must be 1, 2 or 3
     * @throws IllegalArgumentException if risk is not 1, 2 or 3
     */
    public Setup(int risk) {
        if (risk >= 1 && risk <= 3) {
            this.risk = risk;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Give back a random risk value based on the setup chosen.
     * @return the setup risk
     */
    public float calculateRisk() {
        Random random = new Random();
        float setupRisk;

        if (this.getRisk() == 1) {
            setupRisk = random.nextFloat() * (0.6f - 0.4f) + 0.4f;
        } else if (this.getRisk() == 2) {
            setupRisk = random.nextFloat() * (0.8f - 0.2f) + 0.2f;
        } else {
            setupRisk = random.nextFloat() * (1.0f - 0.0f) + 0.0f;
        }

        return setupRisk;
    }

    /**
     * Gets the risk of the setup.
     *
     * @return the risk of the setup
     */
    public int getRisk() {
        return this.risk;
    }

    /**
     * Checks to see if two objects have the same type and attributes.
     *
     * @param other the object to check against
     * @return true if both objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Setup setup = (Setup) other;
        return risk == setup.risk;
    }
}

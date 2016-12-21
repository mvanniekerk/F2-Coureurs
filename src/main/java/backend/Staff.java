package backend;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Staff {
    private String name;
    private int salary;
    private int buyoutClause;

    /**
     * Create a new staff member.
     *
     * @param name the name of the staff member
     * @param salary the salary per race
     */
    public Staff(String name, int salary, int buyoutClause) {
        this.name = name;
        this.salary = salary;
        this.buyoutClause = buyoutClause;
    }

    /**
     * Get the name of the staff member.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the staff member.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the salary per race.
     *
     * @return the salary per race
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the salary per race.
     *
     * @param salary the salary per race
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Returns the quality of the staff member.
     *
     * @return int between 0 and 100 of the quality of the staff member
     */
    public abstract float getQuality();

    /**
     * Gets a string representation of the budget.
     *
     * @return string of the budget
     */
    public String getSalaryString() {
        // TODO add tests
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return euroFormat.format(salary);
    }

    public int getBuyoutClause() {
        // TODO add tests
        return buyoutClause;
    }

    public String getBuyoutlauseString() {
        // TODO add tests
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return euroFormat.format(buyoutClause);
    }

    public String getQualityString() {
        int numStars = (int) getQuality() / 20;
        return new String(new char[numStars]).replace("\0", "★");
    }

    /**
     * Implements a equals method that checks all attributes of Staff for equality.
     *
     * @param other Object to check against
     * @return true if all attributes are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Staff) {
            Staff that = (Staff) other;
            if (!this.name.equals(that.name)) {
                return false;
            }
            if (this.salary != that.salary) {
                return false;
            }
            return this.buyoutClause == that.buyoutClause;
        }
        return false;
    }
}

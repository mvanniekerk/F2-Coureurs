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

    /**
     * Gets the buyout clause.
     *
     * @return the buyout clause
     */
    public int getBuyoutClause(Season season) {
        // TODO add tests
        if (season.getTeamNameByMember(this).equals("contract")) {
            return 0;
        }
        return buyoutClause;
    }

    /**
     * Gets a human readable string of the buyout clause.
     *
     * @return buyout clause string
     */
    public String getBuyoutClauseString(Season season) {
        // TODO add tests
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return euroFormat.format(getBuyoutClause(season));
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

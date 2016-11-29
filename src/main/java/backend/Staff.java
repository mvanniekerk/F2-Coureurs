package backend;

public abstract class Staff {
    private String name;
    private int salary;

    /**
     * Create a new staff member.
     *
     * @param name the name of the staff member
     * @param salary the salary per race
     */
    public Staff(String name, int salary) {
        this.name = name;
        this.salary = salary;
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
    public abstract int getQuality();

    /**
     * Implements a equals method that checks all attributes of Staff for equality
     *
     * @param other Object to check against
     * @return true if all attributes are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Staff) {
            Staff that = (Staff) other;
            boolean nameEq = this.name.equals(that.name);
            boolean salaryEq = this.salary == that.salary;
            return nameEq && salaryEq;
        }
        return false;
    }
}

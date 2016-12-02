package backend;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String manager;
    private int budget;
    private int pointsAlltime;
    private int pointsThisSeason;
    private int winsAlltime;
    private int winsThisSeason;
    private Engine engine;
    private Aerodynamicist aerodynamicist;
    private Mechanic mechanic;
    private Strategist strategist;
    private List<Driver> drivers;

    /**
     * Create a new team.
     *
     * @param name the name of the team
     * @param manager the name of the manager
     * @param budget the current budget of this team
     * @param engine the engine of this team
     * @param aerodynamicist the aerodynamicist of this team
     * @param mechanic the mechanis of the team
     * @param strategist the strategist of the team
     */
    public Team(String name, String manager, int budget, Engine engine,
                Aerodynamicist aerodynamicist, Mechanic mechanic, Strategist strategist) {
        this.name = name;
        this.manager = manager;
        this.budget = budget;
        this.engine = engine;
        this.aerodynamicist = aerodynamicist;
        this.mechanic = mechanic;
        this.strategist = strategist;
        this.pointsAlltime = 0;
        this.pointsThisSeason = 0;
        this.winsAlltime = 0;
        this.winsThisSeason = 0;
        drivers = new ArrayList<Driver>();
    }

    /**
     * Get the name of the team.
     *
     * @return the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the team.
     *
     * @param name the name of the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the manager.
     *
     * @return the name of the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Set the name of the manager.
     *
     * @param manager the name of the manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Get the current budget.
     *
     * @return the current budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Set the current budget.
     *
     * @param budget the current budget
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    /**
     * Get the total amount of points until now.
     *
     * @return the total amount pf points until now
     */
    public int getPointsAlltime() {
        return pointsAlltime;
    }

    /**
     * Set the total amount of points until now.
     *
     * @param pointsAlltime the total amount of points in this season
     */
    public void setPointsAlltime(int pointsAlltime) {
        this.pointsAlltime = pointsAlltime;
    }

    /**
     * Get the total amount of points in this season.
     *
     * @return the total amount of points in this season
     */
    public int getPointsThisSeason() {
        return pointsThisSeason;
    }

    /**
     * Set the total amount of points in this season.
     *
     * @param pointsThisSeason the total amount of points in this season
     */
    public void setPointsThisSeason(int pointsThisSeason) {
        this.pointsThisSeason = pointsThisSeason;
    }

    /**
     * Get the total amount of wins until now.
     *
     * @return the total amount of wins until now
     */
    public int getWinsAlltime() {
        return winsAlltime;
    }

    /**
     * Set the total amount of wins until now.
     *
     * @winAllTime the value you want tot change
     */
    public void setWinsAlltime(int winAllTime) {
        this.winsAlltime = winAllTime;
    }

    /**
     * Get the total amount of wins in this season.
     *
     * @return the total amount of wins in this season
     */
    public int getWinsThisSeason() {
        return winsThisSeason;
    }

    /**
     * Set the total amount of wins in this season.
     *
     * @param winsThisSeason the total amount of wins in this season
     */
    public void setWinThisSeason(int winsThisSeason) {
        this.winsThisSeason = winsThisSeason;
    }

    /**
     * Get the engine.
     *
     * @return the engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Set the engine.
     *
     * @param engine the engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Get the aerodynamicist.
     *
     * @return the aerodynamicist
     */
    public Aerodynamicist getAerodynamicist() {
        return aerodynamicist;
    }

    /**
     * Set the aerodynamicist.
     *
     * @param aerodynamicist the aerodynamicist
     */
    public void setAerodynamicist(Aerodynamicist aerodynamicist) {
        this.aerodynamicist = aerodynamicist;
    }

    /**
     * Get the mechanic.
     *
     * @return the mechanic
     */
    public Mechanic getMechanic() {
        return mechanic;
    }

    /**
     * Set the mechanic.
     *
     * @param mechanic the mechanic
     */
    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    /**
     * Get the strategist.
     *
     * @return the strategist
     */
    public Strategist getStrategist() {
        return strategist;
    }

    /**
     * Set the strategist.
     *
     * @param strategist the strategist
     */
    public void setStrategist(Strategist strategist) {
        this.strategist = strategist;
    }

    /**
     * Report on whether the list contains driver.
     *
     * @param driver the driver to compare with
     * @return true if driver is in drivers and false otherwise
     */
    public boolean contains(Driver driver) {
        for (Driver item : drivers) {
            if (item.equals(driver)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Aad a driver to the list.
     *
     * @param driver the driver to compare with
     * @throws IllegalArgumentException if list contains driver
     */
    public void addDriver(Driver driver) {
        if (drivers.contains(driver)) {
            throw new IllegalArgumentException("This driver is already in the list");
        } else {
            drivers.add(driver);
        }
    }

    /**
     * Get the list of drivers.
     *
     * @return the list of drivers
     */
    public List<Driver> getDrivers() {
        return drivers;
    }

    /**
     * Report on whether or not the object is equal to team.
     *
     * @param other the object to compare with
     * @return true if they are equal and false otherwise
     */
    @Override
    public boolean equals(Object other) {
        //TODO: Reduce complexity
        if (other instanceof Team) {
            Team team = (Team) other;
            boolean boPointAll = getPointsAlltime() == team.getPointsAlltime();
            boolean boPointThis = getPointsThisSeason() == team.getPointsThisSeason();
            boolean boWinAll = getWinsAlltime() == team.getWinsAlltime();
            boolean boWinThis = getWinsThisSeason() == team.getWinsThisSeason();
            boolean boBudget = getBudget() == team.getBudget();
            boolean boName = getName().equals(team.getName());
            boolean boManager = getManager().equals(team.getManager());
            boolean boEngine = getEngine().equals(team.getEngine());
            boolean boAerodynamicist = getAerodynamicist().equals(team.getAerodynamicist());
            boolean boMechanic = getMechanic().equals(team.getMechanic());
            boolean boStrategist = getStrategist().equals(team.getStrategist());
            boolean boDrivers = getDrivers().equals(team.getDrivers());
            return boPointAll && boPointThis && boPointAll && boWinAll && boWinThis
                    && boBudget && boName && boManager && boEngine && boAerodynamicist
                    && boMechanic && boStrategist && boDrivers;
        }
        return false;
    }
}

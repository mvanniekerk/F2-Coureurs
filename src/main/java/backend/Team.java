package backend;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String manager;
    private int budget;
    private int pointsAllTime;
    private int pointsThisSeason;
    private int winAllTime;
    private int winThisSeason;
    private Engine engine;
    private Aerodynamicist aerodynamicist;
    private Mechanic mechanic;
    private Strategist strategist;
    private List<Driver> drivers;

    public Team(String name, String manager, int budget, int pointsAllTime, int pointsThisSeason,
                int winAllTime, int winThisSeason, Engine engine,
                Aerodynamicist aerodynamicist, Mechanic mechanic, Strategist strategist) {
        this.name = name;
        this.manager = manager;
        this.budget = budget;
        this.pointsAllTime = pointsAllTime;
        this.pointsThisSeason = pointsThisSeason;
        this.winAllTime = winAllTime;
        this.winThisSeason = winThisSeason;
        this.engine = engine;
        this.aerodynamicist = aerodynamicist;
        this.mechanic = mechanic;
        this.strategist = strategist;
        drivers = new ArrayList<Driver>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getPointsAllTime() {
        return pointsAllTime;
    }

    public void setPointsAllTime(int pointsAllTime) {
        this.pointsAllTime = pointsAllTime;
    }

    public int getPointsThisSeason() {
        return pointsThisSeason;
    }

    public void setPointsThisSeason(int pointsThisSeason) {
        this.pointsThisSeason = pointsThisSeason;
    }

    public int getWinAllTime() {
        return winAllTime;
    }

    public void setWinAllTime(int winAllTime) {
        this.winAllTime = winAllTime;
    }

    public int getWinThisSeason() {
        return winThisSeason;
    }

    public void setWinThisSeason(int winThisSeason) {
        this.winThisSeason = winThisSeason;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Aerodynamicist getAerodynamicist() {
        return aerodynamicist;
    }

    public void setAerodynamicist(Aerodynamicist aerodynamicist) {
        this.aerodynamicist = aerodynamicist;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Strategist getStrategist() {
        return strategist;
    }

    public void setStrategist(Strategist strategist) {
        this.strategist = strategist;
    }

    public boolean contains(Driver driver) {
        for (Driver item : drivers) {
            if (item == driver) {
                return true;
            }
        }
        return false;
    }

    public void addDriver(Driver driver) {
        if (drivers.contains(driver)) {
            throw new IllegalArgumentException("This driver is already in the list");
        } else {
            drivers.add(driver);
        }
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Team) {
            Team team = (Team) other;
            boolean boBudget = getBudget() == team.getBudget();
            boolean boPointAll = getPointsAllTime() == team.getPointsAllTime();
            boolean boPointThis = getPointsThisSeason() == team.getPointsThisSeason();
            boolean boWinAll = getWinAllTime() != team.getWinAllTime();
            boolean boWinThis = getWinThisSeason() != team.getWinThisSeason();
            boolean boName = getName().equals(team.getName());
            boolean boManager = getManager().equals(team.getManager());
            boolean boEngine = getEngine().equals(team.getEngine());
            boolean boAerodynamicist = getAerodynamicist().equals(team.getAerodynamicist());
            boolean boMechanic = getMechanic().equals(team.getMechanic());
            boolean boStrategist = getStrategist().equals(team.getStrategist());
            boolean boDrivers = getDrivers().equals(team.getDrivers());
            boolean all = boBudget && boPointAll && boPointThis && boWinAll && boWinThis
                    && boName && boManager && boEngine && boAerodynamicist
                    && boMechanic && boStrategist && boDrivers;
            return all;
        } else {
            return false;
        }
    }
}

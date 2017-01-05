package backend;

import com.google.gson.JsonSyntaxException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SeasonTest {
    private Season simpleSeason;
    private Season season;
    private Season sameSeason;
    private Season otherSeason;
    private String jsonStringSpaces;
    private Team team;
    private Team team2;
    private Driver driver;
    private Driver driver2;
    private Driver driver3;
    private Driver samedriver3;
    private Driver driver4;
    private Driver driver5;
    private Aerodynamicist aerodynamicist;
    private Aerodynamicist aerodynamicist2;
    private Aerodynamicist aerodynamicist3;
    private Aerodynamicist sameaerodynamicist3;
    private Mechanic mechanic;
    private Mechanic mechanic2;
    private Mechanic mechanic3;
    private Mechanic samemechanic3;
    private Strategist strategist;
    private Strategist strategist2;
    private Strategist strategist3;
    private Strategist samestrategist3;
    private Engine engine;
    private Engine otherEngine;
    private Race race;
    private Race samerace;
    private String simple;
    private Driver samedriver;
    private Aerodynamicist sameaerodynamicist;
    private Driver samedriver2;
    private Mechanic samemechanic;
    private Strategist samestrategist;
    private Engine sameengine;
    private Team sameteam;

    @Before
    public void setUp() {
        driver = new Driver("Kimi Raikkonen", 16, 100,50, 50, 50, false);
        driver2 = new Driver("Lewis Hamilton", 18, 100,58, 52, 40, true);
        aerodynamicist = new Aerodynamicist("Dan Fallows", 700000, 100);
        mechanic = new Mechanic("Steve Matchett", 100000, 100, 50, 50, 50);
        strategist = new Strategist("Anonyme", 1000000, 10000000);
        engine = new Engine(90, 70, 80, "Mercedes");
        otherEngine = new Engine(90, 60, 80, "Ferrari");
        team = new Team("F2", "User", 2500000,
                engine, aerodynamicist, mechanic, strategist);
        team.setFirstDriver(driver);
        team.setSecondDriver(driver2);

        samedriver = new Driver("Kimi Raikkonen", 16, 100,50, 50, 50, false);
        samedriver2 = new Driver("Lewis Hamilton", 18, 100,58, 52, 40, true);
        sameaerodynamicist = new Aerodynamicist("Dan Fallows", 700000, 100);
        samemechanic = new Mechanic("Steve Matchett", 100000, 100, 50, 50, 50);
        samestrategist = new Strategist("Anonyme", 1000000, 10000000);
        sameengine = new Engine(900, 70, 80, "Mercedes");
        sameteam = new Team("F2", "User", 2500000,
                engine, aerodynamicist, mechanic, strategist);
        sameteam.setFirstDriver(samedriver);
        sameteam.setSecondDriver(samedriver2);



        driver4 = new Driver("Kimi", 16, 1000,50, 50, 50, false);
        driver5 = new Driver("Lewis", 18, 1000,58, 52, 40, true);
        aerodynamicist2 = new Aerodynamicist("Dan", 700000, 100);
        mechanic2 = new Mechanic("Steve", 100000, 100, 50, 50, 50);
        strategist2 = new Strategist("Anon", 1000000, 10000000);
        team2 = new Team("F3", "Not me", 2500000,
                otherEngine, aerodynamicist2, mechanic2, strategist2);
        team2.setFirstDriver(driver4);
        team2.setSecondDriver(driver5);

        this.simpleSeason = new Season();
        this.season = new Season();
        this.sameSeason = new Season();
        this.otherSeason = new Season();

        samedriver3 = new Driver("Kim", 16, 100, 58, 52, 40, true);
        sameaerodynamicist3 = new Aerodynamicist("Dan Brown", 700000, 100);
        samemechanic3 = new Mechanic("Steve Jobs", 100000, 100, 50, 50, 50);
        samestrategist3 = new Strategist("Anon the hacker", 1000000, 10000000);

        driver3 = new Driver("Kim", 16, 100, 58, 52, 40, true);
        aerodynamicist3 = new Aerodynamicist("Dan Brown", 700000, 100);
        mechanic3 = new Mechanic("Steve Jobs", 100000, 100, 50, 50, 50);
        strategist3 = new Strategist("Anon the hacker", 1000000, 10000000);

        this.season.addTeam(team);
        this.season.addTeam(team2);
        this.season.addContractStaffMember(driver3);
        this.season.addContractStaffMember(aerodynamicist3);
        this.season.addContractStaffMember(mechanic3);
        this.season.addContractStaffMember(strategist3);

        this.otherSeason.addTeam(team);
        this.sameSeason.addTeam(sameteam);
        this.sameSeason.addTeam(team2);
        this.sameSeason.addContractStaffMember(samedriver3);
        this.sameSeason.addContractStaffMember(sameaerodynamicist3);
        this.sameSeason.addContractStaffMember(samemechanic3);
        this.sameSeason.addContractStaffMember(samestrategist3);

        race = new Race(new Setup(Setup.LOW_RISK), new Strategy(Strategy.HIGH_RISK), "Circuit de Monaco", 8);
        samerace = new Race(new Setup(Setup.LOW_RISK), new Strategy(Strategy.HIGH_RISK), "Circuit de Monaco", 8);
        this.season.addRace(race);
        this.sameSeason.addRace(samerace);
        this.otherSeason.addRace(race);

        simple = "{\"currentRound\":0,\"rounds\":[],\"teams\":[],\"contractAerodynamicists\":[],\"contractDrivers\":[],\"contractMechanics\":[],\"contractStrategists\":[]}";
        otherSeason.setCurrentRound(5);
        this.jsonStringSpaces = "{\n\"currentRound\":0,\n\"rounds\":[\n{\"userSetup\":{\"risk\":1},\"userStrategy\":{\"risk\":3},\"trackName\":\"Circuit de Monaco\",\"roundInChampionship\":8}],\"teams\":[{\"name\":\"F2\",\"manager\":\"User\",\"budget\":2500000,\"pointsAlltime\":0,\"pointsThisSeason\":0,\"winsAlltime\":0,\"winsThisSeason\":0,\"engine\":{\"power\":900,\"drivability\":70,\"fuelConsumption\":80,\"name\":\"Mercedes\"},\"aerodynamicist\":{\"name\":\"Dan Fallows\",\"salary\":700000},\"mechanic\":{\"reliability\":50,\"partFixing\":50,\"pitstops\":50,\"name\":\"Steve Matchett\",\"salary\":100000},\"strategist\":{\"name\":\"Anonyme\",\"salary\":1000000},\"drivers\":[{\"speed\":50,\"raceCraft\":50,\"strategyInsight\":50,\"raceWins\":0,\"points\":0,\"championLastYear\":false,\"name\":\"Kimi Raikkonen\",\"salary\":16},{\"speed\":58,\"raceCraft\":52,\"strategyInsight\":40,\"raceWins\":0,\"points\":0,\"championLastYear\":true,\"name\":\"Lewis Hamilton\",\"salary\":18}]}]}";
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getCurrentRoundTest() {
        assertEquals(this.race, this.season.getCurrentRound());
    }

    @Test
    public void getTeamsTest() {
        assertEquals(this.season.getTeams(), this.sameSeason.getTeams());
    }

    @Test
    public void getTeamTest() {
        Team team2 = new Team("F2", "User", 2500000,
                engine, aerodynamicist, mechanic, strategist);
        team2.setPointsThisSeason(1);
        this.season.addTeam(team2);

        assertEquals(team2, this.season.getTeam(1));
    }

    @Test
    public void getCurrentRoundException() {
        Season exceptSeason = new Season();
        exceptSeason.addRace(race);
        exceptSeason.addTeam(team);
        exceptSeason.setCurrentRound(1);
        expectedException.expect(IllegalArgumentException.class);
        exceptSeason.getCurrentRound();
    }

    @Test
    public void addAeroToContract() {
        season.addContractStaffMember(aerodynamicist);
        assertTrue(season.getContractAerodynamicists().contains(aerodynamicist));
    }

    @Test
    public void addDriverToContract() {
        season.addContractStaffMember(driver);
        assertTrue(season.getContractDrivers().contains(driver));
    }

    @Test
    public void addMechanicToContract() {
        season.addContractStaffMember(mechanic);
        assertTrue(season.getContractMechanics().contains(mechanic));
    }

    @Test
    public void addStratToContract() {
        season.addContractStaffMember(strategist);
        assertTrue(season.getContractStrategists().contains(strategist));
    }

    @Test
    public void addContractAero() {
        season.addContractStaffMember(aerodynamicist);
        assertTrue(season.getContractAerodynamicists().contains(aerodynamicist));
    }

    @Test
    public void addContractDriver() {
        season.addContractStaffMember(driver);
        assertTrue(season.getContractDrivers().contains(driver));
    }

    @Test
    public void addContractMechanic() {
        season.addContractStaffMember(mechanic);
        assertTrue(season.getContractMechanics().contains(mechanic));
    }

    @Test
    public void addContractStrat() {
        season.addContractStaffMember(strategist);
        assertTrue(season.getContractStrategists().contains(strategist));
    }

    @Test
    public void playerControlledDrivers() {
        ArrayList<Staff> driverList = new ArrayList<>();
        driverList.add(driver3);
        driverList.add(aerodynamicist3);
        driverList.add(mechanic3);
        driverList.add(strategist3);
        driverList.add(driver4);
        driverList.add(driver5);
        driverList.add(aerodynamicist2);
        driverList.add(mechanic2);
        driverList.add(strategist2);
        assertEquals(driverList, season.getAllNonPlayerControlledStaff());
    }

    @Test
    public void transferDriverBudget() {
        season.transfer(driver4, team);
        assertEquals(2499000, team.getBudget());
    }

    @Test
    public void transferDriverBudget2() {
        season.transfer(driver4, team);
        assertEquals(2501000, team2.getBudget());
    }

    @Test
    public void transferDriverRemove() {
        season.transfer(driver4, team);
        assertFalse(team.getFirstDriver().equals(driver));
    }

    @Test
    public void transferDriverAdd() {
        season.transfer(driver4, team);
        assertTrue(team.getFirstDriver().equals(driver4));
    }

    @Test
    public void transferDriverOldTeam() {
        season.transfer(driver4, team);
        assertFalse(team2.getFirstDriver().equals(driver4));
    }

    @Test
    public void transferDriverOldTeam3() {
        season.transfer(driver4, team);
        assertEquals(team2.getSecondDriver(), driver5);
    }

    @Test
    public void transferDriverOldTeam2() {
        season.transfer(driver4, team);
        assertTrue(team2.getFirstDriver().equals(driver3));
    }

    @Test
    public void transferSecondDriver() {
        season.transfer(driver5, team);
        assertEquals(team2.getFirstDriver(), driver4);
    }

    @Test
    public void transferSecondDriver2() {
        season.transfer(driver5, team);
        assertEquals(team2.getSecondDriver(), driver3);
    }

    @Test
    public void replaceSecondDriver() {
        season.transfer(driver5, team, true);
        assertEquals(team.getFirstDriver(), driver);
    }

    @Test
    public void replaceSecondDriver2() {
        season.transfer(driver5, team, true);
        assertEquals(team.getSecondDriver(), driver5);
    }

    @Test
    public void replaceSecondDriver3() {
        season.transfer(driver5, team, true);
        assertTrue(season.getContractDrivers().contains(driver2));
    }

    @Test
    public void transferDriverContract() {
        season.transfer(driver4, team);
        assertFalse(season.getContractDrivers().contains(driver3));
    }

    @Test
    public void transferDriverContract2() {
        season.transfer(driver4, team);
        assertTrue(season.getContractDrivers().contains(driver));
    }

    @Test
    public void transferContractStrat() {
        season.transfer(strategist3, team);
        assertEquals(2500000, team.getBudget());
    }

    @Test
    public void transferContractStrat2() {
        season.transfer(strategist3, team);
        assertFalse(season.getContractStrategists().contains(strategist3));
    }

    @Test
    public void transferContractStrat3() {
        season.transfer(strategist3, team);
        assertTrue(season.getContractStrategists().contains(strategist));
    }

    @Test
    public void transferContractStrat4() {
        season.transfer(strategist3, team);
        assertEquals(team.getStrategist(), strategist3);
    }

    @Test
    public void transferTeamStrat() {
        season.transfer(strategist2, team);
        assertEquals(strategist2, team.getStrategist());
    }

    @Test
    public void transferTeamStrat2() {
        season.transfer(strategist2, team);
        assertEquals(strategist3, team2.getStrategist());
    }

    @Test
    public void transferTeamStrat3() {
        season.transfer(strategist2, team);
        assertTrue(season.getContractStrategists().contains(strategist));
    }

    @Test
    public void transferTeamMechanic() {
        season.transfer(mechanic2, team);
        assertEquals(mechanic2, team.getMechanic());
    }

    @Test
    public void transferTeamMechanic2() {
        season.transfer(mechanic2, team);
        assertEquals(mechanic3, team2.getMechanic());
    }

    @Test
    public void transferTeamMechanic3() {
        season.transfer(mechanic2, team);
        assertTrue(season.getContractMechanics().contains(mechanic));
    }

    @Test
    public void transferTeamAero() {
        season.transfer(aerodynamicist2, team);
        assertEquals(aerodynamicist2, team.getAerodynamicist());
    }

    @Test
    public void transferTeamAero2() {
        season.transfer(aerodynamicist2, team);
        assertEquals(aerodynamicist3, team2.getAerodynamicist());
    }

    @Test
    public void transferTeamAero3() {
        season.transfer(aerodynamicist2, team);
        assertTrue(season.getContractAerodynamicists().contains(aerodynamicist));
    }

    @Test
    public void roundIntTest() {
        assertEquals(0, season.getRoundInt());
    }

    @Test
    public void setCurrentRoundTest() {
        assertEquals(5, otherSeason.getRoundInt());
    }

    @Test
    public void getContractAeroTest() {
        ArrayList<Aerodynamicist> list = new ArrayList<>();
        list.add(aerodynamicist3);
        assertEquals(list, season.getContractAerodynamicists());
    }

    @Test
    public void getContractDrivers() {
        ArrayList<Driver> list = new ArrayList<>();
        list.add(driver3);
        assertEquals(list, season.getContractDrivers());
    }

    @Test
    public void getContractMechanics() {
        ArrayList<Mechanic> list = new ArrayList<>();
        list.add(mechanic3);
        assertEquals(list, season.getContractMechanics());
    }

    @Test
    public void getContractStrategists() {
        ArrayList<Strategist> list = new ArrayList<>();
        list.add(strategist3);
        assertEquals(list, season.getContractStrategists());
    }

    @Test
    public void getPlayerControlledTeamTest() {
        assertEquals(team, season.getPlayerControlledTeam());
    }

    @Test
    public void equalsSame() {
        assertEquals(season, sameSeason);
    }

    @Test
    public void equalsDifferent() {
        assertNotEquals(season, otherSeason);
    }

    @Test
    public void equalsSameMemory() {
        assertEquals(season, season);
    }

    @Test
    public void toJsonTest() {
        assertEquals(simple, simpleSeason.toJson());
    }

    @Test
    public void toJsonPrettyTest() {
        String prettySimple = "{\n  \"currentRound\": 0,\n  \"rounds\": [],\n  \"teams\": [],\n  \"contractAerodynamicists\": [],\n  \"contractDrivers\": [],\n  \"contractMechanics\": [],\n  \"contractStrategists\": []\n}";
        assertEquals(prettySimple, simpleSeason.toJsonPretty());
    }

    @Test
    public void fromJsonTest() {
        assertEquals(simpleSeason, Season.fromJson(simple));
    }

    @Test
    public void fromJsonSpaces() {
        assertNotEquals(season, Season.fromJson(jsonStringSpaces));
    }

    @Test
    public void fromJsonFail() {
        expectedException.expect(JsonSyntaxException.class);
        Season.fromJson("unexpected string");
    }

    @Test
    public void readFromJsonFileTest() throws IOException {
        InputStream is = new ByteArrayInputStream(simple.getBytes(StandardCharsets.UTF_8));

        assertEquals(simpleSeason, Season.readFromJsonFile(is));
    }

    @Test
    public void readFromJsonSpaces() throws IOException {
        InputStream is = new ByteArrayInputStream(jsonStringSpaces.getBytes(StandardCharsets.UTF_8));

        assertNotEquals(season, Season.readFromJsonFile(is));
    }

    @Test
    public void equalsOtherObject() {
        assertNotEquals(season, new String());
    }

    @Test
    public void equalsDiffNumRounds() {
        sameSeason.setRounds(new ArrayList<>());
        assertNotEquals(season, sameSeason);
    }

    @Test
    public void setRound() {
        sameSeason.setRounds(new ArrayList<>());
        assertEquals(new ArrayList<Race>(), sameSeason.getRounds());
    }

    @Test
    public void equalsDiffNumDrivers() {
        sameSeason.addContractStaffMember(driver);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffNumAero() {
        sameSeason.addContractStaffMember(aerodynamicist);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffNumMech() {
        sameSeason.addContractStaffMember(mechanic);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffNumStrat() {
        sameSeason.addContractStaffMember(strategist);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffDriver() {
        samedriver3.setPoints(200);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffMech() {
        samemechanic3.setSalary(31);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffAero() {
        sameaerodynamicist3.setSalary(31);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffStrat() {
        samestrategist3.setSalary(13);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffTeams() {
        sameteam.setBudget(1);
        assertNotEquals(sameSeason, season);
    }

    @Test
    public void equalsDiffRace() {
        // TODO no set methods in race
    }

    @Test
    public void nonPlayerEngines() {
        ArrayList<Engine> engineList = new ArrayList<>();
        engineList.add(otherEngine);
        assertEquals(engineList, season.getNonPlayerEngines());
    }

    @Test
    public void nonPlayerEngines2() {
        ArrayList<Engine> engineList = new ArrayList<>();
        season.getTeams().get(1).setEngine(engine);
        assertEquals(engineList, season.getNonPlayerEngines());
    }


}

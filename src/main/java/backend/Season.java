package backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Season {
    private int currentRound;
    private List<Race> rounds;
    private List<Team> teams;

    /**
     * Create a new season.
     */
    public Season() {
        this.currentRound = 0;
        this.rounds = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    /**
     * Gets the current round.
     *
     * @return current round
     */
    public int getRoundInt() {
        return currentRound;
    }

    /**
     * Gets the current round.
     *
     * @return current race
     */
    public Race getCurrentRound() {
        if (this.currentRound >= this.rounds.size()) {
            throw new IllegalArgumentException("Current round does not exist in this.rounds");
        }
        return this.rounds.get(this.currentRound);
    }

    /**
     * Sets the current round.
     *
     * @param currentRound the round to be set to current Round
     */
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    /**
     * Adds a team to the season.
     *
     * @param team the team to add
     */
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    /**
     * Adds a race to the rounds.
     *
     * @param race the race to add
     */
    public void addRace(Race race) {
        this.rounds.add(race);
    }

    /**
     * Converts the current Season class to a json object.
     *
     * @return string containing a json representation of the current season
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Converts the current Season class to a human-readable json String.
     * This method should for example be used for SeasonStart.json,
     * because that file needs to be edited by humans frequently.
     * However, if we are getting ready for production, it would be better
     * to minimize SeasonStart.json.
     *
     * @return String containing a json representation of the Season
     */
    public String toJsonPretty() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    /**
     * Converts the jsonString to a Season class.
     *
     * @param jsonString a json String representing a Season class
     * @return a season class
     */
    public static Season fromJson(String jsonString) throws JsonSyntaxException {
        Gson gson = new Gson();

        return gson.fromJson(jsonString, Season.class);
    }

    /**
     * Reads a json file representing a season and stores it as a Season object.
     * Currently, it fails fast, instead of catching errors. But this can be changed
     * depending on the project requirements.
     *
     * @param inputFile a scanner of a json file containing a Season
     * @return a season
     * @throws IOException throws if the file does not exist
     */
    public static Season readFromJsonFile(InputStream inputFile) throws IOException {
        Scanner sc = new Scanner(inputFile);
        sc.useDelimiter("//Z");
        String fileString = sc.next();
        return fromJson(fileString);
    }

    public static Season loadNewGameFromSeasonStart() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream seasonStart = loader.getResourceAsStream("seasonStart.json");
        return readFromJsonFile(seasonStart);
    }


    /**
     * Writes json to a file.
     * Use the following article for reference:
     * http://www.oracle.com/technetwork/articles/java/trywithresources-401775.html
     *
     * @param filename file to write to
     * @throws IOException throws in rare cases (I'm not sure when)
     */
    public void writeToJsonFile(String filename) throws IOException {
        try(FileOutputStream out = new FileOutputStream(filename)) {
            // Change next line to toJsonPretty() if you want readable output.
            String jsonString = toJson();
            out.write(jsonString.getBytes());
        }
    }

    /**
     * Checks if two season classes are the same.
     *
     * @param other the class you want to test equality for.
     * @return true if other is the same as the current class, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Season) {
            Season that = (Season) other;

            if (this.rounds.size() != that.rounds.size()) {
                return false;
            }
            for (Race round : this.rounds) {
                if (!(that.rounds.contains(round))) {
                    return false;
                }
            }
            if (this.teams.size() != that.teams.size()) {
                return false;
            }
            for (Team team : this.teams) {
                if (!(that.teams.contains(team))) {
                    return false;
                }
            }
            return this.currentRound == that.currentRound;
        }
        return false;
    }

    /**
     * Temporary main. Use this to test the Json write and read functionality.
     *
     * @param args Nothing
     * @throws IOException If the file or directory does not exist
     */
    public static void main(String[] args) throws IOException {
        Season season = Season.loadNewGameFromSeasonStart();
        season.writeToJsonFile("saves/save1.json");
    }
}

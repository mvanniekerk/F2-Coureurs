package backend;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Season {
    private int currentRound;

    /**
     * Create a new season.
     *
     */
    public Season() {
        this.currentRound = 0;
        // Yin, the constructor is temporary. Feel free to change it.
        // You will need to update the Tests and the equals method!!!
    }

    /**
     * Gets the current round.
     *
     * @return current round
     */
    public int getCurrentRound() {
        return currentRound;
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
     * Converts the current Season class to a json object.
     *
     * @return string containing a json representation of the current season
     */
    public String toJson() {
        Gson gson = new Gson();
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
    public static Season readFromJsonFile(Scanner inputFile) throws IOException {
        String fileString = inputFile.nextLine();
        return fromJson(fileString);
    }

    /**
     * Writes json to a file, fails fast.
     *
     * @param filename file to write to
     * @throws IOException throws in rare cases (I'm not sure when)
     */
    public void writeToJsonFile(String filename) throws IOException {
        FileOutputStream out = new FileOutputStream(filename);
        String jsonString = toJson();
        out.write(jsonString.getBytes());
        out.flush();
        out.close();
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

            return this.currentRound == that.currentRound;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Season season = new Season();
        season.writeToJsonFile("save.json");
    }
}

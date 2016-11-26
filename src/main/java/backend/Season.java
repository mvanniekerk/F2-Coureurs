package backend;

import com.google.gson.Gson;

import java.io.File;
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
        // Yin, je kan hier verder alles toevoegen,
        // ik heb deze class alleen aangemaakt voor de json parser.
    }

    /**
     * Gets the current round.
     *
     * @return Current round
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /**
     * Converts the current Season class to a json object.
     *
     * @return String containing a json representation of the current season.
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Converts the jsonString to a Season class.
     *
     * @param jsonString A json String representing a Season class
     * @return A season class
     */
    public static Season fromJson(String jsonString) {
        Gson gson = new Gson();

        return gson.fromJson(jsonString, Season.class);
    }


    /**
     * Reads a json file representing a season and stores it as a Season object.
     * Currently, it fails fast, instead of catching errors. But this can be changed
     * depending on the project requirements.
     *
     * @param filename A file-location of a json file containing a Season
     * @return A season
     * @throws IOException throws if the file does not exist
     */
    public static Season fromJsonFile(String filename) throws IOException {
        Scanner sc = new Scanner(new File(filename));
        String fileString = sc.nextLine();
        return fromJson(fileString);

    }

    /**
     * Checks if two season classes are the same.
     *
     * @param other The class you want to test equality for.
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


}

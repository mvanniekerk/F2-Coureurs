package frontend.controllers;

import backend.Season;
import backend.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Random;

public class HomeController {

    @FXML
    private Button buttonPrepareRace;

    @FXML
    private Button quitGame;

    @FXML
    private Label teamName;


    @FXML
    public void initialize() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream seasonStart = loader.getResourceAsStream("seasonStart.json");
        Season season = Season.readFromJsonFile(seasonStart);

        int random = new Random().nextInt(season.getTeams().size());
        Team winningTeam = season.getTeams().get(random);

        teamName.setText(winningTeam.getName());


    }

    /**
     * Show the prepare race screen.
     *
     * @param event the event that called this method
     * @throws Exception if view is not found
     */
    @FXML
    public void prepareRaceAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/prepare-race.fxml"));
        Stage stage = (Stage) buttonPrepareRace.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}

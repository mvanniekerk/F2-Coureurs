package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EditTeamController {
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    @FXML private Label budget;
    private Season season;

    /**
     * Sets the budget for the team to the right value.
     */
    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();
        Team playerTeam = season.getPlayerControlledTeam();

        budget.setText(playerTeam.getBudgetString());
    }

    /**
     * Cancels all the changes by loading the json file from save.
     * Returns to the home screen after clicking.
     *
     * @param event not using it
     * @throws IOException throws if the home screen fxml doesn't exist
     */
    @FXML
    public void cancel(ActionEvent event) throws IOException {
        // TODO generalize the save-game name by adding an attribute to Season

        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        GameEngine.getInstance().setSeason(Season.load("save1.json"));
        season = GameEngine.getInstance().getSeason();

        stage.getScene().setRoot(root);
    }

    /**
     * Saves the changes to the json file and return to the home screen.
     *
     * @param event not using it
     * @throws IOException throws if the home screen fxml doesn't exist
     */
    @FXML
    public void save(ActionEvent event) throws IOException {
        // TODO generalize the save-game name by adding an attribute to Season

        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        season.save("save1.json");

        stage.getScene().setRoot(root);
    }


}

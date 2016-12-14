package main.java.frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button buttonPrepareRace;

    @FXML
    private Label teamName;

    @FXML
    private Label engineName;

    @FXML
    private Label firstDriverName;

    @FXML
    private Label secondDriverName;

    @FXML
    private Label strategistName;

    @FXML
    private Label aerodynamicistName;

    @FXML
    private Label mechanicName;

    @FXML
    private Label nextCircuit;

    @FXML
    private Label currentBudget;

    private Season season;


    /**
     * Initialize the home screen with the correct values.
     */
    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();

        Team playerTeam = season.getPlayerControlledTeam();
        teamName.setText(playerTeam.getName());
        engineName.setText(playerTeam.getEngine().getName());
        firstDriverName.setText(playerTeam.getFirstDriver().getName());
        secondDriverName.setText(playerTeam.getSecondDriver().getName());
        strategistName.setText(playerTeam.getStrategist().getName());
        aerodynamicistName.setText(playerTeam.getAerodynamicist().getName());
        mechanicName.setText(playerTeam.getMechanic().getName());
        nextCircuit.setText(season.getCurrentRound().getTrackName());
        currentBudget.setText(playerTeam.getBudgetString());

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

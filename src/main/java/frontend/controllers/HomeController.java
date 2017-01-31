package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    public static boolean trigger;

    @FXML private Label teamName;
    @FXML private Label engineName;
    @FXML private Label firstDriverName;
    @FXML private Label secondDriverName;
    @FXML private Label strategistName;
    @FXML private Label aerodynamicistName;
    @FXML private Label mechanicName;
    @FXML private Label nextCircuit;
    @FXML private Label currentBudget;
    @FXML private MediaView mediaView;
    private Season season;

    /**
     * Initialize the home screen with the correct values.
     */
    @FXML
    public void initialize() throws Exception {
        trigger = true; // Indicate the screen welcome had been opened once
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

        Media media = new Media(getClass().getResource("/media/video/australia.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setMute(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setFitHeight(1080);
        mediaView.setFitWidth(1920);

    }

}

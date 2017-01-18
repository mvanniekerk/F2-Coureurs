package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class StandingsController {
    private Season season;
    private Team playerControlled;
    @FXML private Pane teamTable;
    @FXML private Pane driverTable;
    @FXML private MediaView mediaView;
    @FXML private MediaPlayer mediaPlayer;

    /**
     * Show the champion standings.
     */
    public void initialize() {

        mediaView.setFitHeight(1080);
        mediaView.setFitWidth(1920);
        mediaPlayer.setMute(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        season = GameEngine.getInstance().getSeason();
        playerControlled = season.getPlayerControlledTeam();

        teamTable.getChildren().add(setTeamPane());
        driverTable.getChildren().add(setDriverPane());
    }

    private Pane setTeamPane() {
        Pane returnPane = new Pane();
        for (int i = 1; i <= 11; i++) {
            Label teamNLabel = new Label(season.getTeam(i).getName());
            teamNLabel.setLayoutY(30 * i);

            Label teamSLabel = new Label(String.valueOf(season.getTeam(i).getPointsThisSeason()));
            teamSLabel.setLayoutX(580);
            teamSLabel.setLayoutY(30 * i);

            if (teamNLabel.getText().equals(playerControlled.getName())) {
                teamNLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 0.59)");
                teamSLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 0.59)");
            }
            returnPane.getChildren().add(teamNLabel);
            returnPane.getChildren().add(teamSLabel);
        }
        return returnPane;
    }

    private Pane setDriverPane() {
        Pane returnPane = new Pane();
        for (int i = 1; i <= 22; i++) {
            Label driverNLabel = new Label(season.getDriver(i).getName());
            driverNLabel.setLayoutY(30 * i);

            Label driverTLabel = new Label(season.getDriver(i).getTeamName(season));
            driverTLabel.setLayoutX(250);
            driverTLabel.setLayoutY(30 * i);

            Label driverPLabel = new Label(String.valueOf(season.getDriver(i).getPoints()));
            driverPLabel.setLayoutX(580);
            driverPLabel.setLayoutY(30 * i);

            if (driverNLabel.getText().equals(playerControlled.getFirstDriver().getName())
                    || driverNLabel.getText().equals(playerControlled.getSecondDriver().getName())) {
                driverNLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 0.59)");
                driverTLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 0.59)");
                driverPLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 0.59)");
            }

            returnPane.getChildren().add(driverNLabel);
            returnPane.getChildren().add(driverTLabel);
            returnPane.getChildren().add(driverPLabel);
        }
        return returnPane;
    }
}


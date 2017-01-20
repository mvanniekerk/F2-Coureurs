package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Team> teamsCopy = new ArrayList<>(season.getTeams());
        Collections.sort(teamsCopy);
        int counter = 0;
        for (Team team : teamsCopy) {
            Label teamNLabel = new Label(team.getName());
            teamNLabel.setLayoutY(30 * counter);

            Label teamSLabel = new Label(String.valueOf(team.getPointsThisSeason()));
            teamSLabel.setLayoutX(580);
            teamSLabel.setLayoutY(30 * counter);

            if (teamNLabel.getText().equals(playerControlled.getName())) {
                teamNLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 1.00)");
                teamSLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 1.00)");
            }
            returnPane.getChildren().add(teamNLabel);
            returnPane.getChildren().add(teamSLabel);
            counter++;
        }
        return returnPane;
    }

    private Pane setDriverPane() {
        Pane returnPane = new Pane();
        for (int i = 0; i <= 21; i++) {
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
                driverNLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 1.00)");
                driverTLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 1.00)");
                driverPLabel.setStyle("-fx-text-fill: rgba(0, 255, 0, 1.00)");
            }

            returnPane.getChildren().add(driverNLabel);
            returnPane.getChildren().add(driverTLabel);
            returnPane.getChildren().add(driverPLabel);
        }
        return returnPane;
    }
}


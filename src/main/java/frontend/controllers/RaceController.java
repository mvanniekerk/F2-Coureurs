package frontend.controllers;

import backend.Aerodynamicist;
import backend.Driver;
import backend.GameEngine;
import backend.Mechanic;
import backend.Race;
import backend.Season;
import backend.Setup;
import backend.Strategist;
import backend.Strategy;
import backend.Team;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RaceController {

    @FXML private TableView<Driver> resultsTable;
    @FXML private Button continueButton;
    @FXML private MediaView mediaView;

    private Season season;

    /**
     * Start the race.
     *
     * @param setup the setup of the user
     * @param strategy the strategy of the user
     */
    public void startRace(Setup setup, Strategy strategy) throws Exception {
        season = GameEngine.getInstance().getSeason();

        Media media = new Media(getClass().getResource("/media/video/raceresult.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setMute(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setFitHeight(1080);
        mediaView.setFitWidth(1920);


        // Create new race
        Race race = new Race(
            setup,
            strategy,
            season.getCurrentRound().getTrackName(),
            season.getRoundInt()
        );

        // Create list of drivers
        ObservableList<Driver> drivers =
                FXCollections.observableArrayList(calculateRaceResult(race));

        // Process the results of the race
        processResults(drivers);

        // Add drivers to the table
        resultsTable.setItems(drivers);


        // Create position column
        TableColumn<Driver, String> positionColumn = new TableColumn<>("Pos.");
        positionColumn.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<Driver, String>, ObservableValue<String>>() {

                @Override
                public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<Driver, String> driverObject
                ) {
                    return new SimpleStringProperty(
                        (resultsTable.getItems().indexOf(driverObject.getValue()) + 1) + ""
                    );
                }
            }
        );
        positionColumn.prefWidthProperty().bind(resultsTable.widthProperty().multiply(0.1));

        // Create name column
        TableColumn<Driver, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<Driver, String>, ObservableValue<String>>() {

                @Override
                public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<Driver, String> driverObject
                ) {
                    return new SimpleStringProperty(driverObject.getValue().getName());
                }
            }
        );
        nameColumn.prefWidthProperty().bind(resultsTable.widthProperty().multiply(0.3));

        // Create team column
        TableColumn<Driver, String> teamColumn = new TableColumn<>("Team");
        teamColumn.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<Driver, String>, ObservableValue<String>>() {

                @Override
                public ObservableValue<String> call(
                        TableColumn.CellDataFeatures<Driver, String> driverObject
                ) {
                    return new SimpleStringProperty(driverObject.getValue()
                            .getTeam(season).getName());
                }
            }
        );
        teamColumn.prefWidthProperty().bind(resultsTable.widthProperty().multiply(0.3));

        ArrayList<Integer> points = new ArrayList<>(Arrays.asList(25, 18, 15, 12, 10, 8, 6, 4, 2, 1));
        for (int x = 10; x < 22; x++) {
            points.add(0);
        }

        // Create points column
        TableColumn<Driver, String> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Driver, String>,
                        ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(
                            TableColumn.CellDataFeatures<Driver, String> driverObject
                    ) {
                        return new SimpleStringProperty("" + points.get(resultsTable.getItems().indexOf(driverObject.getValue())) + "");
                    }
                }
        );
        pointsColumn.prefWidthProperty().bind(resultsTable.widthProperty().multiply(0.25));

        // Add columns to the table
        resultsTable.getColumns().addAll(positionColumn, nameColumn, teamColumn, pointsColumn);
    }

    /**
     * Calculate the result of the race.
     *
     * @return the sorted list of the drivers determined by the race formula.
     */
    public List<Driver> calculateRaceResult(Race race) {
        List<Team> teams = season.getTeams();

        ArrayList<Driver> drivers = new ArrayList<>();

        for (Team team: teams) {
            Driver driver1 = team.getFirstDriver();
            Driver driver2 = team.getSecondDriver();

            if (season.getPlayerControlledTeam().equals(team)) {
                driver1.setScore(race.calculatePointsOfDriver(driver1, team.getEngine(), team.getMechanic(),
                        team.getStrategist(), team.getAerodynamicist(), race.getSetup(), race.getStrategy()));

                driver2.setScore(race.calculatePointsOfDriver(driver2, team.getEngine(), team.getMechanic(),
                        team.getStrategist(), team.getAerodynamicist(), race.getSetup(), race.getStrategy()));
            } else {
                Random random = new Random();

                // +1 because Setup and Strategy expects a number between 1-3
                Setup randomSetup = new Setup(random.nextInt(3) + 1);
                Strategy randomStrategy = new Strategy(random.nextInt(3) + 1);

                driver1.setScore(race.calculatePointsOfDriver(driver1, team.getEngine(), team.getMechanic(),
                        team.getStrategist(), team.getAerodynamicist(), randomSetup, randomStrategy));

                driver2.setScore(race.calculatePointsOfDriver(driver2, team.getEngine(), team.getMechanic(),
                        team.getStrategist(), team.getAerodynamicist(), randomSetup, randomStrategy));
            }

            drivers.add(driver1);
            drivers.add(driver2);
        }

        // Sort drivers by score
        drivers.sort((driver1, driver2) -> {
            float score1 = driver1.getScore();
            float score2 = driver2.getScore();

            if (score1 < score2) {
                return 1;
            }
            if (score1 > score2) {
                return -1;
            }
            return 0;
        });

        race.setResult(drivers);
        return race.getResult();
    }

    /**
     * Process the race results.
     *
     * @param drivers the ordered driver list of the race
     */
    private void processResults(List<Driver> drivers) {
        int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

        // Update points for drivers and teams that are in the top 10
        for (int i = 0; i < 10; i++) {
            Driver driver = drivers.get(i);
            driver.setPoints(driver.getPoints() + points[i]);

            Team team = driver.getTeam(season);
            team.setPointsThisSeason(team.getPointsThisSeason() + points[i]);
            team.setBudget(team.getBudget() + points[i] * 2000000);
        }

        // Update budget of teams
        for (Team team : season.getTeams()) {
            Driver firstDriver = team.getFirstDriver();
            Driver secondDriver = team.getSecondDriver();

            Mechanic mechanic = team.getMechanic();
            Aerodynamicist aerodynamicist = team.getAerodynamicist();
            Strategist strategist = team.getStrategist();

            team.setBudget(team.getBudget()
                - firstDriver.getSalary()
                - secondDriver.getSalary()
                - mechanic.getSalary()
                - aerodynamicist.getSalary()
                - strategist.getSalary()
                - (team.getEngine().getPrice() / season.getRounds().size())
            );
        }

        // If the players' budget is below zero show game over screen
        if (season.getPlayerControlledTeam().getBudget() < 0) {
            continueButton.setText("Game over");
            continueButton.setOnAction(event -> {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/views/game-over.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();

                stage.getScene().setRoot(root);
            });

            return;
        } else {
            double random = Math.random();
            if (random < 0.3) {
                continueButtonHandler();
            }
        }

        // Increase salary of winning driver by 1%
        Driver winningDriver = drivers.get(0);
        winningDriver.setSalary(winningDriver.getSalary() + (winningDriver.getSalary() / 100));

        if (season.getRoundInt() == 20) {
            // End of season
            setupNewSeason();
        } else {
            season.setCurrentRound(season.getRoundInt() + 1);
        }
    }

    private void continueButtonHandler() {
        List<Team> nonPlayerTeams = season.getTeams().stream()
                        .filter(team -> !team.equals(season.getPlayerControlledTeam()))
                        .collect(Collectors.toList());
        Team randomTeam = nonPlayerTeams.get(new Random().nextInt(nonPlayerTeams.size()));
        continueButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/views/message.fxml"));
                Parent root;
                root = loader.load();
                frontend.controllers.TransferOfferController controller = loader.getController();
                double randomPlayer = Math.random();
                if (randomPlayer < 0.2) {
                    controller.load(randomTeam, season.getPlayerControlledTeam().getFirstDriver());
                } else if (randomPlayer < 0.4) {
                    controller.load(randomTeam, season.getPlayerControlledTeam().getSecondDriver());
                } else if (randomPlayer < 0.6) {
                    controller.load(randomTeam, season.getPlayerControlledTeam().getAerodynamicist());
                } else if (randomPlayer < 0.8) {
                    controller.load(randomTeam, season.getPlayerControlledTeam().getMechanic());
                } else {
                    controller.load(randomTeam, season.getPlayerControlledTeam().getStrategist());
                }
                System.out.println("handling event");
                Stage stage = (Stage) continueButton.getScene().getWindow();
                stage.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setupNewSeason() {
        continueButton.setPickOnBounds(false);
        continueButton.setText("The End");
        continueButton.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/views/end-of-season.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.getScene().setRoot(root);
        });

        // Remove champion from last year
        for (Team team : season.getTeams()) {
            if (team.getFirstDriver().isChampionLastYear()) {
                team.getFirstDriver().setChampionLastYear(false);
                break;
            }

            if (team.getSecondDriver().isChampionLastYear()) {
                team.getSecondDriver().setChampionLastYear(false);
                break;
            }
        }

        // Set current champion and increase salary by 10%
        Driver champion = season.getDriver(0);
        champion.setChampionLastYear(true);
        champion.setSalary(champion.getSalary() + (champion.getSalary() / 10));

        // Add 200M championship bonus
        Team constructorChampion = season.getTeamByRank(0);
        constructorChampion.setBudget(constructorChampion.getBudget() + 200000000);

        // Reset season to first round
        season.setCurrentRound(0);

        // Reset points of teams and drivers
        for (Team team : season.getTeams()) {
            team.setPointsThisSeason(0);

            team.getFirstDriver().setPoints(0);
            team.getSecondDriver().setPoints(0);
        }
    }
}

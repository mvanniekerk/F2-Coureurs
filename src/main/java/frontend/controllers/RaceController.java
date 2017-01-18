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
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;

public class RaceController {

    @FXML private TableView<Driver> resultsTable;
    @FXML private Button continueButton;

    private Season season;

    /**
     * Start the race.
     *
     * @param setup the setup of the user
     * @param strategy the strategy of the user
     */
    public void startRace(Setup setup, Strategy strategy) {
        season = GameEngine.getInstance().getSeason();

        // Create new race
        Race race = new Race(
            setup,
            strategy,
            season.getCurrentRound().getTrackName(),
            season.getRoundInt()
        );

        // Create list of drivers
        ObservableList<Driver> drivers =
                FXCollections.observableArrayList(race.calculateRaceResult());

        // Process the results of the race
        processResults(drivers);

        // Add drivers to the table
        resultsTable.setItems(drivers);

        // Create position column
        TableColumn<Driver, String> positionColumn = new TableColumn<>("#");
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

        // Create score column
        TableColumn<Driver, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<Driver, String>,
                    ObservableValue<String>>() {

                @Override
                public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<Driver, String> driverObject
                ) {
                    return new SimpleStringProperty("" + driverObject.getValue().getScore());
                }
            }
        );

        // Add columns to the table
        resultsTable.getColumns().addAll(positionColumn, nameColumn, teamColumn, scoreColumn);
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

        // Increase salary of winning driver by 1%
        Driver winningDriver = drivers.get(0);
        winningDriver.setSalary(winningDriver.getSalary() + (winningDriver.getSalary() / 100));

        if (season.getRoundInt() == 1) {
            // End of season
            setupNewSeason();
        } else {
            season.setCurrentRound(season.getRoundInt() + 1);
        }
    }

    private void setupNewSeason() {
        continueButton.setText("End of season");
        continueButton.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
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

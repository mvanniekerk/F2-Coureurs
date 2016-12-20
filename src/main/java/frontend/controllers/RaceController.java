package frontend.controllers;

import backend.Driver;
import backend.GameEngine;
import backend.Race;
import backend.Season;
import backend.Setup;
import backend.Strategy;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class RaceController {

    @FXML
    private TableView<Driver> resultsTable;

    private Season season;

    /**
     * Initialize the RaceController.
     */
    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();

        // Print test race
        Race race = new Race(
                new Setup(Setup.HIGH_RISK),
                new Strategy(Strategy.HIGH_RISK),
                "Monaco",
                1
        );

        ObservableList<Driver> drivers =
                FXCollections.observableArrayList(race.calculateRaceResult());

        resultsTable.setItems(drivers);

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

        resultsTable.getColumns().addAll(positionColumn, nameColumn, scoreColumn);
    }
}

package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SelectEngineController {
    private Season season;
    @FXML private Label engineName;
    @FXML private Label engineQuality;
    @FXML private Label newEngineName;
    @FXML private Label newQuality;
    @FXML private Label newPrice;
    @FXML private Label budget;
    @FXML private Pane engineTable;



    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();
    }

    @FXML
    public void confirm(ActionEvent event) throws IOException {

    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {

    }
}

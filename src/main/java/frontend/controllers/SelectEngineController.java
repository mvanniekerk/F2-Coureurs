package frontend.controllers;

import backend.Engine;
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
        engineName.setText(season.getPlayerControlledTeam().getEngine().getName());
        engineQuality.setText(season.getPlayerControlledTeam().getEngine().getQualityString());

        engineTable.getChildren().clear();
        int inc = 0;
        for (Engine engine : season.getNonPayerEngines()) {
            engineTable.getChildren().add(getEnginePane(engine, inc));
            inc++;
        }
    }

    @FXML
    private Pane getEnginePane(Engine engine, int position) {
        Pane returnPane = new Pane();
        returnPane.setOnMouseClicked((event) -> {
            newEngineName.setText(engine.getName());
            newPrice.setText("$ 2,000,000.00");
            newQuality.setText(engine.getQualityString());
        });
        returnPane.setLayoutY(35 * position);

        Label nameLabel = new Label(engine.getName());
        nameLabel.getStyleClass().add("table-content");
        returnPane.getChildren().add(nameLabel);

        Label priceLabel = new Label("$ 2,000,000.00");
        priceLabel.getStyleClass().add("table-content");
        priceLabel.setLayoutX(220);
        returnPane.getChildren().add(priceLabel);

        Label qualityLabel = new Label(engine.getQualityString());
        qualityLabel.getStyleClass().add("table-content");
        qualityLabel.setLayoutX(440);
        returnPane.getChildren().add(qualityLabel);

        return returnPane;
    }

    @FXML
    public void confirm(ActionEvent event) throws IOException {

    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {

    }
}

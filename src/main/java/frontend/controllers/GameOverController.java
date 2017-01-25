package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {

    @FXML private Button startNewGame;

    /**
     * Initialize the home screen with the correct values.
     */
    @FXML
    public void initialize() {
        startNewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameEngine.getInstance().setSeason(Season.loadNewGameFromSeasonStart());

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();

                stage.getScene().setRoot(root);
            }
        });
    }
}

package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class PrepareRaceController {
    /**
     * Start the race.
     *
     * @param event the event that called this method
     * @throws Exception if view is not found
     */
    @FXML
    public void startRace(ActionEvent event) throws Exception {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/race-result.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}

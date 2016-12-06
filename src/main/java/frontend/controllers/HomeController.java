package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button buttonPrepareRace;

    @FXML
    private Button quitGame;

    /**
     * Show the prepare race screen.
     *
     * @param event the event that called this method
     * @throws Exception if view is not found
     */
    @FXML
    public void prepareRaceAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/prepare-race.fxml"));
        Stage stage = (Stage) buttonPrepareRace.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    @FXML
    public void quitGameAction(ActionEvent event) {
        Stage stage = (Stage) quitGame.getScene().getWindow();
        stage.close();

    }
}

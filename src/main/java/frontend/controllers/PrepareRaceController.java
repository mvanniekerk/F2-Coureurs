package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrepareRaceController extends RaceController {

    @FXML
    private Button quitGame;

    @FXML
    public void quitGameAction(ActionEvent event) {
        Stage stage = (Stage) quitGame.getScene().getWindow();
        stage.close();
    }

}

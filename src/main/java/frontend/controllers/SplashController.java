package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SplashController {

    @FXML
    private Button buttonNext;

    @FXML
    private void buttonClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        Stage stage = (Stage) buttonNext.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}

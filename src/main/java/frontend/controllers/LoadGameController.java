package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class LoadGameController {
    @FXML
    private Button a;
    @FXML
    private Button b;
    @FXML
    private Button c;
    @FXML
    private Button d;
    private String saveName;

    public void game(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();

        if (button == a) {
            saveName = "save1.json";
        } else if (button == b) {
            saveName = "saveB.json";
        } else if (button == c) {
            saveName = "saveC.json";
        } else if (button == d) {
            saveName = "saveD.json";
        }

        File file = new File("saves/" + saveName);
        if (file.exists()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
            Parent root = loader.load();
            HomeController controller = loader.getController();
            controller.initialize(saveName);

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.getScene().setRoot(root);
        } else {
            button.setStyle("-fx-background-color: rgba(255, 0, 0, 0.59)");
        }
    }
}
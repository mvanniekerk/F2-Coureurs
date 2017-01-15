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
    private Button gameA;
    @FXML
    private Button gameB;
    @FXML
    private Button gameC;
    @FXML
    private Button gameD;

    private String saveName;

    /**
     * <p>Constructs Button that loads the load-game screen when clicked.
     *  Game A is saved in save1.json
     *  Game B is saved in saveB.json
     *  Game C is saved in saveC.json
     *  Game D is saved in saveD.json
     * </p>
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the fxml file can not be found
     */
    public void game(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();

        if (button == gameA) {
            saveName = "save1.json";
        } else if (button == gameB) {
            saveName = "saveB.json";
        } else if (button == gameC) {
            saveName = "saveC.json";
        } else if (button == gameD) {
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
package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadGameController {

    /**
     * Load Game A
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the json file can not be found
     */
    @FXML
    public void gameA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.initialize("save1.json");

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    /**
     * Load Game B.
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the json file can not be found
     */
    @FXML
    public void gameB(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.initialize("save2.json");

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    /**
     * Load Game C.
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the json file can not be found
     */
    @FXML
    public void gameC(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.initialize("save3.json");

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    /**
     * Load Game D.
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the json file can not be found
     */
    @FXML
    public void gameD(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.initialize("save4.json");

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}

package frontend.controllers;

import backend.GameEngine;
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
    @FXML private Button gameA;
    @FXML private Button gameB;
    @FXML private Button gameC;
    @FXML private Button gameD;

    @FXML private Button deleteA;
    @FXML private Button deleteB;
    @FXML private Button deleteC;
    @FXML private Button deleteD;

    private String saveName;

    private File fileA;
    private File fileB;
    private File fileC;
    private File fileD;

    /**
     * If the file exists, the player is able to delete it and start again.
     */
    public void initialize() {
        fileA = new File("saves/saveA.json");
        fileB = new File("saves/saveB.json");
        fileC = new File("saves/saveC.json");
        fileD = new File("saves/saveD.json");

        if (!fileA.exists()) {
            deleteA.setVisible(false);
            gameA.getStyleClass().add("create");
        }
        if (!fileB.exists()) {
            deleteB.setVisible(false);
            gameB.getStyleClass().add("create");
        }
        if (!fileC.exists()) {
            deleteC.setVisible(false);
            gameC.getStyleClass().add("create");
        }
        if (!fileD.exists()) {
            deleteD.setVisible(false);
            gameD.getStyleClass().add("create");
        }
    }

    /**
     * Delete the game and refresh the page afterward.
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     */
    public void deleteGame(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (button == deleteA) {
            fileA.delete();
        } else if (button == deleteB) {
            fileB.delete();
        } else if (button == deleteC) {
            fileC.delete();
        } else if (button == deleteD) {
            fileD.delete();
        }
        initialize();
    }

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
            saveName = "saveA.json";
        } else if (button == gameB) {
            saveName = "saveB.json";
        } else if (button == gameC) {
            saveName = "saveC.json";
        } else if (button == gameD) {
            saveName = "saveD.json";
        }

        new GameEngine.GameEngineBuilder(saveName).build();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        Parent root = loader.load();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}
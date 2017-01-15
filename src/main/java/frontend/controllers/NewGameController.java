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

public class NewGameController {
    @FXML private Button create;
    private File file;
    private File fileB;
    private File fileC;
    private File fileD;

    /**
     * Declare the pathname of the files.
     */
    public void initialize () {
        file = new File("saves/save1.json");
        fileB = new File("saves/saveB.json");
        fileC = new File("saves/saveC.json");
        fileD = new File("saves/saveD.json");
    }

    /**
     * <p>Button handler goes to load a screen to create a new team.
     * A new GameEngine is created if the total json file is less than 4.
     * For now the game will be forced exist if the 4 json file already exist.
     * </p>
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the fxml file can not be found
     */
    @FXML
    public void create(ActionEvent event) throws IOException {
        if (file.exists() && fileB.exists() && fileC.exists() && fileD.exists()) {
            System.out.println("You can't create a new game");
            System.exit(1);
        } else if (file.exists() && fileB.exists() && fileC.exists()) {
            new GameEngine.GameEngineBuilder("saveD.json").build();
        } else if (file.exists() && fileB.exists()) {
            new GameEngine.GameEngineBuilder("saveC.json").build();
        } else if (file.exists()) {
            new GameEngine.GameEngineBuilder("saveB.json");
        } else {
            new GameEngine.GameEngineBuilder("save1.json");
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/edit-team.fxml"));
        Parent root = loader.load();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    /**
     * Button handler goes to the screen to choose from a existing team.
     *
     * @param event ActionEvent that the button experienced (presumably a button-press).
     * @throws IOException throws if the fxml file can not be found
     */
    @FXML
    public void existing(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/newgame-existing.fxml"));
        Parent root = loader.load();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.getScene().setRoot(root);
    }
}
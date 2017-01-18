package frontend;

import backend.GameEngine;
import backend.Season;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeButton extends Button {
    private Season season;
    private String saveName;

    /**
     * Constructs a new Home Button that loads the home screen when clicked.
     *
     */
    public HomeButton() {
        season = GameEngine.getInstance().getSeason();
        saveName = GameEngine.getInstance().getSaveName();
        season.save(saveName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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

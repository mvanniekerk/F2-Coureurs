package frontend;

import backend.GameEngine;
import backend.Season;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ExitButton extends Button {
    private Season season;
    private String saveName;

    /**
     * Constructs a new Exit Button that closes the application when clicked.
     *
     */
    public ExitButton() {
        season = GameEngine.getInstance().getSeason();
        saveName = GameEngine.getInstance().getSaveName();
        season.save(saveName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}

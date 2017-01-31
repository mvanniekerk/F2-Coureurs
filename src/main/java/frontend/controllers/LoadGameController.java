package frontend.controllers;

import backend.Aerodynamicist;
import backend.Driver;
import backend.Engine;
import backend.GameEngine;
import backend.Mechanic;
import backend.Season;
import backend.Strategist;
import backend.Team;
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

    @FXML private Button existingA;
    @FXML private Button existingB;
    @FXML private Button existingC;
    @FXML private Button existingD;

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
        Button[] buttons = {gameA, gameB, gameC, gameD, existingA, existingB,
        existingC, existingD, deleteA, deleteB, deleteC, deleteD};

        for (Button button : buttons) {
            button.setPickOnBounds(false);
            button.setVisible(true);
        }

        fileA = new File("saves/saveA.json");
        fileB = new File("saves/saveB.json");
        fileC = new File("saves/saveC.json");
        fileD = new File("saves/saveD.json");

        if (!fileA.exists()) {
            deleteA.setVisible(false);
        } else {
            existingA.setVisible(false);
        }
        if (!fileB.exists()) {
            deleteB.setVisible(false);
        } else {
            existingB.setVisible(false);
        }
        if (!fileC.exists()) {
            deleteC.setVisible(false);
        } else {
            existingC.setVisible(false);
        }
        if (!fileD.exists()) {
            deleteD.setVisible(false);
        } else {
            existingD.setVisible(false);
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
     * Load from an existing game.
     * @param event not using it
     */
    public void existingGame(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (button == existingA) {
            goToNewGameExisting("saveA.json");
        } else if (button == existingB) {
            goToNewGameExisting("saveB.json");
        } else if (button == existingC) {
            goToNewGameExisting("saveC.json");
        } else if (button == existingD) {
            goToNewGameExisting("saveD.json");
        }
    }

    private void goToNewGameExisting(String saveName) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/newgame-existing.fxml"));
            Parent root = (Parent) loader.load();
            NewgameExistingController controller = loader.getController();
            controller.load(saveName);

            Stage stage = (Stage) existingA.getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Constructs Button that loads the load-game screen when clicked.
     *  Game A is saved in save1.json
     *  Game B is saved in saveB.json
     *  Game C is saved in saveC.json
     *  Game D is saved in saveD.json
     * </p>
     * <p>If a new file/game is created, the screen edit-team will be loaded.
     * The player can then form his team with 200 million € starting budget.
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

        FXMLLoader loader;
        if (new File("saves/" + saveName).exists()) {
            new GameEngine.GameEngineBuilder(saveName).build();
            loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        } else {
            new GameEngine.GameEngineBuilder(saveName).build();
            loader = new FXMLLoader(getClass().getResource("/views/edit-team.fxml"));
            // make a new team
            Driver driver1 = new Driver();
            Driver driver2 = new Driver();
            Aerodynamicist aerodynamicist = new Aerodynamicist();
            Mechanic mechanic = new Mechanic();
            Strategist strategist = new Strategist();
            Engine engine = new Engine();
            // TODO: Allow player to choose a name
            Team playerTeam = new Team("My Team", "That's me!", 200000000,
                    engine, aerodynamicist, mechanic, strategist);
            playerTeam.setFirstDriver(driver1);
            playerTeam.setSecondDriver(driver2);
            // Add the new team to the teams
            Season season = GameEngine.getInstance().getSeason();
            season.getTeams().add(0, playerTeam);
            // Add Williams team members to the contract list
            season.addContractStaffMember(season.getTeams().get(10).getFirstDriver());
            season.addContractStaffMember(season.getTeams().get(10).getSecondDriver());
            season.addContractStaffMember(season.getTeams().get(10).getAerodynamicist());
            season.addContractStaffMember(season.getTeams().get(10).getMechanic());
            season.addContractStaffMember(season.getTeams().get(10).getStrategist());
            // Remove Williams team from the competition
            season.getTeams().remove(10);
        }

        Parent root = loader.load();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}
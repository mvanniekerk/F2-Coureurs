package frontend.controllers;

import backend.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class NewgameExistingController {
    @FXML private Pane newgameExisting;
    @FXML private Pane ferrari;
    @FXML private Pane mercedes;
    @FXML private Pane redbull;
    @FXML private Pane mclaren;
    @FXML private Pane forceindia;
    @FXML private Pane haas;
    @FXML private Pane manor;
    @FXML private Pane renault;
    @FXML private Pane sauber;
    @FXML private Pane tororosso;
    @FXML private Pane williams;


    @FXML
    public void initialize() {
        ferrari.setOnMouseClicked((MouseEvent event) -> buttonAction("Ferrari"));
        mercedes.setOnMouseClicked((MouseEvent event) -> buttonAction("Mercedes"));
        redbull.setOnMouseClicked((MouseEvent event) -> buttonAction("Red Bull"));
        mclaren.setOnMouseClicked((MouseEvent event) -> buttonAction("McLaren"));
        forceindia.setOnMouseClicked((MouseEvent event) -> buttonAction("Force India"));
        haas.setOnMouseClicked((MouseEvent event) -> buttonAction("Haas"));
        manor.setOnMouseClicked((MouseEvent event) -> buttonAction("Manor"));
        renault.setOnMouseClicked((MouseEvent event) -> buttonAction("Renault"));
        sauber.setOnMouseClicked((MouseEvent event) -> buttonAction("Sauber"));
        tororosso.setOnMouseClicked((MouseEvent event) -> buttonAction("Toro Rosso"));
        williams.setOnMouseClicked((MouseEvent event) -> buttonAction("Williams"));

    }

    private void buttonAction(String teamName) {
        new GameEngine.GameEngineBuilder("save1.json").build();
        List<Team> teams = GameEngine.getInstance().getSeason().getTeams();
        List<String> teamstr = teams.stream().map((Team team) -> team.getName()).collect(Collectors.toList());
        System.out.println(teamstr);
        Team team = null;
        try {
            team = teams.stream()
                    .filter((Team te) -> te.getName().equals(teamName))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        teams.remove(team);
        teams.add(0, team);

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) newgameExisting.getScene().getWindow();
        stage.getScene().setRoot(root);
    }
}

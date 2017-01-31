package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Team;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class NewgameExistingController {
    @FXML private Pane newgameExisting;

    private void buttonAction(int teamNumber) throws IOException {
        Season season = GameEngine.getInstance().getSeason();
        List<Team> teams = season.getTeams();
        teams.add(0, teams.remove(teamNumber));

        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        Stage stage = (Stage) newgameExisting.getScene().getWindow();
        stage.getScene().setRoot(root);

    }

    @FXML
    public void ferrari(ActionEvent event) throws IOException {
        buttonAction(0);
    }

    @FXML
    public void mercedes(ActionEvent event) throws IOException {
        buttonAction(4);

    }

    @FXML
    public void redbull(ActionEvent event) throws IOException {
        buttonAction(6);

    }

    @FXML
    public void mclaren(ActionEvent event) throws IOException {
        buttonAction(3);

    }

    @FXML
    public void forceindia(ActionEvent event) throws IOException {
        buttonAction(1);

    }

    @FXML
    public void haas(ActionEvent event) throws IOException {
        buttonAction(2);
    }

    @FXML
    public void manor(ActionEvent event) throws IOException {
        buttonAction(5);

    }

    @FXML
    public void renault(ActionEvent event) throws IOException {
        buttonAction(7);

    }

    @FXML
    public void sauber(ActionEvent event) throws IOException {
        buttonAction(8);

    }

    @FXML
    public void torrorosso(ActionEvent event) throws IOException {
        buttonAction(9);

    }

    @FXML
    public void williams(ActionEvent event) throws IOException {
        buttonAction(10);

    }
}

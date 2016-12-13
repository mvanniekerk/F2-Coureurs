package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button buttonPrepareRace;

    @FXML
    private Button buttonChampionshipStandings;

    @FXML
    private Button buttonEditTeam;

    /**
     * Show the prepare race screen.
     *
     * @param event the event that called this method
     * @throws Exception if view is not found
     */
    @FXML
    public void prepareRaceAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/prepare-race.fxml"));
        Stage stage = (Stage) buttonPrepareRace.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    /**
     * Show the championship standings screen.
     *
     * @param event the event that called this method
     * @throws Exception if view is not found
     */
    @FXML
    public void championshipStandingsAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/standings.fxml"));
        Stage stage = (Stage) buttonChampionshipStandings.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    /**
     * Show the edit team screen.
     *
     * @param event the event that called this method
     * @throws Exception if view is not found
     */
    @FXML
    public void editTeamAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/edit-team.fxml"));
        Stage stage = (Stage) buttonEditTeam.getScene().getWindow();

        stage.getScene().setRoot(root);
    }
}

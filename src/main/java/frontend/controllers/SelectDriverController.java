package frontend.controllers;

import backend.Driver;
import backend.GameEngine;
import backend.Season;
import backend.Staff;
import backend.Team;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectDriverController {
    @FXML private Label driver1Name;
    @FXML private Label driver1Salary;
    @FXML private Label driver1Quality;
    @FXML private Pane playerTable;
    @FXML private Label newPlayerName;
    @FXML private Label newSalary;
    @FXML private Label newQuality;
    @FXML private Label newTeamName;
    @FXML private Label newBuyoutClause;
    private Season season;
    private Staff newStaffMember;

    /**
     * Initialises the controller with text.
     */
    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();
        Team playerTeam = season.getPlayerControlledTeam();

        driver1Name.setText(playerTeam.getFirstDriver().getName());
        driver1Salary.setText(playerTeam.getFirstDriver().getSalaryString());
        driver1Quality.setText(playerTeam.getFirstDriver().getQualityString());

        setAllPotentialTeamMembers();
    }

    private void setAllPotentialTeamMembers() {
        int increment = 1;
        for (Staff staff : season.getAllNonPlayerControlledDrivers().subList(0,15)) {
            playerTable.getChildren().add(getTeamMemberPane(staff, increment));
            increment++;
        }
    }

    /**
     * Confirm the changes and go to the edit team screen.
     *
     * @param event don't use it
     * @throws IOException throws if the fxml file can not be found
     */
    @FXML
    public void confirm(ActionEvent event) throws IOException {
        season.transferDriver1((Driver) newStaffMember);

        Parent root = FXMLLoader.load(getClass().getResource("/views/edit-team.fxml"));
        Stage stage = (Stage) driver1Name.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    /**
     * Throws away the changes and goes to the edit-team screen.
     *
     * @param event not using it
     * @throws IOException throws if the fxml file does not exist
     */
    @FXML
    public void cancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/edit-team.fxml"));
        Stage stage = (Stage) driver1Name.getScene().getWindow();

        stage.getScene().setRoot(root);
    }

    private Pane getTeamMemberPane(Staff staffMember, int position) {
        Pane returnPane = new Pane();
        returnPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                newPlayerName.setText(staffMember.getName());
                newQuality.setText(staffMember.getQualityString());
                newSalary.setText(staffMember.getSalaryString());
                newBuyoutClause.setText(staffMember.getBuyoutClauseString());
                newTeamName.setText(season.getTeamNameByMember(staffMember));
                newStaffMember = staffMember;
            }
        });
        returnPane.setLayoutY(35 * position);

        Label nameLabel = new Label(staffMember.getName());
        nameLabel.getStyleClass().add("table-content");
        returnPane.getChildren().add(nameLabel);

        Label currentTeamLabel = new Label(season.getTeamNameByMember(staffMember));
        currentTeamLabel.getStyleClass().add("table-content");
        currentTeamLabel.setLayoutX(220);
        returnPane.getChildren().add(currentTeamLabel);

        Label salaryLabel = new Label(staffMember.getSalaryString());
        salaryLabel.getStyleClass().add("table-content");
        salaryLabel.setLayoutX(440);
        returnPane.getChildren().add(salaryLabel);

        Label buyoutClauseLabel = new Label(staffMember.getBuyoutClauseString());
        buyoutClauseLabel.getStyleClass().add("table-content");
        buyoutClauseLabel.setLayoutX(660);
        returnPane.getChildren().add(buyoutClauseLabel);

        Label abilityLabel = new Label(staffMember.getQualityString());
        abilityLabel.getStyleClass().add("tabel-content");
        abilityLabel.setLayoutX(880);
        returnPane.getChildren().add(abilityLabel);

        return returnPane;
    }
}

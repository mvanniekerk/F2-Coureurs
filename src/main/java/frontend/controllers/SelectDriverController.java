package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Staff;
import backend.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SelectDriverController {
    @FXML private Label driver1Name;
    @FXML private Label driver1Salary;
    @FXML private Label driver1Quality;
    @FXML private Label driver2Name;
    @FXML private Label driver2Salary;
    @FXML private Label driver2Quality;
    @FXML private Pane playerTable;
    private Season season;

    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();
        Team playerTeam = season.getPlayerControlledTeam();

        driver1Name.setText(playerTeam.getFirstDriver().getName());
        driver1Salary.setText(playerTeam.getFirstDriver().getSalaryString());

        driver2Name.setText(playerTeam.getSecondDriver().getName());
        driver2Salary.setText(playerTeam.getSecondDriver().getSalaryString());
    }

    private Pane getTeamMemberPane(Staff staffMember) {
        Pane returnPane = new Pane();
        returnPane.setLayoutY(200);
        Label nameLabel = new Label(staffMember.getName());
        nameLabel.getStyleClass().add("table-content");
        returnPane.getChildren().add(nameLabel);
        // TODO set current team
        Label currentTeamLabel = new Label("Ferrari");
        currentTeamLabel.getStyleClass().add("table-content");
        currentTeamLabel.get
    }
}

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

        playerTable.getChildren().add(getTeamMemberPane(playerTeam.getFirstDriver(), 1));
    }

    private Pane getTeamMemberPane(Staff staffMember, int position) {
        Pane returnPane = new Pane();
        returnPane.setLayoutY(200 * position );

        Label nameLabel = new Label(staffMember.getName());
        nameLabel.getStyleClass().add("table-content");
        returnPane.getChildren().add(nameLabel);

        // TODO set current team
        Label currentTeamLabel = new Label("Ferrari");
        currentTeamLabel.getStyleClass().add("table-content");
        currentTeamLabel.setLayoutX(220);
        returnPane.getChildren().add(currentTeamLabel);

        Label salaryLabel = new Label(staffMember.getSalaryString());
        salaryLabel.getStyleClass().add("table-content");
        salaryLabel.setLayoutX(440);
        returnPane.getChildren().add(salaryLabel);

        Label buyoutClauseLabel = new Label(staffMember.getBuyoutlauseString());
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

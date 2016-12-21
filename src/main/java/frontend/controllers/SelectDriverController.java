package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Staff;
import backend.Team;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SelectDriverController {
    @FXML private Label driver1Name;
    @FXML private Label driver1Salary;
    @FXML private Label driver1Quality;
    @FXML private Label driver2Name;
    @FXML private Label driver2Salary;
    @FXML private Label driver2Quality;
    @FXML private Pane playerTable;
    @FXML private Label newPlayerName;
    @FXML private Label newSalary;
    @FXML private Label newQuality;
    @FXML private Label newTeamName;
    @FXML private Label newBuyoutClause;
    private Season season;

    @FXML
    public void initialize() {
        season = GameEngine.getInstance().getSeason();
        Team playerTeam = season.getPlayerControlledTeam();

        driver1Name.setText(playerTeam.getFirstDriver().getName());
        driver1Salary.setText(playerTeam.getFirstDriver().getSalaryString());
        driver1Quality.setText(playerTeam.getFirstDriver().getQualityString());

        driver2Name.setText(playerTeam.getSecondDriver().getName());
        driver2Salary.setText(playerTeam.getSecondDriver().getSalaryString());
        driver2Quality.setText(playerTeam.getFirstDriver().getQualityString());

        setAllPotentialTeamMembers();
    }

    private void setAllPotentialTeamMembers() {
        int increment = 1;
        for (Staff staff : season.getAllNonPlayerControlledDrivers().subList(0,15)) {
            playerTable.getChildren().add(getTeamMemberPane(staff, increment));
            increment++;
        }
    }

    private Pane getTeamMemberPane(Staff staffMember, int position) {
        Pane returnPane = new Pane();
        returnPane.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        newPlayerName.setText(staffMember.getName());
                        newQuality.setText(staffMember.getQualityString());
                        newSalary.setText(staffMember.getSalaryString());
                        newBuyoutClause.setText(staffMember.getBuyoutlauseString());
                        newTeamName.setText("Ferrari");
                    }
                });
                returnPane.setLayoutY(35 * position);

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

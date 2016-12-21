package frontend.controllers;

import backend.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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

    @FXML
    public void confirm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/edit-team.fxml"));
        Stage stage = (Stage) driver1Name.getScene().getWindow();

        season.removeDriverFromTeam((Driver) newStaffMember);
        season.getContractDrivers().add(season.getPlayerControlledTeam().getFirstDriver());
        season.getPlayerControlledTeam().setFirstDriver((Driver) newStaffMember);

        stage.getScene().setRoot(root);
    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/edit-team.fxml"));
        Stage stage = (Stage) driver1Name.getScene().getWindow();

        stage.getScene().setRoot(root);
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
                        newStaffMember = staffMember;
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

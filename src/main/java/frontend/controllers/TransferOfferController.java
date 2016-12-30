package frontend.controllers;

import backend.GameEngine;
import backend.Season;
import backend.Staff;
import backend.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TransferOfferController {
    @FXML private Label teamName;
    @FXML private Label personToTransfer;
    @FXML private Label priceLabel;
    private Team team;
    private Staff transferCandidate;
    private Season season;

    public void load(Team team, Staff transferCandidate) {
        season = GameEngine.getInstance().getSeason();
        this.team = team;
        this.transferCandidate = transferCandidate;

        teamName.setText(team.getName() + " would like to buy");
        personToTransfer.setText(transferCandidate.getJobTitle() + " " + transferCandidate.getName());
        priceLabel.setText("for " + transferCandidate.getBuyoutClauseString(season));
    }
}

package frontend.controllers;

import backend.Staff;
import backend.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TransferOfferController {
    @FXML private Label teamName;
    @FXML private Label personToTransfer;
    @FXML private Label priceLabel;
    Team team;
    Staff transferCandidate;
    int price;

    public void load(Team team, Staff transferCandidate, int price) {
        this.team = team;
        this.transferCandidate = transferCandidate;
        this.price = price;

        teamName.setText(team.getName() + " would like to buy");
        personToTransfer.setText(transferCandidate.getClass().toString() + " " + transferCandidate.getName());
        priceLabel.setText(String.valueOf(price));

    }
}

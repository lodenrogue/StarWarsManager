package com.lodenrogue.swrpg;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CurrencyController implements Initializable {
	private static CurrencyController instance;
	@FXML
	private Label totalXPLbl;
	@FXML
	private Label usedXPLbl;
	@FXML
	private Label unusedXPLbl;
	@FXML
	private Label totalObligationLbl;
	@FXML
	private Label totalCreditsLbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
	}

	public static CurrencyController getInstance() {
		return instance;
	}

	public Label getTotalXP() {
		return totalXPLbl;
	}

	public Label getUsedXP() {
		return usedXPLbl;
	}

	public Label getUnusedXP() {
		return unusedXPLbl;
	}

	public Label getTotalObligation() {
		return totalObligationLbl;
	}

	public Label getTotalCredits() {
		return totalCreditsLbl;
	}

}

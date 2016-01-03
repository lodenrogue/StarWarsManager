package com.lodenrogue.swrpg.charactergen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CharacteristicsDisplayController implements Initializable {
	private static CharacteristicsDisplayController instance;
	@FXML
	private Label soakLbl;
	@FXML
	private Label woundsLbl;
	@FXML
	private Label strainLbl;
	@FXML
	private Label defenseRangedLbl;
	@FXML
	private Label defendeMeleeLbl;
	@FXML
	private Label brawnLbl;
	@FXML
	private Label agilityLbl;
	@FXML
	private Label intellectLbl;
	@FXML
	private Label cunningLbl;
	@FXML
	private Label willpowerLbl;
	@FXML
	private Label presenceLbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
	}

	public static CharacteristicsDisplayController getInstance() {
		return instance;
	}

	public Label getSoak() {
		return soakLbl;
	}

	public Label getWounds() {
		return woundsLbl;
	}

	public Label getStrain() {
		return strainLbl;
	}

	public Label getDefenseRanged() {
		return defenseRangedLbl;
	}

	public Label getDefendeMelee() {
		return defendeMeleeLbl;
	}

	public Label getBrawn() {
		return brawnLbl;
	}

	public Label getAgility() {
		return agilityLbl;
	}

	public Label getIntellect() {
		return intellectLbl;
	}

	public Label getCunning() {
		return cunningLbl;
	}

	public Label getWillpower() {
		return willpowerLbl;
	}

	public Label getPresence() {
		return presenceLbl;
	}
}

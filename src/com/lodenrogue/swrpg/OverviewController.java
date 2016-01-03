package com.lodenrogue.swrpg;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class OverviewController implements Initializable {
	private static OverviewController instance;
	@FXML
	private Label characterNameLbl;
	@FXML
	private Label speciesLbl;
	@FXML
	private Label careerLbl;
	@FXML
	private Label specializationsLbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
	}

	public static OverviewController getInstance() {
		return instance;
	}

	public Label getCharacterName() {
		return characterNameLbl;
	}

	public Label getSpecies() {
		return speciesLbl;
	}

	public Label getCareer() {
		return careerLbl;
	}

	public Label getSpecializations() {
		return specializationsLbl;
	}

}

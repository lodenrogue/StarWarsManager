package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class SpeciesActivityController implements Initializable {
	@FXML
	private ComboBox<String> speciesBox;
	@FXML
	private AnchorPane speciesOptionsPane;
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
	@FXML
	private WebView bonusDescWebView;
	@FXML
	private WebView speciesDescWebView;
	@FXML
	private ImageView portraitView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		populateSpeciesBox();
	}

	@FXML
	public void onComboBoxChange(ActionEvent e) {
		if (e.getSource().equals(speciesBox)) {
			String choice = speciesBox.getSelectionModel().getSelectedItem();
			String speciesName = choice.toUpperCase().replace(" ", "_");
			Species species = Species.valueOf(speciesName);

			loadOptions(species);
			updatePortrait(species);
			updateDescriptions(species);
			updateStats(species);
		}
	}

	private void populateSpeciesBox() {
		// TODO populate species combo box
	}

	private void updatePortrait(Species species) {
		// TODO update portraitView to reflect chosen species
	}

	private void updateStats(Species species) {
		// TODO Update stats to reflect species choice
	}

	private void loadOptions(Species species) {
		// TODO Load species options into speciesOptionsPane
	}

	private void updateDescriptions(Species species) {
		updateSpeciesDescription(species);
		updateBonusDescription(species);
	}

	private void updateSpeciesDescription(Species species) {
		// TODO update species description webview
	}

	private void updateBonusDescription(Species species) {
		// TODO update bonus description webview
	}

}

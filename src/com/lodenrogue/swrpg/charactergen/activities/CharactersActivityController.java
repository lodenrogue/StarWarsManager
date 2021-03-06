package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class CharactersActivityController implements Initializable {
	@FXML
	private ListView<String> charactersList;
	@FXML
	private Button selectBtn;
	@FXML
	private Button removeBtn;
	@FXML
	private Button newBtn;
	@FXML
	private ImageView portraitView;
	@FXML
	private Label characterNameLbl;
	@FXML
	private Label playerNameLbl;
	@FXML
	private Label speciesLbl;
	@FXML
	private Label careerLbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			clearLabels();
			populateNames();
		});
	}

	private void clearLabels() {
		characterNameLbl.setText("");
		playerNameLbl.setText("");
		speciesLbl.setText("");
		careerLbl.setText("");
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(selectBtn)) {
			selectCharacter();
		}
		else if (e.getSource().equals(removeBtn)) {
			removeCharacter();
		}
		else if (e.getSource().equals(newBtn)) {
			createNewCharacter();
		}
	}

	private void createNewCharacter() {
		// TODO implement createNewCharacter
	}

	private void removeCharacter() {
		// TODO implement removeCharacter
	}

	private void selectCharacter() {
		// TODO implement selectCharacter
	}

	private void populateNames() {
		// TODO implement populateNames
	}
}

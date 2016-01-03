package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class DescriptionActivityController implements Initializable {
	@FXML
	private TextField playerNameField;
	@FXML
	private TextField characterNameField;
	@FXML
	private ComboBox<String> genderBox;
	@FXML
	private TextField ageField;
	@FXML
	private TextField heightField;
	@FXML
	private TextField buildField;
	@FXML
	private TextField hairField;
	@FXML
	private TextField eyesField;
	@FXML
	private ImageView portraitView;
	@FXML
	private Button selectPortraitBtn;
	@FXML
	private TextArea featuresArea;
	@FXML
	private TextField earnedXPField;
	@FXML
	private TextField totalCreditsField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> fillGenderBox());
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(selectPortraitBtn)) {
			selectPortrait();
		}
	}

	private void fillGenderBox() {
		// TODO implement fillGenderBox
	}

	private void selectPortrait() {
		// TODO implement selectPortrait
	}

}

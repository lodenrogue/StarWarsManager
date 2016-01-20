package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.charactergen.file.Saveable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class DescriptionActivityController implements Initializable, Saveable {
	private static final String ID = "description";
	private static DescriptionActivityController instance;

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
		instance = this;
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

	public static DescriptionActivityController getInstance() {
		return instance;
	}

	@Override
	public Map<String, String> getKeyValuePairs() {
		// TODO add data to map
		Map<String, String> kvp = new HashMap<>();
		return kvp;
	}

	@Override
	public String getName() {
		return ID;
	}

}

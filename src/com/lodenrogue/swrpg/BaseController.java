package com.lodenrogue.swrpg;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class BaseController implements Initializable {
	@FXML
	private Label currentScreenLbl;
	@FXML
	private Button charactersBtn;
	@FXML
	private Button descriptionBtn;
	@FXML
	private Button backgroundBtn;
	@FXML
	private Button obligationsBtn;
	@FXML
	private Button speciesBtn;
	@FXML
	private Button careerBtn;
	@FXML
	private Button characteristicsBtn;
	@FXML
	private Button specializationsBtn;
	@FXML
	private Button motivationsBtn;
	@FXML
	private Button skillsBtn;
	@FXML
	private Button equipmentBtn;
	@FXML
	private AnchorPane activityPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * When each button is pressed save the data state and switch the
	 * content of the activity pane. Update the text of currentScreenLbl.
	 * 
	 * @param e
	 */
	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(characteristicsBtn)) {
			saveData();
			loadActivity(ActivityState.CHARACTERS);
		}

		// Update currentScreenLbl
		if (e.getSource() instanceof Button) {
			currentScreenLbl.setText(((Button) e.getSource()).getText());
		}

	}

	private void loadActivity(ActivityState state) {
		if (state.equals(ActivityState.CHARACTERS)) {
			// TODO
		}
	}

	private void saveData() {
		// TODO
	}

}

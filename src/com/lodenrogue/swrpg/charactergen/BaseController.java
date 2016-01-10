package com.lodenrogue.swrpg.charactergen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.charactergen.activities.ActivityState;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
		try {
			charactersBtn.setDisable(true);
			loadActivity(ActivityState.CHARACTERS);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * When each button is pressed the data state is saved and the content
	 * of the activity pane is switched. Current screen label is updated to
	 * reflect this change.
	 * 
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void onButtonPressed(ActionEvent e) throws IOException {
		saveData();
		resetButtons();

		Button button = ((Button) e.getSource());
		button.setDisable(true);
		currentScreenLbl.setText(button.getText());

		if (button.equals(charactersBtn)) {
			loadActivity(ActivityState.CHARACTERS);
		}
		else if (button.equals(descriptionBtn)) {
			loadActivity(ActivityState.DESCRIPTION);
		}
		else if (button.equals(backgroundBtn)) {
			loadActivity(ActivityState.BACKGROUND);
		}
		else if (button.equals(obligationsBtn)) {
			loadActivity(ActivityState.OBLIGATIONS);
		}
		else if (button.equals(speciesBtn)) {
			loadActivity(ActivityState.SPECIES);
		}
		else if (button.equals(careerBtn)) {
			loadActivity(ActivityState.CAREER);
		}
	}

	private void saveData() {
		// TODO implement saveData
	}

	private void loadActivity(ActivityState state) throws IOException {
		String fxmlResource = "";
		if (state.equals(ActivityState.CHARACTERS)) {
			fxmlResource = "activities/characters_activity.fxml";
		}
		else if (state.equals(ActivityState.DESCRIPTION)) {
			fxmlResource = "activities/description_activity.fxml";
		}
		else if (state.equals(ActivityState.BACKGROUND)) {
			fxmlResource = "activities/background_activity.fxml";
		}
		else if (state.equals(ActivityState.OBLIGATIONS)) {
			fxmlResource = "activities/obligations_activity.fxml";
		}
		else if (state.equals(ActivityState.SPECIES)) {
			fxmlResource = "activities/species_activity.fxml";
		}
		else if (state.equals(ActivityState.CAREER)) {
			fxmlResource = "activities/career_activity.fxml";
		}

		if (fxmlResource.length() > 0) {
			final String resource = fxmlResource;
			Platform.runLater(() -> {
				try {
					Parent activityRoot = FXMLLoader.load(getClass().getResource(resource));
					activityPane.getChildren().setAll(activityRoot.getChildrenUnmodifiable());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	private void resetButtons() {
		charactersBtn.setDisable(false);
		descriptionBtn.setDisable(false);
		backgroundBtn.setDisable(false);
		obligationsBtn.setDisable(false);
		speciesBtn.setDisable(false);
		careerBtn.setDisable(false);
		characteristicsBtn.setDisable(false);
		specializationsBtn.setDisable(false);
		motivationsBtn.setDisable(false);
		skillsBtn.setDisable(false);
		equipmentBtn.setDisable(false);
	}

}

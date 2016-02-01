package com.lodenrogue.swrpg.charactergen;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.Main;
import com.lodenrogue.swrpg.charactergen.activities.ActivityState;
import com.lodenrogue.swrpg.charactergen.activities.BackgroundActivityController;
import com.lodenrogue.swrpg.charactergen.activities.CareerActivityController;
import com.lodenrogue.swrpg.charactergen.activities.DescriptionActivityController;
import com.lodenrogue.swrpg.charactergen.activities.ObligationsActivityController;
import com.lodenrogue.swrpg.charactergen.activities.SpeciesActivityController;
import com.lodenrogue.swrpg.file.DataSaver;

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
	private static final String DATA_FOLDER = "data/character_gen/";
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

	private DataSaver dataSaver;
	private UtilityController utility;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataSaver = new DataSaver(new HashSet<>());
		utility = UtilityController.getInstance();
		charactersBtn.setDisable(true);
		loadActivity(ActivityState.CHARACTERS);
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
	public void onButtonPressed(ActionEvent e) {
		saveData("tmp.txt");
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

	private void saveData(String fileName) {
		// TODO get character name or file save name from user
		try {
			utility.save(dataSaver, fileName);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadActivity(ActivityState state) {
		if (state.equals(ActivityState.CHARACTERS)) {
			Platform.runLater(() -> loadActivityUI("characters_activity.fxml"));
		}
		else if (state.equals(ActivityState.DESCRIPTION)) {
			Platform.runLater(() -> {
				loadActivityUI("description_activity.fxml");
				dataSaver.addSaveable(DescriptionActivityController.getInstance());
			});
		}
		else if (state.equals(ActivityState.BACKGROUND)) {
			Platform.runLater(() -> {
				loadActivityUI("background_activity.fxml");
				dataSaver.addSaveable(BackgroundActivityController.getInstance());
			});
		}
		else if (state.equals(ActivityState.OBLIGATIONS)) {
			Platform.runLater(() -> {
				loadActivityUI("obligations_activity.fxml");
				dataSaver.addSaveable(ObligationsActivityController.getInstance());
			});
		}
		else if (state.equals(ActivityState.SPECIES)) {
			Platform.runLater(() -> {
				loadActivityUI("species_activity.fxml");
				dataSaver.addSaveable(SpeciesActivityController.getInstance());
			});
		}
		else if (state.equals(ActivityState.CAREER)) {
			Platform.runLater(() -> {
				loadActivityUI("career_activity.fxml");
				dataSaver.addSaveable(CareerActivityController.getInstance());
			});
		}
	}

	private void loadActivityUI(String fileName) {
		try {
			Parent activityRoot = FXMLLoader.load(Main.class.getResource(DATA_FOLDER + fileName));
			activityPane.getChildren().setAll(activityRoot.getChildrenUnmodifiable());
		}
		catch (Exception e) {
			e.printStackTrace();
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

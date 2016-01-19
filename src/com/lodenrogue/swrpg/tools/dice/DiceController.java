package com.lodenrogue.swrpg.tools.dice;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.tools.dice.result.Result;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class DiceController implements Initializable {
	@FXML
	private ComboBox<Integer> proficiencyBox;
	@FXML
	private ComboBox<Integer> challengeBox;
	@FXML
	private ComboBox<Integer> abilityBox;
	@FXML
	private ComboBox<Integer> difficultyBox;
	@FXML
	private ComboBox<Integer> boostBox;
	@FXML
	private ComboBox<Integer> setbackBox;
	@FXML
	private ComboBox<Integer> forceBox;
	@FXML
	private Button rollBtn;
	@FXML
	private Button resetBtn;

	private ResultsController resultsController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resultsController = ResultsController.getInstance();
		Platform.runLater(() -> initializeBoxes());
	}

	private void initializeBoxes() {
		List<Integer> diceAmount = new ArrayList<>();
		diceAmount.add(0);
		diceAmount.add(1);
		diceAmount.add(2);
		diceAmount.add(3);
		diceAmount.add(4);
		diceAmount.add(5);

		proficiencyBox.getItems().addAll(diceAmount);
		challengeBox.getItems().addAll(diceAmount);
		abilityBox.getItems().addAll(diceAmount);
		difficultyBox.getItems().addAll(diceAmount);
		boostBox.getItems().addAll(diceAmount);
		setbackBox.getItems().addAll(diceAmount);
		forceBox.getItems().addAll(diceAmount);

		reset();
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(rollBtn)) {
			roll();
		}
		else if (e.getSource().equals(resetBtn)) {
			reset();
		}
	}

	private void reset() {
		proficiencyBox.getSelectionModel().select(0);
		challengeBox.getSelectionModel().select(0);
		abilityBox.getSelectionModel().select(0);
		difficultyBox.getSelectionModel().select(0);
		boostBox.getSelectionModel().select(0);
		setbackBox.getSelectionModel().select(0);
		forceBox.getSelectionModel().select(0);

		resultsController.clearResults();
	}

	private void roll() {
		resultsController.clearResults();
		List<Result> results = DiceUtils.getNetResults(rollDice());
		updateResults(results);
	}

	/**
	 * @param results
	 */
	private void updateResults(List<Result> results) {
		for (Result r : results) {
			resultsController.addResult(r);
		}
	}

	/**
	 * @return
	 */
	private List<Die> rollDice() {
		List<Die> dice = new ArrayList<>();

		int proficiency = proficiencyBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < proficiency; i++) {
			Die d = new Die(DieType.PROFICIENCY);
			d.roll();
			dice.add(d);
		}
		int challenge = challengeBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < challenge; i++) {
			Die d = new Die(DieType.CHALLENGE);
			d.roll();
			dice.add(d);
		}
		int ability = abilityBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < ability; i++) {
			Die d = new Die(DieType.ABILITY);
			d.roll();
			dice.add(d);
		}
		int difficulty = difficultyBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < difficulty; i++) {
			Die d = new Die(DieType.DIFFICULTY);
			d.roll();
			dice.add(d);
		}
		int boost = boostBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < boost; i++) {
			Die d = new Die(DieType.BOOST);
			d.roll();
			dice.add(d);
		}
		int setback = setbackBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < setback; i++) {
			Die d = new Die(DieType.SETBACK);
			d.roll();
			dice.add(d);
		}
		int force = forceBox.getSelectionModel().getSelectedItem();
		for (int i = 0; i < force; i++) {
			Die d = new Die(DieType.FORCE);
			d.roll();
			dice.add(d);
		}
		return dice;
	}
}

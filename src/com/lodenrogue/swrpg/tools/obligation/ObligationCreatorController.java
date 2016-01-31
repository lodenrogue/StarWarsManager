package com.lodenrogue.swrpg.tools.obligation;

import java.net.URL;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.MathUtils;
import com.lodenrogue.swrpg.WordUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ObligationCreatorController implements Initializable {
	@FXML
	private TextField playerNameField;
	@FXML
	private Label playerNameLbl;
	@FXML
	private TextField characterNameField;
	@FXML
	private Label characterNameLbl;
	@FXML
	private ComboBox<String> obligationsBox;
	@FXML
	private TextField amountField;
	@FXML
	private Label amountLbl;
	@FXML
	private Button createBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> populateObligations());
	}

	private void populateObligations() {
		for (ObligationType o : ObligationType.values()) {
			obligationsBox.getItems().add(WordUtils.capitalize(o.toString()));
		}
		obligationsBox.getSelectionModel().select(0);
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(createBtn)) {
			createPlayer(e);
		}
	}

	private void createPlayer(ActionEvent e) {
		String playerName = playerNameField.getText();
		boolean playerNameValid = validateName(playerName, playerNameLbl);

		String characterName = characterNameField.getText();
		boolean characterNameValid = validateName(characterName, characterNameLbl);

		String obligationText = obligationsBox.getSelectionModel().getSelectedItem();
		ObligationType obligationType = ObligationType.valueOf(obligationText.toUpperCase());

		String amountText = amountField.getText();
		int amount = MathUtils.parseInt(amountText, -1000);
		boolean amountValid = validateAmount(amount);

		if (playerNameValid && characterNameValid && amountValid) {
			Player player = new Player();
			player.setPlayerName(playerName);
			player.setCharacterName(characterName);
			player.setObligation(new Obligation(obligationType, amount));

			ObligationsController.getInstance().addRow(player);
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.close();
		}
	}

	private boolean validateAmount(int amount) {
		if (amount < 0) {
			amountLbl.setTextFill(Color.RED);
			return false;
		}
		else {
			amountLbl.setTextFill(Color.BLACK);
			return true;
		}
	}

	private boolean validateName(String name, Label label) {
		if (name.length() == 0) {
			label.setTextFill(Color.RED);
			return false;
		}
		else {
			label.setTextFill(Color.BLACK);
			return true;
		}
	}

}

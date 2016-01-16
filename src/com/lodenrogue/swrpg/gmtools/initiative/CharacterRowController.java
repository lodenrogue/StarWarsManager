package com.lodenrogue.swrpg.gmtools.initiative;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CharacterRowController implements Initializable {
	@FXML
	private TextField successField;
	@FXML
	private TextField advantageField;
	@FXML
	private ComboBox<String> entityTypeBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> initializeBox());

	}

	private void initializeBox() {
		ObservableList<String> options = FXCollections.observableArrayList();
		options.add("PC");
		options.add("NPC");
		entityTypeBox.setItems(options);
		entityTypeBox.getSelectionModel().select(0);
	}

	public String getType() {
		return entityTypeBox.getSelectionModel().getSelectedItem();
	}

	public int getSuccess() {
		return parseInt(successField.getText(), 0);
	}

	public int getAdvantage() {
		return parseInt(advantageField.getText(), 0);
	}

	public int parseInt(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		}
		catch (NumberFormatException ex) {
			return defaultValue;
		}
	}

}

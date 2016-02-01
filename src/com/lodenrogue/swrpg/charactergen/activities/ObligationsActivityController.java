package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.file.Saveable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

public class ObligationsActivityController implements Initializable, Saveable {
	private static final String ID = "obligations";
	private static ObligationsActivityController instance;

	@FXML
	private TableView<String> obligationsTable;
	@FXML
	private Button newBtn;
	@FXML
	private Button removeBtn;
	@FXML
	private TextArea notesArea;
	@FXML
	private WebView descWebView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		Platform.runLater(() -> populateTable());
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(newBtn)) {
			createNew();
		}
		else if (e.getSource().equals(removeBtn)) {
			remove();
		}
	}

	private void createNew() {
		// TODO Create new obligation
	}

	private void remove() {
		// TODO Remove obligation
	}

	private void populateTable() {
		// TODO populate table with obligations
	}

	public static ObligationsActivityController getInstance() {
		return instance;
	}

	@Override
	public Map<String, String> getKeyValuePairs() {
		// TODO add data to map
		Map<String, String> kvp = new HashMap<>();
		return kvp;
	}

	@Override
	public String getId() {
		return ID;
	}

	// private void onItemSelected() {
	// // TODO Update descWebView when a row is selected
	// }

}

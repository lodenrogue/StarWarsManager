package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

public class ObligationsActivityController implements Initializable {
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
		populateTable();
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

	// private void onItemSelected() {
	// // TODO Update descWebView when a row is selected
	// }

}

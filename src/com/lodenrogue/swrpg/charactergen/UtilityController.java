package com.lodenrogue.swrpg.charactergen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class UtilityController implements Initializable {
	@FXML
	private Button printBtn;
	@FXML
	private Button saveBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Do functionality
	 * 
	 * @param e
	 */
	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(printBtn)) {
			print();
		}
		else if (e.getSource().equals(saveBtn)) {
			save();
		}
	}

	private void print() {
		// TODO
	}

	private void save() {
		// TODO
	}

}

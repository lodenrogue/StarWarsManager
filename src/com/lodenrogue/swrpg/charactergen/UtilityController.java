package com.lodenrogue.swrpg.charactergen;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.charactergen.file.DataSaver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class UtilityController implements Initializable {
	private static UtilityController instance;
	@FXML
	private Button printBtn;
	@FXML
	private Button saveBtn;

	private DataSaver dataSaver;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		dataSaver = new DataSaver(new HashSet<>());
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
			// TODO Get save file name
			save(dataSaver, "tmp.txt");
		}
	}

	private void print() {
		// TODO implement print
	}

	public void save(DataSaver dataSaver, String fileName) {
		dataSaver.save(fileName);
	}

	public static UtilityController getInstance() {
		return instance;
	}

}

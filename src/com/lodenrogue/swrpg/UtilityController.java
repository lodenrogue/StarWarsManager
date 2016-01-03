package com.lodenrogue.swrpg;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public abstract class UtilityController implements Initializable {
	@FXML
	private Button printBtn;
	@FXML
	private Button saveBtn;

	@Override
	public abstract void initialize(URL location, ResourceBundle resources);

	/**
	 * Do the functionality of button
	 * 
	 * @param e
	 */
	@FXML
	public abstract void onButtonPressed(ActionEvent e);

}

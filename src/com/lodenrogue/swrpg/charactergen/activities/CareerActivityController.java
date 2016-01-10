package com.lodenrogue.swrpg.charactergen.activities;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

public class CareerActivityController implements Initializable {
	@FXML
	private ComboBox<String> careerComboBox;
	@FXML
	private ComboBox<String> specComboBox;
	@FXML
	private WebView careerWebView;
	@FXML
	private WebView specWebView;
	@FXML
	private CheckBox careerSkill1;
	@FXML
	private CheckBox careerSkill2;
	@FXML
	private CheckBox careerSkill3;
	@FXML
	private CheckBox careerSkill4;
	@FXML
	private CheckBox careerSkill5;
	@FXML
	private CheckBox careerSkill6;
	@FXML
	private CheckBox careerSkill7;
	@FXML
	private CheckBox careerSkill8;
	@FXML
	private CheckBox specSkill1;
	@FXML
	private CheckBox specSkill2;
	@FXML
	private CheckBox specSkill3;
	@FXML
	private CheckBox specSkill4;
	@FXML
	private Label careerSkillInfoLbl;
	@FXML
	private Label specSkillInfoLbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void onComboBoxChange(ActionEvent e) {
		if (e.getSource().equals(careerComboBox)) {
			String chosen = careerComboBox.getSelectionModel().getSelectedItem();
			Career career = Career.valueOf(chosen);
			updateCareerInfo(career);
			updateCareerSkills(career);
			updateSpecBox(career);
		}
		else if (e.getSource().equals(specComboBox)) {
			String chosen = specComboBox.getSelectionModel().getSelectedItem();
			Specialization spec = Specialization.valueOf(chosen);
			updateSpecInfo(spec);
			updateSpecSkills(spec);
		}
	}

	@FXML
	public void onCheckBoxEvent(ActionEvent e) {
		// TODO update appropriate label (careerSkillInfoLbl or
		// specSkillInfoLbl)
		// TODO make sure no more than the allowed skills are selected
	}

	private void updateCareerSkills(Career career) {
		// TODO update careerSkill check boxes
	}

	private void updateCareerInfo(Career career) {
		// TODO update careerWebView
	}

	private void updateSpecBox(Career career) {
		/*
		 * TODO
		 * 
		 * update specBox list based on chosen career
		 * 
		 * choose the first item in the list
		 * 
		 * update the specWebView
		 * 
		 * update the specSkills check boxes
		 */
	}

	private void updateSpecInfo(Specialization spec) {
		// TODO update specWebView
	}

	private void updateSpecSkills(Specialization spec) {
		// TODO update specSkill check boxes
	}

}

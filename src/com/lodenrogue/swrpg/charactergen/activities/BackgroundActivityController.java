package com.lodenrogue.swrpg.charactergen.activities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.charactergen.file.Saveable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

public class BackgroundActivityController implements Initializable, Saveable {
	private static final String SOCIAL_PATH = "data/social/";
	private static final String BACKGROUND_PATH = "data/background/";
	private static final String ID = "background";
	private static BackgroundActivityController instance;

	@FXML
	private ComboBox<String> socialClassBox;
	@FXML
	private WebView socialClassWebView;
	@FXML
	private ComboBox<String> backgroundBox;
	@FXML
	private WebView backgroundWebView;
	@FXML
	private TextArea storyArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		Platform.runLater(() -> {
			fillSocialClassBox();
			fillBackgroundBox();
		});
	}

	@FXML
	public void onComboBoxChange(ActionEvent e) {
		if (e.getSource().equals(socialClassBox)) {
			String pathName = getPathName(SOCIAL_PATH, socialClassBox);
			updateWebView(pathName, socialClassWebView);
		}
		else if (e.getSource().equals(backgroundBox)) {
			String pathName = getPathName(BACKGROUND_PATH, backgroundBox);
			updateWebView(pathName, backgroundWebView);
		}

	}

	private String getPathName(String pathPrefix, ComboBox<String> comboBox) {
		String pathName = pathPrefix;
		pathName += comboBox.getSelectionModel().getSelectedItem().toLowerCase();
		pathName = pathName.replace(" ", "_");
		pathName += ".html";
		return pathName;
	}

	private void updateWebView(String pathName, WebView webView) {
		try (BufferedReader reader = new BufferedReader(new FileReader(pathName))) {
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			Platform.runLater(() -> webView.getEngine().loadContent(sb.toString()));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fillSocialClassBox() {
		// TODO implement fillSocialClassBox
	}

	private void fillBackgroundBox() {
		// TODO implement fillBackgroundBox
	}

	public static BackgroundActivityController getInstance() {
		return instance;
	}

	@Override
	public Map<String, String> getKeyValuePairs() {
		//TODO add data to map
		Map<String, String> kvp = new HashMap<>();
		return kvp;
	}

	@Override
	public String getName() {
		return ID;
	}

}

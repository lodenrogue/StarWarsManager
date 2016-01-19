package com.lodenrogue.swrpg.tools.dice;

import java.net.URL;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.Main;
import com.lodenrogue.swrpg.tools.dice.result.Result;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ResultsController implements Initializable {
	private static final String IMAGE_PATH = Main.class.getResource("data/dice/").toExternalForm();
	private static ResultsController instance;
	@FXML
	private HBox resultsBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
	}

	public void clearResults() {
		resultsBox.getChildren().clear();
	}

	public void addResult(Result result) {
		String url = "";
		if (result.equals(Result.SUCCESS)) {
			url = IMAGE_PATH + "success.png";
		}
		else if (result.equals(Result.FAILURE)) {
			url = IMAGE_PATH + "failure.png";
		}
		else if (result.equals(Result.ADVANTAGE)) {
			url = IMAGE_PATH + "advantage.png";
		}
		else if (result.equals(Result.THREAT)) {
			url = IMAGE_PATH + "threat.png";
		}
		else if (result.equals(Result.TRIUMPH)) {
			url = IMAGE_PATH + "triumph.png";
		}
		else if (result.equals(Result.DESPAIR)) {
			url = IMAGE_PATH + "despair.png";
		}
		else if (result.equals(Result.DARK)) {
			url = IMAGE_PATH + "darkside.png";
		}
		else if (result.equals(Result.LIGHT)) {
			url = IMAGE_PATH + "lightside.png";
		}
		else if (result.equals(Result.FAILURE)) {
			url = IMAGE_PATH + "lightside.png";
		}
		else if (result.equals(Result.BLANK)) {
			url = IMAGE_PATH + "net_zero.png";
		}

		if (url.length() > 0) {
			ImageView resultImage = new ImageView(new Image(url));
			Platform.runLater(() -> resultsBox.getChildren().add(resultImage));
		}
	}

	public static ResultsController getInstance() {
		return instance;
	}

}

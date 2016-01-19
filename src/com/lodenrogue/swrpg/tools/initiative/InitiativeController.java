package com.lodenrogue.swrpg.tools.initiative;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.Main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class InitiativeController implements Initializable {
	@FXML
	private VBox characterRowsBox;
	@FXML
	private Button addBtn;
	@FXML
	private Button removeBtn;
	@FXML
	private Button findInitiativeBtn;
	@FXML
	private TextArea infoArea;

	private List<CharacterRowController> rows = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> initializeRows());
	}

	private void initializeRows() {
		for (int i = 1; i <= 2; i++) {
			addRow();
		}
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(addBtn)) {
			addRow();
		}
		else if (e.getSource().equals(removeBtn)) {
			removeRow();
		}
		else if (e.getSource().equals(findInitiativeBtn)) {
			findInitiative();
		}
	}

	private void findInitiative() {
		infoArea.clear();
		if (rows.size() > 0) {
			Initiative initiative = new Initiative();
			for (CharacterRowController row : rows) {
				int success = row.getSuccess();
				int advantage = row.getAdvantage();
				EntityType type = EntityType.valueOf(row.getType());
				initiative.addEntity(new Entity(type, success, advantage));
			}

			for (Entity e : initiative.getOrder()) {
				infoArea.appendText(e.getType() + "\n");
			}
		}
		else {
			infoArea.setText("No rows. Add some to find initiative");
		}

	}

	private void removeRow() {
		if (rows.size() > 0) {
			characterRowsBox.getChildren().remove(rows.size() - 1);
			rows.remove(rows.size() - 1);
		}
	}

	private void addRow() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("data/initiative_row.fxml"));
			Parent p = fxmlLoader.load();

			CharacterRowController row = ((CharacterRowController) fxmlLoader.getController());
			rows.add(row);
			characterRowsBox.getChildren().add(p);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

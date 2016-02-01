package com.lodenrogue.swrpg.tools.obligation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import org.json.JSONObject;

import com.lodenrogue.swrpg.Main;
import com.lodenrogue.swrpg.MathUtils;
import com.lodenrogue.swrpg.WordUtils;
import com.lodenrogue.swrpg.file.DataLoader;
import com.lodenrogue.swrpg.file.DataSaver;
import com.lodenrogue.swrpg.file.Saveable;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ObligationsController implements Initializable {
	private static ObligationsController instance;

	@FXML
	private TableView<PlayerObligation> obligationTable;
	@FXML
	private TableColumn<PlayerObligation, String> playerColumn;
	@FXML
	private TableColumn<PlayerObligation, String> characterColumn;
	@FXML
	private TableColumn<PlayerObligation, String> typeColumn;
	@FXML
	private TableColumn<PlayerObligation, Integer> amountColumn;
	@FXML
	private Button loadBtn;
	@FXML
	private Button saveBtn;
	@FXML
	private Button newBtn;
	@FXML
	private Button rollBtn;
	@FXML
	private Label chosenObligationLbl;

	private Random rand;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		rand = new Random();
		Platform.runLater(() -> initializeTable());

	}

	private void initializeTable() {
		playerColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getPlayerName()));
		characterColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getCharacterName()));
		typeColumn.setCellValueFactory((param) -> new SimpleStringProperty(WordUtils.capitalize(param.getValue().getObligation().getType().toString())));
		amountColumn.setCellValueFactory((param) -> new SimpleIntegerProperty(param.getValue().getObligation().getValue()).asObject());
	}

	@FXML
	public void onButtonPressed(ActionEvent e) {
		if (e.getSource().equals(loadBtn)) {
			load();
		}
		else if (e.getSource().equals(saveBtn)) {
			save();
		}
		else if (e.getSource().equals(newBtn)) {
			createNew();
		}
		else if (e.getSource().equals(rollBtn)) {
			roll();
		}
	}

	private void load() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose file");
		File loadFile = fileChooser.showOpenDialog(loadBtn.getScene().getWindow());

		if (loadFile != null) {

			try {
				List<PlayerObligation> playerObligations = new ArrayList<>();
				DataLoader loader = new DataLoader();

				JSONObject json = loader.load(loadFile.getAbsolutePath());
				json.keys().forEachRemaining((key) -> {
					JSONObject playerObject = json.getJSONObject(key);

					PlayerObligation player = new PlayerObligation();
					player.setPlayerName(playerObject.getString("playerName"));
					player.setCharacterName(playerObject.getString("characterName"));

					String obligationName = playerObject.getString("obligationType");
					int obligationAmount = MathUtils.parseInt(playerObject.getString("obligationAmount"), 0);

					Obligation obligation = new Obligation(ObligationType.valueOf(obligationName), obligationAmount);
					player.setObligation(obligation);

					playerObligations.add(player);
				});

				obligationTable.getItems().clear();
				playerObligations.forEach((po) -> obligationTable.getItems().add(po));

			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void save() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Data");
		File saveFile = fileChooser.showSaveDialog(saveBtn.getScene().getWindow());

		if (saveFile != null) {
			Set<Saveable> saveables = new HashSet<>();
			obligationTable.getItems().forEach((p) -> saveables.add(p));

			try {
				DataSaver dataSaver = new DataSaver(saveables);
				dataSaver.save(saveFile.getAbsolutePath());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void createNew() {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("data/obligation_new.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Create Obligation");
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void roll() {
		List<PlayerObligation> obligationList = new ArrayList<>();
		obligationTable.getItems().forEach((playerObligation) -> {
			for (int i = 0; i < playerObligation.getObligation().getValue(); i++) {
				obligationList.add(playerObligation);
			}
		});

		int roll = rand.nextInt(100);
		if (roll <= obligationList.size()) {
			PlayerObligation chosenObligation = obligationList.get(roll);
			//@formatter:off
			chosenObligationLbl.setText("Chosen Obligation: " + chosenObligation.getPlayerName() +"/" 
									  + chosenObligation.getCharacterName() + " " 
									  + chosenObligation.getObligation().getType() + " " 
									  + chosenObligation.getObligation().getValue() + " "
									  + "(Roll: " + (roll + 1) + ")");
			//@formatter:on
		}
		else {
			chosenObligationLbl.setText("Chosen Obligation: None (Roll: " + (roll + 1) + ")");
		}
	}

	public static ObligationsController getInstance() {
		return instance;
	}

	public void addRow(PlayerObligation player) {
		obligationTable.getItems().add(player);
	}

}

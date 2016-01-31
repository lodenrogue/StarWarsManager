package com.lodenrogue.swrpg.tools.obligation;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.lodenrogue.swrpg.Main;
import com.lodenrogue.swrpg.WordUtils;

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
import javafx.stage.Stage;

public class ObligationsController implements Initializable {
	private static ObligationsController instance;

	@FXML
	private TableView<Player> obligationTable;
	@FXML
	private TableColumn<Player, String> playerColumn;
	@FXML
	private TableColumn<Player, String> characterColumn;
	@FXML
	private TableColumn<Player, String> typeColumn;
	@FXML
	private TableColumn<Player, Integer> amountColumn;
	@FXML
	private Button loadBtn;
	@FXML
	private Button saveBtn;
	@FXML
	private Button newBtn;
	@FXML
	private Button rollBtn;
	@FXML
	private Label chosenPlayer;
	@FXML
	private Label chosenCharacter;
	@FXML
	private Label chosenObligation;
	@FXML
	private Label chosenAmount;

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
		// TODO
	}

	private void save() {
		// TODO
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
		// TODO
		int roll = rand.nextInt(100) + 1;
	}

	public static ObligationsController getInstance() {
		return instance;
	}

	public void addRow(Player player) {
		obligationTable.getItems().add(player);
	}

}

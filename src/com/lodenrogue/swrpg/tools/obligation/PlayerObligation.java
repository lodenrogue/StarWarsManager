package com.lodenrogue.swrpg.tools.obligation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.lodenrogue.swrpg.file.Saveable;

public class PlayerObligation implements Saveable {
	private Map<String, String> saveMap;
	private Obligation obligation;
	private String playerName;
	private String characterName;

	public PlayerObligation() {
		obligation = new Obligation(ObligationType.ADDICTION, 0);
		playerName = "";
		characterName = "";
	}

	public void setObligation(Obligation obligation) {
		this.obligation = obligation;
	}

	public Obligation getObligation() {
		return obligation;
	}

	public void setPlayerName(String name) {
		this.playerName = name;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setCharacterName(String name) {
		this.characterName = name;
	}

	public String getCharacterName() {
		return characterName;
	}

	@Override
	public Map<String, String> getKeyValuePairs() {
		saveMap = new HashMap<>();
		saveMap.put("playerName", playerName);
		saveMap.put("characterName", characterName);
		saveMap.put("obligationType", obligation.getType().toString());
		saveMap.put("obligationAmount", "" + obligation.getValue());
		return saveMap;
	}

	@Override
	public String getId() {
		return playerName + "-" + UUID.randomUUID();
	}
}

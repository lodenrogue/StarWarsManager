package com.lodenrogue.swrpg.tools.obligation;

public class Player {
	private Obligation obligation;
	private String playerName;
	private String characterName;

	public Player() {
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
}

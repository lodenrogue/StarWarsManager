package com.lodenrogue.swrpg.tools.obligation;

public class Obligation {
	private ObligationType type;
	private int value;

	public Obligation(ObligationType type, int value) {
		this.type = type;
		this.value = value;
	}

	public ObligationType getType() {
		return type;
	}

	public void setType(ObligationType type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

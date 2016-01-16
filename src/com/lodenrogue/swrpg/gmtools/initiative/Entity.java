package com.lodenrogue.swrpg.gmtools.initiative;

public class Entity {
	private EntityType type;
	private int success;
	private int advantage;

	public Entity(EntityType type) {
		this.type = type;
		success = 0;
		advantage = 0;
	}

	public Entity(EntityType type, int success, int advantage) {
		this.type = type;
		this.success = success;
		this.advantage = advantage;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getSuccess() {
		return success;
	}

	public void setAdvantage(int advantage) {
		this.advantage = advantage;
	}

	public int getAdvantage() {
		return advantage;
	}

	public EntityType getType() {
		return type;
	}

}

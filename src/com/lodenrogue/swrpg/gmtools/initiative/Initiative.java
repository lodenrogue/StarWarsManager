package com.lodenrogue.swrpg.gmtools.initiative;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Initiative {
	private List<Entity> entities;

	public Initiative() {
		entities = new ArrayList<>();
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	public void addAllEntities(Collection<? extends Entity> c) {
		entities.addAll(c);
	}

	public List<Entity> getOrder() {
		List<Entity> entityOrder = new ArrayList<>();

		for (Entity entity : entities) {
			if (entityOrder.size() == 0) {
				entityOrder.add(entity);
			}
			else {
				boolean added = false;
				for (Entity eOrder : entityOrder) {
					if (entity.getSuccess() == eOrder.getSuccess()) {
						if (entity.getAdvantage() > eOrder.getAdvantage()) {
							entityOrder.add(entityOrder.indexOf(eOrder), entity);
							added = true;
							break;
						}
						else if (entity.getAdvantage() == eOrder.getAdvantage()) {
							if (entity.getType().equals(EntityType.PC)) {
								entityOrder.add(entityOrder.indexOf(eOrder), entity);
								added = true;
								break;
							}
						}
					}
					else if (entity.getSuccess() > eOrder.getSuccess()) {
						entityOrder.add(entityOrder.indexOf(eOrder), entity);
						added = true;
						break;
					}
				}
				if (!added) {
					entityOrder.add(entity);
				}
			}
		}
		return entityOrder;
	}
}

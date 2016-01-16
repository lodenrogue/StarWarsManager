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
		List<Entity> orderedList = new ArrayList<>();

		for (Entity entity : entities) {
			if (orderedList.size() == 0) {
				orderedList.add(entity);
			}
			else {
				boolean added = false;
				for (Entity orderedEntity : orderedList) {
					if (entity.getSuccess() == orderedEntity.getSuccess()) {
						if (entity.getAdvantage() > orderedEntity.getAdvantage()) {
							orderedList.add(orderedList.indexOf(orderedEntity), entity);
							added = true;
							break;
						}
						else if (entity.getAdvantage() == orderedEntity.getAdvantage()) {
							if (entity.getType().equals(EntityType.PC)) {
								orderedList.add(orderedList.indexOf(orderedEntity), entity);
								added = true;
								break;
							}
						}
					}
					else if (entity.getSuccess() > orderedEntity.getSuccess()) {
						orderedList.add(orderedList.indexOf(orderedEntity), entity);
						added = true;
						break;
					}
				}
				if (!added) {
					orderedList.add(entity);
				}
			}
		}
		return orderedList;
	}
}

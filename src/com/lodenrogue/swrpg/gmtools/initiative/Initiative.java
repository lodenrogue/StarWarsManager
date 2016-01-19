package com.lodenrogue.swrpg.gmtools.initiative;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		Map<Entity, Float> map = new HashMap<Entity, Float>();
		for (Entity e : entities) {
			float value = e.getSuccess() + (e.getAdvantage() / 100f);
			map.put(e, value);
		}

		List<Entry<Entity, Float>> list = new ArrayList<>(map.entrySet());
		list.sort((o1, o2) -> {
			int result = o1.getValue().compareTo(o2.getValue());
			if (result == 0) {
				if (o1.getKey().getType().equals(EntityType.PC)) {
					return 1;
				}
				else if (o2.getKey().getType().equals(EntityType.PC)) {
					return -1;
				}
			}
			return result;
		});

		Collections.reverse(list);
		List<Entity> orderedList = new ArrayList<>();
		list.forEach(entry -> orderedList.add(entry.getKey()));
		return orderedList;
	}
}

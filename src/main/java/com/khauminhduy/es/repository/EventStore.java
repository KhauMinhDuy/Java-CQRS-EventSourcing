package com.khauminhduy.es.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.khauminhduy.es.event.Event;

public class EventStore {

	private Map<String, List<Event>> stores = new HashMap<>();
	
	public void addEvent(String id, Event event) {
		List<Event> listEvent = stores.get(id);
		if(listEvent == null) {
			listEvent = new ArrayList<>();
			listEvent.add(event);
			stores.put(id, listEvent);
		} else {
			listEvent.add(event);
		}
	}
	
	public List<Event> getEvents(String id) {
		return stores.get(id);
	}
	
}

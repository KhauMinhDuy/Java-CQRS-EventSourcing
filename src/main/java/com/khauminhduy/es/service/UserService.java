package com.khauminhduy.es.service;

import com.khauminhduy.es.event.Event;
import com.khauminhduy.es.event.UserCreatedEvent;
import com.khauminhduy.es.repository.EventStore;

public class UserService {

	private EventStore eventStore;
	
	public UserService(EventStore eventStore) {
		this.eventStore = eventStore;
	}
	
	public void createUser(String userId, String firstName, String lastName) {
		eventStore.addEvent(userId, new UserCreatedEvent(userId, firstName, lastName));
	}
}

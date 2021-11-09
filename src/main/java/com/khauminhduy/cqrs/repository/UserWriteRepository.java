package com.khauminhduy.cqrs.repository;

import java.util.HashMap;
import java.util.Map;

import com.khauminhduy.domain.User;

public class UserWriteRepository {

	private Map<String, User> stores = new HashMap<>();
	
	public void addUser(String userId, User user) {
		stores.put(userId, user);
	}
	
	public User getUser(String userId) {
		return stores.get(userId);
	}
}

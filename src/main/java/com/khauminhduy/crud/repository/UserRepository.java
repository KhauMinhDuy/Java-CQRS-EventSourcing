package com.khauminhduy.crud.repository;

import java.util.HashMap;
import java.util.Map;

import com.khauminhduy.domain.User;

public class UserRepository {

	private Map<String, User> stores = new HashMap<>();
	
	public void addUser(String id, User user) {
		stores.put(id, user);
	}
	
	public User getUser(String id) {
		return stores.get(id);
	}
}

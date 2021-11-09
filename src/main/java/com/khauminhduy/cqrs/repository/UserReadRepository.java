package com.khauminhduy.cqrs.repository;

import java.util.HashMap;
import java.util.Map;

import com.khauminhduy.domain.UserAddress;
import com.khauminhduy.domain.UserContact;

public class UserReadRepository {

	private Map<String, UserAddress> userAddress = new HashMap<>();
	private Map<String, UserContact> userContact = new HashMap<>();
	
	public void addUserAddress(String id, UserAddress address) {
		userAddress.put(id, address);
	}
	
	public UserAddress getUserAddress(String id) {
		return userAddress.get(id);
	}
	
	public void addUserContact(String id, UserContact contact) {
		userContact.put(id, contact);
	}
	
	public UserContact getUserContact(String id) {
		return userContact.get(id);
	}
}

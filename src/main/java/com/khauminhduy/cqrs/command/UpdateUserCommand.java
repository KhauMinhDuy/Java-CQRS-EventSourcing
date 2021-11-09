package com.khauminhduy.cqrs.command;

import java.util.HashSet;
import java.util.Set;

import com.khauminhduy.domain.Address;
import com.khauminhduy.domain.Contact;

public class UpdateUserCommand {

	private String userId;
	private Set<Contact> contacts = new HashSet<>();
	private Set<Address> addresses = new HashSet<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}

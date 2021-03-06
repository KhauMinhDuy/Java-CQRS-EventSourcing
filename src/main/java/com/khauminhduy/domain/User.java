package com.khauminhduy.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String userId;

	private String firstName;

	private String lastName;

	private Set<Contact> contacts = new HashSet<>();

	private Set<Address> addresses = new HashSet<>();

	public User() {
	}

	public User(String userId, String firstName, String lastName, Set<Contact> contacts, Set<Address> addresses) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contacts = contacts;
		this.addresses = addresses;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

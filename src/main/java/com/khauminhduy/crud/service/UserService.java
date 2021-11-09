package com.khauminhduy.crud.service;

import java.util.Set;
import java.util.stream.Collectors;

import com.khauminhduy.crud.repository.UserRepository;
import com.khauminhduy.domain.Address;
import com.khauminhduy.domain.Contact;
import com.khauminhduy.domain.User;

public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void createUser(String userId, String firstName, String lastName) {
		User user = new User();
		user.setUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userRepository.addUser(userId, user);
	}
	
	public void updateUser(String userId, Set<Contact> contacts, Set<Address> addresses) throws Exception {
		User user = userRepository.getUser(userId);
		if(user == null) throw new Exception("User Does Not exist");
		user.setContacts(contacts);
		user.setAddresses(addresses);
		userRepository.addUser(userId, user);
	}
	
	public Set<Contact> getContactByType(String userId, String contactType) throws Exception {
		User user = userRepository.getUser(userId);
		if(user == null) throw new Exception("user does not exist");
		Set<Contact> contacts = user.getContacts();
		return contacts.stream()
				.filter(contact -> contact.getType().equalsIgnoreCase(contactType))
				.collect(Collectors.toSet());
	}
	
	public Set<Address> getAddressByRegion(String userId, String state) throws Exception {
		User user = userRepository.getUser(userId);
		if(user == null) throw new Exception("user does not exist");
		Set<Address> addresses = user.getAddresses();
		return addresses.stream()
				.filter(address -> address.getState().equalsIgnoreCase(state))
				.collect(Collectors.toSet());
	}
	
}

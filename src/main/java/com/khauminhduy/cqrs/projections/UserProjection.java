package com.khauminhduy.cqrs.projections;

import java.util.Set;

import com.khauminhduy.cqrs.queries.AddressByRegionQuery;
import com.khauminhduy.cqrs.queries.ContactByTypeQuery;
import com.khauminhduy.cqrs.repository.UserReadRepository;
import com.khauminhduy.domain.Address;
import com.khauminhduy.domain.Contact;
import com.khauminhduy.domain.UserAddress;
import com.khauminhduy.domain.UserContact;

public class UserProjection {

	private UserReadRepository repository;
	
	public UserProjection(UserReadRepository repository) {
		this.repository = repository;
	}
	
	public Set<Contact> handle(ContactByTypeQuery query) throws Exception {
		UserContact userContact = repository.getUserContact(query.getUserId());
		if(userContact == null) throw new Exception("User does not exist");
		return userContact.getConntactByType().get(query.getContactType());
	}
	
	public Set<Address> handle(AddressByRegionQuery query) throws Exception {
		UserAddress userAddress = repository.getUserAddress(query.getUserId());
		if(userAddress == null) throw new Exception("user does not exist");
		return userAddress.getAddressByRegion().get(query.getState());
	}
	
}

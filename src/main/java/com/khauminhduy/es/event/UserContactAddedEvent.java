package com.khauminhduy.es.event;

import java.util.Objects;

public class UserContactAddedEvent extends Event{

	private String contactType;
	private String contactDetails;

	public UserContactAddedEvent() {
	}

	public UserContactAddedEvent(String contactType, String contactDetails) {
		this.contactType = contactType;
		this.contactDetails = contactDetails;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactDetails, contactType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserContactAddedEvent other = (UserContactAddedEvent) obj;
		return Objects.equals(contactDetails, other.contactDetails) && Objects.equals(contactType, other.contactType);
	}

}

package com.khauminhduy.es.event;

import java.util.Objects;

public class UserAddressRemovedEvent extends Event{

	private String city;
	private String state;
	private String postCode;

	public UserAddressRemovedEvent() {
	}

	public UserAddressRemovedEvent(String city, String state, String postCode) {
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, postCode, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAddressRemovedEvent other = (UserAddressRemovedEvent) obj;
		return Objects.equals(city, other.city) && Objects.equals(postCode, other.postCode)
				&& Objects.equals(state, other.state);
	}
	
}

package com.khauminhduy.domain;

import java.util.Objects;

public class Address {

	private String city;
	private String state;
	private String postcode;

	public Address() {
	}

	public Address(String city, String state, String postcode) {
		this.city = city;
		this.state = state;
		this.postcode = postcode;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, postcode, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(postcode, other.postcode)
				&& Objects.equals(state, other.state);
	}

}

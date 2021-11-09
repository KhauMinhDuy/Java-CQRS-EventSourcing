package com.khauminhduy.domain;

import java.util.Objects;

public class Contact {

	private String type;
	private String detail;

	public Contact() {

	}

	public Contact(String type, String detail) {
		this.type = type;
		this.detail = detail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(detail, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(detail, other.detail) && Objects.equals(type, other.type);
	}

}

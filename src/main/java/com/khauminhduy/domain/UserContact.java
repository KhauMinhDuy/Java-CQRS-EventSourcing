package com.khauminhduy.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserContact {

	private Map<String, Set<Contact>> conntactByType = new HashMap<>();

	public Map<String, Set<Contact>> getConntactByType() {
		return conntactByType;
	}

	public void setConntactByType(Map<String, Set<Contact>> conntactByType) {
		this.conntactByType = conntactByType;
	}

}

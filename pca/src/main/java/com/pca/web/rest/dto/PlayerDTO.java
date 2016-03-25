package com.pca.web.rest.dto;

import java.io.Serializable;

public class PlayerDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2766347359212489946L;
	
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private Long shirtNumber;
	
	public PlayerDTO () {
		
	}
	
	public PlayerDTO (long id, String firstName, String lastName, Long shirtNumber) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shirtNumber = shirtNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Long getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(Long shirtNumber) {
		this.shirtNumber = shirtNumber;
	}
	
}

package com.pca.web.rest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManagerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7611752695418669433L;

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private List <TeamDTO> teams = new ArrayList<TeamDTO>();
	
	public ManagerDTO () {
		
	}
	
	public ManagerDTO (long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public List<TeamDTO> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamDTO> teams) {
		this.teams = teams;
	}	
}

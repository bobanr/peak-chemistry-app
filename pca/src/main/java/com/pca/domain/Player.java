package com.pca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "PCA_PLAYERS")
public class Player extends DefaultModel implements Serializable{
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "NATIONALITY")
	private String nationality;
	
	@Column(name = "BODY_COLOR")
	private String bodyColor;
	
	@Column(name = "DATE_OF_BORN")
	private Date dateOfBorn;
	
	@Column(name = "PLACE_OF_BORN")
	private String placeOfBorn;
	
	@Column(name = "COUNTRY_OF_BORN")
	private String countryOfBorn;
	
	@Column(name = "SHIRT_NUMBER")
	private Long shirtNumber;
	
	@Column(name = "YEAR_IN_TEAM")
	private Long yearInTeam;
	
	@Column(name = "POSITION_IN_TEAM")
	private String positionInTeam;
		
//	@ManyToOne
//	@JoinColumn(name = "TEAM_ID")
//	private Team team;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public Date getDateOfBorn() {
		return dateOfBorn;
	}

	public void setDateOfBorn(Date dateOfBorn) {
		this.dateOfBorn = dateOfBorn;
	}

	public String getPlaceOfBorn() {
		return placeOfBorn;
	}

	public void setPlaceOfBorn(String placeOfBorn) {
		this.placeOfBorn = placeOfBorn;
	}

	public String getCountryOfBorn() {
		return countryOfBorn;
	}

	public void setCountryOfBorn(String countryOfBorn) {
		this.countryOfBorn = countryOfBorn;
	}

	public Long getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(Long shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	public Long getYearInTeam() {
		return yearInTeam;
	}

	public void setYearInTeam(Long yearInTeam) {
		this.yearInTeam = yearInTeam;
	}

	public String getPositionInTeam() {
		return positionInTeam;
	}

	public void setPositionInTeam(String positionInTeam) {
		this.positionInTeam = positionInTeam;
	}
}

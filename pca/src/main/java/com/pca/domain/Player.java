package com.pca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PCA_PLAYERS")
public class Player extends DefaultModel implements Serializable {

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
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
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player() {
		super();
	}

	public Player(String firstName, String lastName, String nationality,
			String bodyColor, Date dateOfBorn, String placeOfBorn,
			String countryOfBorn, Long shirtNumber, Long yearInTeam,
			String positionInTeam, Team team) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.bodyColor = bodyColor;
		this.dateOfBorn = dateOfBorn;
		this.placeOfBorn = placeOfBorn;
		this.countryOfBorn = countryOfBorn;
		this.shirtNumber = shirtNumber;
		this.yearInTeam = yearInTeam;
		this.positionInTeam = positionInTeam;
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName
				+ ", nationality=" + nationality + ", bodyColor=" + bodyColor
				+ ", dateOfBorn=" + dateOfBorn + ", placeOfBorn=" + placeOfBorn
				+ ", countryOfBorn=" + countryOfBorn + ", shirtNumber="
				+ shirtNumber + ", yearInTeam=" + yearInTeam
				+ ", positionInTeam=" + positionInTeam 
				+ ", team=" + team + "]";
	}
	
	
}

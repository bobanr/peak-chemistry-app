package com.pca.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PCA_TEAMS")
public class Team extends DefaultModel implements Serializable{
	
	@NotNull
	@Column(name = "TEAM_NAME")
	private String teamName;
	
	@NotNull
	@Column(name= "HOME_STADIUM")
	private String homeStadium;
    
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHomeStadium() {
		return homeStadium;
	}

	public void setHomeStadium(String homeStadium) {
		this.homeStadium = homeStadium;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team() {

	}

	public Team(String teamName, String homeStadium, User user) {
		super();
		this.teamName = teamName;
		this.homeStadium = homeStadium;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", homeStadium=" + homeStadium
				+ ", user=" + user + "]";
	}
	
	
}

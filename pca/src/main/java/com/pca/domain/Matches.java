package com.pca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PCA_MATCHES")
public class Matches extends DefaultModel implements Serializable {
	
	@NotNull 
	@Column(name = "OPPONENT_NAME")
	private String opponentName;
	
	@NotNull
	@Column(name = "STADIUM_NAME")
	private String stadiumName;
	
	@NotNull
	@Column(name = "FORMATION")
	private String formation;
	
	@NotNull
	@Column(name = "MATCH_TIME")
	private Date matchTime;
		
	@NotNull
	@Column (name="GOALS")
	private int goals;
	
	@NotNull
	@Column (name="OPPONENT_GOALS")
	private int opponentGoals;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	
	
	public Matches() {

	}



	public Matches(String opponentName, String stadiumName, String formation, Date matchTime, Team team, int goals,
			int opponentGoals) {
		super();
		this.opponentName = opponentName;
		this.stadiumName = stadiumName;
		this.formation = formation;
		this.matchTime = matchTime;
		this.team = team;
		this.goals = goals;
		this.opponentGoals = opponentGoals;
	}



	public String getOpponentName() {
		return opponentName;
	}



	public void setOpponentName(String opponentName) {
		this.opponentName = opponentName;
	}



	public String getStadiumName() {
		return stadiumName;
	}



	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}



	public String getFormation() {
		return formation;
	}



	public void setFormation(String formation) {
		this.formation = formation;
	}



	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getOpponentGoals() {
		return opponentGoals;
	}

	public void setOpponentGoals(int opponentGoals) {
		this.opponentGoals = opponentGoals;
	}


	@Override
	public String toString() {
		return "Matches [opponentName=" + opponentName + ", stadiumName="
				+ stadiumName + ", formationType=" + formation
				+ ", matchTime=" + matchTime + ", team=" + team
				+ ", goals=" + goals + ", opponentGoals="+opponentGoals+"]";
	}
	

}

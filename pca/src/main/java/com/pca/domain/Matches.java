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
	@Column(name = "FORMATION_TYPE")
	private Long formationType;
	
	@NotNull
	@Column(name = "START_TIME")
	private Date startTime;
	
	@NotNull
	@Column(name = "END_TIME")
	private Date endTime;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	
	
	public Matches() {

	}



	public Matches(String opponentName, String stadiumName, Long formationType,
			Date startTime, Date endTime, Team team) {
		super();
		this.opponentName = opponentName;
		this.stadiumName = stadiumName;
		this.formationType = formationType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.team = team;
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



	public Long getFormationType() {
		return formationType;
	}



	public void setFormationType(Long formationType) {
		this.formationType = formationType;
	}



	public Date getStartTime() {
		return startTime;
	}



	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Date getEndTime() {
		return endTime;
	}



	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}



	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
	}



	@Override
	public String toString() {
		return "Matches [opponentName=" + opponentName + ", stadiumName="
				+ stadiumName + ", formationType=" + formationType
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", team=" + team + "]";
	}
	

}

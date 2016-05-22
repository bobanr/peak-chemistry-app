package com.pca.web.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MatchDTO implements Serializable {
	
	/**
	 * Added by Eclipse
	 */
	private static final long serialVersionUID = 5359966899919278140L;
	
	private Long userId;

	private String opponentName;
	
	private String stadiumName;
	
	private String formation;
	
	private Long teamId;
	
	private Date matchTime;
	
	private int goals;
	
	private int opponentGoals;
	
	private List <PassesDTO> passes;
	
	private List <PlayerStatisticsDTO> statistics;
	
	public MatchDTO () {
		
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
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

	public List<PassesDTO> getPasses() {
		return passes;
	}

	public void setPasses(List<PassesDTO> passes) {
		this.passes = passes;
	}

	public List<PlayerStatisticsDTO> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<PlayerStatisticsDTO> statistics) {
		this.statistics = statistics;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	
	@Override
	public String toString() {
		
		return "MatchDTO [userId=" + userId + ", teamId=" + teamId
				+ ", stadiumName="+ stadiumName + ", formationType=" + formation
				+ ", matchTime=" + matchTime + ", goals=" + goals
				+ ", opponentGoals="+opponentGoals+ ", opponentName=" +  opponentName+"]";
	}
}

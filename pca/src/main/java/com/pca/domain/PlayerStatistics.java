package com.pca.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PCA_PLAYER_STATISTICS")
public class PlayerStatistics extends DefaultModel implements Serializable{
	
	@Column(name = "GOAL")
	private Long goal;
	
	@Column(name = "ASSISTS")
	private Long assists;
	
	@Column(name = "OFFSIDE")
	private Long offside;
	
	@Column(name = "YELOW_CARD")
	private Long yelowCard;
	
	@Column(name = "RED_CARD")
	private Long redCard;
	
	@Column(name = "FOUL_OF_PLAYER")
	private Long foulOfPlayer;
	
	@Column(name = "FOUL")
	private Long foul;
	
	@Column(name = "ERROR")
	private Long error;
	
	@ManyToOne
	@JoinColumn(name = "MATCH_ID")
	private Matches matches;

	public Long getGoal() {
		return goal;
	}

	public void setGoal(Long goal) {
		this.goal = goal;
	}

	public Long getAssists() {
		return assists;
	}

	public void setAssists(Long assists) {
		this.assists = assists;
	}

	public Long getOffside() {
		return offside;
	}

	public void setOffside(Long offside) {
		this.offside = offside;
	}

	public Long getYelowCard() {
		return yelowCard;
	}

	public void setYelowCard(Long yelowCard) {
		this.yelowCard = yelowCard;
	}

	public Long getRedCard() {
		return redCard;
	}

	public void setRedCard(Long redCard) {
		this.redCard = redCard;
	}

	public Long getFoulOfPlayer() {
		return foulOfPlayer;
	}

	public void setFoulOfPlayer(Long foulOfPlayer) {
		this.foulOfPlayer = foulOfPlayer;
	}

	public Long getFoul() {
		return foul;
	}

	public void setFoul(Long foul) {
		this.foul = foul;
	}

	public Long getError() {
		return error;
	}

	public void setError(Long error) {
		this.error = error;
	}

	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}

	public PlayerStatistics() {
		

	}

	public PlayerStatistics(Long goal, Long assists, Long offside,
			Long yelowCard, Long redCard, Long foulOfPlayer, Long foul,
			Long error, Matches matches) {
		super();
		this.goal = goal;
		this.assists = assists;
		this.offside = offside;
		this.yelowCard = yelowCard;
		this.redCard = redCard;
		this.foulOfPlayer = foulOfPlayer;
		this.foul = foul;
		this.error = error;
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "PlayerStatistics [goal=" + goal + ", assists=" + assists
				+ ", offside=" + offside + ", yelowCard=" + yelowCard
				+ ", redCard=" + redCard + ", foulOfPlayer=" + foulOfPlayer
				+ ", foul=" + foul + ", error=" + error + ", matches="
				+ matches + "]";
	}

	
	
}

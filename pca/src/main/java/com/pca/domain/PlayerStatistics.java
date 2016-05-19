package com.pca.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "PCA_PLAYER_STATISTICS")
public class PlayerStatistics extends DefaultModel implements Serializable{

	//Refer to enum statistic type
	@NotNull
	@Column (name="STATISTIC_TYPE")
	private Integer statisticType;
	
	@NotNull
	@Column (name="MINUTE")
	private int minute;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PLAYER_ID")
	private Player player;
	
	//It will be used for substitutions
	@ManyToOne
	@JoinColumn(name = "WITH_PLAYER_ID")
	private Player withPlayer;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "MATCH_ID")
	private Matches match;
	

	public PlayerStatistics() {
		

	}

	public PlayerStatistics(Integer statisticType, int minute, Player player, Player withPlayer, Matches match) {
		
		super();
		this.statisticType = statisticType;
		this.minute = minute;
		this.player = player;
		this.withPlayer = withPlayer;
		this.match = match;
	}
	
	

	public Integer getStatisticType() {
		return statisticType;
	}

	public void setStatisticType(Integer statisticType) {
		this.statisticType = statisticType;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getWithPlayer() {
		return withPlayer;
	}

	public void setWithPlayer(Player withPlayer) {
		this.withPlayer = withPlayer;
	}

	public Matches getMatch() {
		return match;
	}

	public void setMatch(Matches match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "PlayerStatistics [statisticType=" + statisticType + ", minute=" + minute
				+ ", player=" + player + ", withPlayer=" + withPlayer
				+ ", match="+ match + "]";
	}

	
	
}

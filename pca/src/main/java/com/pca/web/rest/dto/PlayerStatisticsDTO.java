package com.pca.web.rest.dto;

import java.io.Serializable;

public class PlayerStatisticsDTO implements Serializable {
	
	/**
	 * Added by Eclipse
	 */
	private static final long serialVersionUID = 2613707621664636502L;
	
	private int statisticType;
	
	private Long playerId;

	private Long withPlayerId;
		   
	private int minute;
	
	public PlayerStatisticsDTO () {
		
	}

	public int getStatisticType() {
		return statisticType;
	}

	public void setStatisticType(int statisticType) {
		this.statisticType = statisticType;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getWithPlayerId() {
		return withPlayerId;
	}

	public void setWithPlayerId(Long withPlayerId) {
		this.withPlayerId = withPlayerId;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
}

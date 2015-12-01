package com.pca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PCA_STATISTICS")
public class Statistics extends DefaultModel implements Serializable{

	@Column(name = "STAT_TIME")
	private Date statTime;
	
	@Column(name = "STAT_TYPE")
	private Long statType;
	
	@ManyToOne
	@JoinColumn(name = "MATCH_ID")
	private Matches matches;

	public Date getStatTime() {
		return statTime;
	}

	public void setStatTime(Date statTime) {
		this.statTime = statTime;
	}

	public Long getStatType() {
		return statType;
	}

	public void setStatType(Long statType) {
		this.statType = statType;
	}

	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}

	public Statistics() {
		
	}

	public Statistics(Date statTime, Long statType, Matches matches) {
		super();
		this.statTime = statTime;
		this.statType = statType;
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Statistics [statTime=" + statTime + ", statType=" + statType
				+ ", matches=" + matches + "]";
	}
	
	
	
}

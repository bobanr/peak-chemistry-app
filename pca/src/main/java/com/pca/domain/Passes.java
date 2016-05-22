package com.pca.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PCA_PASSES")
public class Passes extends DefaultModel implements Serializable {

	@Column(name = "FROM_NUMBER")
	private Integer fromNumber;

	@Column(name = "TO_NUMBER")
	private Integer toNumber;

	@Column(name = "PASS_TIME")
	private Integer passTime;

	@ManyToOne
	@JoinColumn(name = "MATCH_ID")
	private Matches matches;

	public Passes() {

	}

	public Passes(Integer fromNumber, Integer toNumber, Integer passTime, Matches matches) {
		super();
		this.fromNumber = fromNumber;
		this.toNumber = toNumber;
		this.passTime = passTime;
		this.matches = matches;
	}

	public Integer getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(Integer fromNumber) {
		this.fromNumber = fromNumber;
	}

	public Integer getToNumber() {
		return toNumber;
	}

	public void setToNumber(Integer toNumber) {
		this.toNumber = toNumber;
	}

	public int getPassTime() {
		return passTime;
	}

	public void setPassTime(int passTime) {
		this.passTime = passTime;
	}

	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Passes [fromNumber=" + fromNumber + ", toNumber=" + toNumber + ", passTime=" + passTime + ", matches="
				+ matches + "]";
	}

}

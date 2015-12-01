package com.pca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PCA_PASSES")
public class Passes extends DefaultModel implements Serializable{

  @Column(name = "FROM_NUMBER")	
  private Long fromNumber;
  
  @Column(name = "TO_NUMBER")
  private Long toNumber;
  
  @Column(name = "PASS_TIME")
  private Date passTime;
  
  @ManyToOne
  @JoinColumn(name = "MATCH_ID")
  private Matches matches;

  
  
public Passes() {

}



public Passes(Long fromNumber, Long toNumber, Date passTime, Matches matches) {
	super();
	this.fromNumber = fromNumber;
	this.toNumber = toNumber;
	this.passTime = passTime;
	this.matches = matches;
}



public Long getFromNumber() {
	return fromNumber;
}

public void setFromNumber(Long fromNumber) {
	this.fromNumber = fromNumber;
}

public Long getToNumber() {
	return toNumber;
}

public void setToNumber(Long toNumber) {
	this.toNumber = toNumber;
}

public Date getPassTime() {
	return passTime;
}

public void setPassTime(Date passTime) {
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
	return "Passes [fromNumber=" + fromNumber + ", toNumber=" + toNumber
			+ ", passTime=" + passTime + ", matches=" + matches + "]";
}
  
  
}

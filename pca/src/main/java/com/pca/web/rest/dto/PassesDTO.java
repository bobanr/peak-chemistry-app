package com.pca.web.rest.dto;

import java.io.Serializable;

public class PassesDTO implements Serializable {
	
	/**
	 * Added by Eclipse
	 */
	private static final long serialVersionUID = 5343216916481947588L;

	private int fromNumber;

	private int toNumber;

	private int passTime;
	
	public PassesDTO () {
		
	}

	public int getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(int fromNumber) {
		this.fromNumber = fromNumber;
	}

	public int getToNumber() {
		return toNumber;
	}

	public void setToNumber(int toNumber) {
		this.toNumber = toNumber;
	}

	public int getPassTime() {
		return passTime;
	}

	public void setPassTime(int passTime) {
		this.passTime = passTime;
	}
}

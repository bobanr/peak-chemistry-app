package com.pca.enums;

public enum StatisticType {

	Goal(1), FirstYellowCard(2), SecondYellowCard(3), RedCard(4), Substitution(5);

	private final int value;

	private StatisticType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

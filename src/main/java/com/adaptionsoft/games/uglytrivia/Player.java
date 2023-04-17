package com.adaptionsoft.games.uglytrivia;

public class Player {
	/**
	 *
	 */
	private static final int NUMBER_OF_PLACES = 12;
	private final String name;
	private int place = 0;
	private int purse = 0;
	private boolean inPenaltyBox = false;


	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getPlace() {
		return place;
	}
	
	public int getPurse() {
		return purse;
	}
	
	public boolean isInPenaltyBox() {
		return inPenaltyBox;
	}
	
	public void setInPenaltyBox(boolean inPenaltyBox) {
		this.inPenaltyBox = inPenaltyBox;
	}

	public void movePlayer(int roll) {
		place += roll;
		if (place >= NUMBER_OF_PLACES) {
			place -= NUMBER_OF_PLACES;
		}	
		System.out.println(name + "'s new location is " + place);
	}

	public void addGoldCoins() {
		purse++;
		System.out.println(name + " now has " + purse + " Gold Coins.");
	}
}
package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final int MAX_NUMBER_OF_COINS = 6;
	private static final int MIN_NUMBER_OF_PLAYERS = 2;
	private static final int MAX_NUMBER_OF_PLAYERS = 6;
	private final List<Player> players = new ArrayList<Player>();
	private final Questions questions = new Questions();

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

	public boolean isPlayable() {
		return (players.size() >= MIN_NUMBER_OF_PLAYERS && players.size() <= MAX_NUMBER_OF_PLAYERS);
	}

	public void addPlayerNames(String playerName) {
		if(players.size() < MAX_NUMBER_OF_PLAYERS) {
			players.add(new Player(playerName));    
			System.out.println(playerName + " was added");
			System.out.println("They are player number " + players.size());
		}
	}

	public void roll(int roll) {
		if(isPlayable()){
			System.out.println(currentPlayer().getName() + " is the current player");
			System.out.println("They have rolled a " + roll);
	
			if (currentPlayer().isInPenaltyBox()) {
				if (roll % 2 != 0) {
					isGettingOutOfPenaltyBox = true;
	
					System.out.println(currentPlayer().getName() + " is getting out of the penalty box");
					currentPlayer().movePlayer(roll);
					askQuestion();
				} 
				else {
					System.out.println(currentPlayer().getName() + " is not getting out of the penalty box");
					isGettingOutOfPenaltyBox = false;
				}
			} 
			else {
				currentPlayer().movePlayer(roll);
				askQuestion();
			}
		}
	}

	public void askQuestion() {
		System.out.println("The category is " + questions.currentCategory(currentPlayer().getPlace()));
		System.out.println(questions.getNextQuestion(currentPlayer().getPlace()));
	}

	public Player currentPlayer() {
		return players.get(currentPlayer);
	}

	public boolean wasCorrectlyAnswered() {
		boolean winner = false;
		if (currentPlayer().isInPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				System.out.println(currentPlayer().getName()+ " exit the penalty box");
				currentPlayer().setInPenaltyBox(false);
				currentPlayer().addGoldCoins();
				
				winner = didPlayerWin();
			}
			nextPlayer();
			return winner;
		} else {
			System.out.println("Answer was correct!!!!");
			currentPlayer().addGoldCoins();
			
			winner = didPlayerWin();
			nextPlayer();
			return winner;
		}
	}

	public void nextPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()){
			currentPlayer = 0;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayer().getName()+ " was sent to the penalty box");
		currentPlayer().setInPenaltyBox(true);
		nextPlayer();
		return true;
	}

	public boolean didPlayerWin() {
		return (currentPlayer().getPurse() == MAX_NUMBER_OF_COINS);
	}
}

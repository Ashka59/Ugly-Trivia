
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean winner;

	public static void main(String[] args) {
		Game aGame = new Game();
		
		aGame.addPlayerNames("Chet");
		aGame.addPlayerNames("Pat");
		aGame.addPlayerNames("Sue");
		
		Random rand = new Random();
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				winner = !(aGame.wrongAnswer());
			} else {
				winner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (!winner);
		
	}
}

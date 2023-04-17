package com.adaptionsoft.games.trivia;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameTest {
     
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }


	@Test
	void testIsPlayable() {
		game.addPlayerNames("Chet");
		assertFalse(game.isPlayable());	
		game.addPlayerNames("Pat");
		assertTrue(game.isPlayable());	
		game.addPlayerNames("Sue");
		game.addPlayerNames("Pierre");
		game.addPlayerNames("Paul");
		game.addPlayerNames("Jacques");
		assertTrue(game.isPlayable());	
		game.addPlayerNames("Simon");
		assertTrue(game.isPlayable());	
	}

	@Test
	void testDidPlayerWin() {
		game.addPlayerNames("Chet");
		game.addPlayerNames("Pat");

		game.currentPlayer().addGoldCoins();

		assertFalse(game.didPlayerWin());

		for (int i = 0; i < 5; i++) {
			game.currentPlayer().addGoldCoins();
		}
		
		assertTrue(game.didPlayerWin());
	}
}

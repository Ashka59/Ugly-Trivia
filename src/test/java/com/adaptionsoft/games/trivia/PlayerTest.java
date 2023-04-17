package com.adaptionsoft.games.trivia;


import org.junit.jupiter.api.Test;

import com.adaptionsoft.games.uglytrivia.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;


public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("Stéphane");
    }

    @Test
    void testMovePlayer() {
		assertEquals(0, player.getPlace());
		player.movePlayer(6);
		assertEquals(6, player.getPlace());
		player.movePlayer(6);
		assertEquals(0, player.getPlace());
    }
    @Test
    void testAddGoldCoins() {
        player.addGoldCoins();
		assertEquals(1, player.getPurse());
    }

}

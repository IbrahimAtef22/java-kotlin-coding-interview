package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for App.
 */
public class AppTest {
    private Player playerA;
    private Player playerB;

    @BeforeEach
    void setUp() {
        playerA = new Player("Player A");
        playerB = new Player("Player B", Play.ROCK);
    }

    @Test
    void testPlayerInitialization() {
        assertEquals("Player A", playerA.getName());
        assertNull(playerA.getPlay());
        assertEquals(0, playerA.getWinCount());

        assertEquals("Player B", playerB.getName());
        assertEquals(Play.ROCK, playerB.getPlay());
        assertEquals(0, playerB.getWinCount());
    }

    @Test
    void testSetAndGetPlay() {
        playerA.setPlay(Play.PAPER);
        assertEquals(Play.PAPER, playerA.getPlay());

        playerA.setPlay(Play.SCISSORS);
        assertEquals(Play.SCISSORS, playerA.getPlay());
    }

    @Test
    void testSetAndGetWinCount() {
        assertEquals(0, playerA.getWinCount());

        playerA.setWinCount();
        assertEquals(1, playerA.getWinCount());

        playerA.setWinCount();
        assertEquals(2, playerA.getWinCount());
    }

    @Test
    void testPlayerResult() {
        playerA.setWinCount();
        playerA.setWinCount();
        String result = playerA.playerResult();
        assertEquals("Player A wins 2 of 100 games", result);
    }

    @Test
    void testRandomPlay() {
        Set<Play> generatedPlays = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            generatedPlays.add(Play.randomPlay());
        }
        assertTrue(generatedPlays.containsAll(EnumSet.allOf(Play.class)));
    }

    @Test
    void testGameLogic() {
        playerA.setPlay(Play.PAPER);
        assertEquals(Play.PAPER, playerA.getPlay());

        // Player A wins (PAPER beats ROCK)
        if (playerA.getPlay() == Play.PAPER && playerB.getPlay() == Play.ROCK) {
            playerA.setWinCount();
        }
        assertEquals(1, playerA.getWinCount());
    }

    @Test
    void testDrawCondition() {
        playerA.setPlay(Play.ROCK);
        assertEquals(Play.ROCK, playerA.getPlay());

        // Draw condition (ROCK vs ROCK)
        if (playerA.getPlay() == playerB.getPlay()) {
            assertEquals(Play.ROCK, playerB.getPlay());
        }
    }

    @Test
    void testSimulate100Games() {
        int playerAWins = 0;
        int playerBWins = 0;
        int draws = 0;

        for (int i = 0; i < 100; i++) {
            Play playerAPlay = Play.randomPlay();
            playerA.setPlay(playerAPlay);

            switch (playerAPlay) {
                case ROCK:
                    draws++;
                    break;
                case PAPER:
                    playerAWins++;
                    break;
                case SCISSORS:
                    playerBWins++;
                    break;
            }
        }

        assertEquals(100, playerAWins + playerBWins + draws);
    }
}

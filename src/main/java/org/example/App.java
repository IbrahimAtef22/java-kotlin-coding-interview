package org.example;

/**
 * Rock Paper Scissors game
 * The "Rock, Paper, Scissors" game is a simple game played between two people
 * where each player selects one of three possible moves: rock, paper, or scissors.
 * The chosen moves will then be compared to see who wins, according to the following rules:
 * - Rock beats scissors
 * - Scissors beats paper
 * - Paper beats rock
 * One player should always play randomly, while the other player should always play rock.
 */
public class App {
    public static void main(String[] args) {
        Player playerA = new Player("Player A");

        // player B is always playing ROCK
        Player playerB = new Player("Player B", Play.ROCK);

        int gameCount = 1;
        int drawCount = 0;

        // Play 100 games
        while (gameCount <= 100) {
            // Player A plays randomly
            playerA.setPlay(Play.randomPlay());

            switch (playerA.getPlay()) {
                case ROCK:       // choose the same play as player B "Draw"
                    drawCount++;
                    break;
                case PAPER:     // Paper beats rock
                    playerA.setWinCount();
                    break;
                case SCISSORS:  // Rock beats scissors
                    playerB.setWinCount();
                    break;
            }
            gameCount++;
        }

        System.out.println(playerA.playerResult());
        System.out.println(playerB.playerResult());
        System.out.println("Draws: " + drawCount + " of 100 games");


    }
}

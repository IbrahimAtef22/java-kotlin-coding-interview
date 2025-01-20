package org.example;

import java.util.Random;

public enum Play {
    ROCK, PAPER, SCISSORS;

    public static Play randomPlay() {
        Random random = new Random();
        Play[] plays = Play.values();
        return plays[random.nextInt(plays.length)];
    }
}

package org.example;

public class Player {

    private String name;
    private Play play;
    private int winCount;


    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Play play) {
        this.name = name;
        this.play = play;
    }

    public String getName() {
        return name;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount() {
        this.winCount++;
    }

    public String playerResult() {
        return name + " wins " + getWinCount() + " of 100 games";
    }

}

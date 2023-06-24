package com.example.memoryenhancer;

import java.util.ArrayList;

// Class that stores the history of all games played
public class GameStats {
    // An array that stores information of each round that a player has played
    private ArrayList<RoundStats> playerStats;

    // Stores how many rounds have been played so far
    private int roundsPlayed;

    // Stores the overall response time of the player in milliseconds
    private int roundsWon;

    public GameStats() {
        playerStats = new ArrayList<RoundStats>();
        roundsPlayed = getRoundsPlayed();
        roundsWon = getRoundsWon();
    }

    public ArrayList<RoundStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(ArrayList<RoundStats> playerStats) {
        this.playerStats = playerStats;
    }

    public int getRoundsWon() {
        roundsWon = 0;

        for (int x = 0; x < playerStats.size(); ++x) {
            if (playerStats.get(x).getRoundWon())
                ++roundsWon;
        }

        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public int getRoundsPlayed() {
        return playerStats.size();
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }
}

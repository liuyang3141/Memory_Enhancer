package com.example.memoryenhancer;

import java.util.Date;

// Class that stores information of each round that has been played
public class RoundStats {
    // Stores the date/time information of when the round was played
    private Date roundDate;

    // Stores the response time of the round
    private int interval;

    // Stores if the round was won
    private boolean roundWon;

    public RoundStats(Date roundDate, int interval, boolean roundWon) {
        this.roundDate = roundDate;
        this.interval = interval;
        this.roundWon = roundWon;
    }

    public Date getRoundDate() {
        return roundDate;
    }

    public void setRoundDate(Date roundDate) {
        this.roundDate = roundDate;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean getRoundWon() {
        return roundWon;
    }

    public void setRoundWon(boolean roundWon) {
        this.roundWon = roundWon;
    }
}

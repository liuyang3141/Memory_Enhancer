package com.example.memoryenhancer;

import android.content.Context;
import java.util.ArrayList;

// This class stores game information
public class MemoryEnhancer {
    // Stores the number of tiles that must be identified each round.
    private int numOfTiles;

    // Stores the amount of time all tiles are shown in milliseconds.
    private int interval;

    // Stores the history of game stats
    private GameStats gameStats;

    // Stores the possible colors of the tiles
    private ArrayList<Integer> colorsArray;

    // Stores the colors of the target tiles
    private ArrayList<Integer> targetTilesColors;

    // Store color of each tile on the board
    private ArrayList<Integer> tileColors;

    // Store locations of where the target tiles will be located
    private ArrayList<Integer> targetTiles;


    // Stores number of times a guess was made
    private int guesses;

    // Stores the button numbers guessed
    private ArrayList<Integer> buttonsGuessed;

    public MemoryEnhancer(Context context) {
        numOfTiles = 2;
        interval = 3000;
        gameStats = new GameStats();
        guesses = 0;
        colorsArray = new ArrayList<Integer>();
        targetTilesColors = new ArrayList<Integer>();
        buttonsGuessed = new ArrayList<Integer>();
        targetTiles = new ArrayList<Integer>();
        tileColors = new ArrayList<Integer>();

        // Fill colors with the colors listed in colors.xml in values folder
        int colors[] = context.getResources().getIntArray(R.array.colors_array);

        for (int x = 0; x < colors.length - 1; ++x) {
            colorsArray.add(colors[x]);
        }

        // Add default color of target tile to the targetTilesColors array
        targetTilesColors.add(colors[0]);
    }
    public MemoryEnhancer(int numOfTiles, int interval, ArrayList<Integer> colorsArray, ArrayList<Integer> targetTilesColors, GameStats gameStats) {
        this.numOfTiles = numOfTiles;
        this.interval = interval;
        this.gameStats = gameStats;
        this.colorsArray = new ArrayList<Integer>();
        this.targetTilesColors = new ArrayList<Integer>();
        this.guesses = 0;
        this.buttonsGuessed = new ArrayList<Integer>();
        this.colorsArray = colorsArray;
        this.targetTilesColors = targetTilesColors;

        targetTiles = new ArrayList<Integer>();
        tileColors = new ArrayList<Integer>();
    }

    public void incrementGuesses() {
        this.guesses++;
    }

    public void clearGuesses() {
        this.guesses = 0;
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public void clearButtonsGuessed() {
        this.buttonsGuessed.clear();
    }

    public ArrayList<Integer> getButtonsGuessed() {
        return buttonsGuessed;
    }

    public void setButtonsGuessed(ArrayList<Integer> buttonsGuessed) {
        this.buttonsGuessed = buttonsGuessed;
    }

    public void clearTileColors() {
        this.tileColors.clear();
    }
    public ArrayList<Integer> getTileColors() {
        return tileColors;
    }

    public void setTileColors(ArrayList<Integer> tileColors) {
        this.tileColors = tileColors;
    }

    public void clearTargetTiles() {
        this.targetTiles.clear();
    }

    public ArrayList<Integer> getTargetTiles() {
        return targetTiles;
    }

    public void setTargetTiles(ArrayList<Integer> targetTiles) {
        this.targetTiles = targetTiles;
    }

    public ArrayList<Integer> getColorsArray() {
        return colorsArray;
    }

    public void setColorsArray(ArrayList<Integer> colorsArray) {
        this.colorsArray = colorsArray;
    }

    public ArrayList<Integer> getTargetTilesColors() {
        return targetTilesColors;
    }

    public void setTargetTilesColors(ArrayList<Integer> targetTilesColors) {
        this.targetTilesColors = targetTilesColors;
    }
    public int getNumOfTiles() {
        return numOfTiles;
    }

    public void setNumOfTiles(int numOfTiles) {
        this.numOfTiles = numOfTiles;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }
}

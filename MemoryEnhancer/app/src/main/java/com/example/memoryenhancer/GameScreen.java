package com.example.memoryenhancer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    // For generating random integers. Integers could represent a random index to use with the
    // colorsArray, targetTiles, and tileColors ArrayLists in the MemoryEnhancer class.
    private Random rand;

    // To schedule the running of a function based on time elapsed.
    private Timer timer;

    // If tis is true, then buttons touched will register.
    private boolean canTouch;

    // If this is true, then user won the current round.
    private boolean wonRound;

    // If this is true, then user can show the answer board.
    private boolean canShow;
    
    // Track current round stats
    private RoundStats currentRound;

    // For showing the value to # of Guesses Left: in the UI.
    private TextView num_of_guesses_left_answer;

    // For showing the three target tile colors in GameScreen activity
    protected Button targetTileColor1, targetTileColor2, targetTileColor3;

    // For showing the value of Round Status: in the UI.
    private TextView round_status_answer;

    // For storing the value of # of Guesses Left: in the UI.
    private int num_of_guesses_left_value;

    // For storing the value of Round Status: in the UI.
    private String round_status_value;

    // For Won/Lose text animation
    Animation zoomIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Call this activity's function to use ActionBar utility methods
        ActionBar actionBar= getSupportActionBar();

        // Set title in the ActionBar
        if (actionBar != null) {
            actionBar.setTitle("Game Screen");
        }

        // Initialize variables
        init();
    }

    // Inflates the options menu when the user opens the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_game, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // Launch activity when user clicks on menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.main_menu:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.settings:
                intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
            case R.id.stats:
                intent = new Intent(this, Stats.class);
                startActivity(intent);
                break;
            case R.id.help:
                intent = new Intent(this, GameHelp.class);
                startActivity(intent);
                break;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    // Initialize variables during onCreate()
    public void init() {
        // Initialize random number generator
        rand = new Random();

        // Initialize timer for job scheduler
        timer = new Timer();

        // Initialize animation
        zoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);

        // Initializing target tile color buttons in Settings
        targetTileColor1 = (Button) findViewById(R.id.btn_target_tile_color1);
        targetTileColor2 = (Button) findViewById(R.id.btn_target_tile_color2);
        targetTileColor3 = (Button) findViewById(R.id.btn_target_tile_color3);

        updateTargetTileColor();
    }

    public void updateTargetTileColor() {
        System.out.println("updateTargetTileColor() ran.");
        System.out.println("Number of target tile colors: " + MainActivity.game.getTargetTilesColors().size());
        for (int x = 0; x < MainActivity.game.getTargetTilesColors().size(); ++x) {
            if (x == 0)
                targetTileColor1.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(x));
            if (x == 1)
                targetTileColor2.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(x));
            if (x == 2)
                targetTileColor3.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(x));
        }

        if (MainActivity.game.getTargetTilesColors().size() == 1) {
            targetTileColor2.setVisibility(View.GONE);
            targetTileColor3.setVisibility(View.GONE);
        }
        else if (MainActivity.game.getTargetTilesColors().size() == 2) {
            targetTileColor2.setVisibility(View.VISIBLE);
            targetTileColor3.setVisibility(View.GONE);
        }
        else {
            targetTileColor2.setVisibility(View.VISIBLE);
            targetTileColor3.setVisibility(View.VISIBLE);
        }
    }
    public void setBtnColor(View view) {
        Button button;
        button = (Button) findViewById(view.getId());
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
    }

    // Listen for clicks
    public void onClick(View view) {
        if (canTouch) {
            // Each time a button is clicked for this switch, tileClick is ran and the tile clicked
            // will turn black to show which buttons have been clicked.
            switch (view.getId()) {
                case R.id.btn_0:
                    tileClick(0);
                    setBtnColor(view);
                    break;
                case R.id.btn_1:
                    tileClick(1);
                    setBtnColor(view);
                    break;
                case R.id.btn_2:
                    tileClick(2);
                    setBtnColor(view);
                    break;
                case R.id.btn_3:
                    tileClick(3);
                    setBtnColor(view);
                    break;
                case R.id.btn_4:
                    tileClick(4);
                    setBtnColor(view);
                    break;
                case R.id.btn_5:
                    tileClick(5);
                    setBtnColor(view);
                    break;
                case R.id.btn_6:
                    tileClick(6);
                    setBtnColor(view);
                    break;
                case R.id.btn_7:
                    tileClick(7);
                    setBtnColor(view);
                    break;
                case R.id.btn_8:
                    tileClick(8);
                    setBtnColor(view);
                    break;
                case R.id.btn_9:
                    tileClick(9);
                    setBtnColor(view);
                    break;
                case R.id.btn_10:
                    tileClick(10);
                    setBtnColor(view);
                    break;
                case R.id.btn_11:
                    tileClick(11);
                    setBtnColor(view);
                    break;
                case R.id.btn_12:
                    tileClick(12);
                    setBtnColor(view);
                    break;
                case R.id.btn_13:
                    tileClick(13);
                    setBtnColor(view);
                    break;
                case R.id.btn_14:
                    tileClick(14);
                    setBtnColor(view);
                    break;
                case R.id.btn_15:
                    tileClick(15);
                    setBtnColor(view);
                    break;
                case R.id.btn_16:
                    tileClick(16);
                    setBtnColor(view);
                    break;
                case R.id.btn_17:
                    tileClick(17);
                    setBtnColor(view);
                    break;
                case R.id.btn_18:
                    tileClick(18);
                    setBtnColor(view);
                    break;
                case R.id.btn_19:
                    tileClick(19);
                    setBtnColor(view);
                    break;
                default:
                    break;
            }
        }

        // Check if the Start or Stop button has been clicked.
        switch (view.getId()) {
            case R.id.btn_stop:
                // Clears the board and
                stopGame();
                break;
            case R.id.btn_play:
                // Reset Board
                resetBtnColors();

                // Reset game variables.
                resetGameVariables();

                // Start the game if Start button has been clicked.
                startGame();
                break;
            case R.id.btn_show_answer:
                // Show answer to tiles
                if (canShow) {
                    showAnswer();

                    // If show answer was pressed while player has not won the round the player
                    // will automatically lose the round.
                    if (!wonRound) {
                        // Set the roundWon variable to false to indicate the round was lost
                        currentRound.setRoundWon(false);

                        // Add current round to game.
                        MainActivity.game.getGameStats().getPlayerStats().add(currentRound);

                        // Reset game variables.
                        resetGameVariables();
                    }
                }

            default:
                break;
        }
    }

    // Show the board according to current stored settings
    public void showAnswer() {
        int btn_id;
        Button button;

        // Fill tiles with colors from tileColors array
        for (int x = 0; x < MainActivity.game.getTileColors().size(); ++x) {
            btn_id = getResources().getIdentifier("btn_" + x, "id", getPackageName());
            button = (Button) findViewById(btn_id);
            button.setBackgroundColor(MainActivity.game.getTileColors().get(x));
        }
    }

    // This function is ran when btn_0 through btn_10 has been clicked to check if the round
    // has been won. If won, update the GameStats and clear game variables.
    public void tileClick(int buttonNumber) {
        // If player has not clicked on tiles a number of times equal to the number of
        // target tiles, then increment the number of guesses so far.
        if (MainActivity.game.getGuesses() < MainActivity.game.getTargetTiles().size()) {
            MainActivity.game.incrementGuesses();
            MainActivity.game.getButtonsGuessed().add(buttonNumber);

            // Decrement the value of number of guesses left, the update the value in the UI
            --num_of_guesses_left_value;
            num_of_guesses_left_answer.setText(String.valueOf(num_of_guesses_left_value));
        }

        // If the number of guesses so far is equal to the number of target tiles then run this
        // block of code.
        if (MainActivity.game.getGuesses() == MainActivity.game.getTargetTiles().size()) {
            // Disable clicking of additional tiles
            canTouch = false;

            // Sort the two arrays for easy comparison
            Collections.sort(MainActivity.game.getTargetTiles());
            Collections.sort(MainActivity.game.getButtonsGuessed());

            // Set wonRound to true
            wonRound = true;

            // Compare if user selected tiles match tiles with target color. If the tile numbers do
            // not match then set wonRound to false.
            for (int x = 0; x < MainActivity.game.getTargetTiles().size(); ++x) {
                if (!Objects.equals(MainActivity.game.getTargetTiles().get(x), MainActivity.game.getButtonsGuessed().get(x))) {
                    wonRound = false;
                }
            }

            // Set value of round status
            if (wonRound)
                round_status_value = "You won!";
            else
                round_status_value= "You lost...";

            // Update round status in the UI
            round_status_answer.setText(round_status_value);

            // Run the animation
            runAnimation();

            // Set the roundWon variable.
            currentRound.setRoundWon(wonRound);

            // Add current round to game.
            MainActivity.game.getGameStats().getPlayerStats().add(currentRound);
        }
    }

    // Fill the board with color tiles.
    public void generateBoard() {
        int btn_id;
        Button button;
        int randomNumber;
        int targetTilesColorsSize;

        num_of_guesses_left_answer = (TextView) findViewById(R.id.text_num_of_guesses_left_answer);
        num_of_guesses_left_answer.setText(String.valueOf(num_of_guesses_left_value));
        round_status_answer = (TextView) findViewById(R.id.text_round_status_answer);
        round_status_answer.setText(round_status_value);

        // Get the size of targetTilesColors array in the game object to set the lower bound for the
        // random number generator.
        targetTilesColorsSize = MainActivity.game.getTargetTilesColors().size();

        // Switch the positions of the target tile colors so that they're in front of the
        // colorsArray in the game object. That way, when generating random values for tile colors, we
        // can skip the target tile colors, since we know they're in the front of the array.
        for (int x = 0; x < MainActivity.game.getTargetTilesColors().size(); ++x)
            colorSwap(MainActivity.game.getTargetTilesColors().get(x), x);

        // Fill tileColors array with random colors, but skip the values that are target tile colors.
        for (int x = 0; x < 20; ++x)
            MainActivity.game.getTileColors().add(MainActivity.game.getColorsArray().get(rand.ints(1, targetTilesColorsSize, 20).findFirst().getAsInt()));


        // Generate random index for where to put target tiles.
        for (int x = 0; x < MainActivity.game.getNumOfTiles(); ++x) {
            randomNumber = rand.nextInt(20);

            // If the index of where the tile should be placed already exists, get a new index.
            while (MainActivity.game.getTargetTiles().contains(randomNumber))
                randomNumber = rand.nextInt(20);

            MainActivity.game.getTargetTiles().add(randomNumber);

            MainActivity.game.getTileColors().set(MainActivity.game.getTargetTiles().get(x), MainActivity.game.getTargetTilesColors().get(rand.nextInt(targetTilesColorsSize)));
        }

        // Fill tiles with colors from tileColors array.
        for (int x = 0; x < MainActivity.game.getTileColors().size(); ++x) {
            btn_id = getResources().getIdentifier("btn_" + x, "id", getPackageName());
            button = (Button) findViewById(btn_id);
            button.setBackgroundColor(MainActivity.game.getTileColors().get(x));
        }
    }

    // Reset all buttons to default colors
    public void resetBtnColors() {
        int btn_id;
        Button button;

        for (int x = 0; x < 20; ++x) {
            btn_id = getResources().getIdentifier("btn_" + x, "id", getPackageName());
            button = (Button) findViewById(btn_id);
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.default_background));
        }
    }

    // Runs animation process
    public void runAnimation() {
        // Starts the animation
        // Start animation
        TimerTask showAnimation = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    // Start animation
                    round_status_answer.startAnimation(zoomIn);
                });
            }
        };

        // Clears the animation
        // Clears animation
        TimerTask clearAnimation = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    // Clears animation
                    round_status_answer.clearAnimation();
                });
            }
        };

        // Fill the board with colors 3 seconds after the start button has been clicked.
        timer.schedule(showAnimation, 0);
        timer.schedule(clearAnimation, 3000);
    }

    // Starts the game.
    public void startGame() {
        // Timed function to fill the board with colors.
        // Fill the board with colors.
        TimerTask fillBoard = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    // Fill the board with colors.
                    generateBoard();
                });
            }
        };

        // Timed function to clear the board of colors.
        // Clear the board of colors.
        // User can now click on tiles to see which one matched after the board has been cleared.
        // User can now click on show answer
        TimerTask hideBoard = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    // Clear the board of colors.
                    resetBtnColors();

                    // User can now click on tiles to see which one matched after the board has been cleared.
                    canTouch = true;

                    // User can now click on show answer
                    canShow = true;
                });
            }
        };

        // Get date information.
        Date today = new Date();

        // Initialize new round information.
        currentRound = new RoundStats(today, MainActivity.game.getInterval(), false);

        // Assume the round has been won, in tileClick() will decide final outcome.
        wonRound = false;

        // While hideBoard has not been called, do not register any tiles that have been clicked.
        canTouch = false;

        // While hideBoard has not been called, do not allow showing of the answer.
        canShow = false;

        // Set value to number of guesses left to the value of the number of target tiles
        num_of_guesses_left_value = MainActivity.game.getNumOfTiles();

        // Set value to round status to an empty string
        round_status_value = "";

        // Fill the board with colors 3 seconds after the start button has been clicked.
        timer.schedule(fillBoard, 3000);

        // Clear the board of colors after an amount of time equal to the interval after the start
        // button has been clicked.
        timer.schedule(hideBoard, 3000 + MainActivity.game.getInterval());
    }

    // Run this if Stop button is pushed. This resets the game and round stats.
    public void stopGame() {
        // Stop any scheduled tasks
        timer.cancel();

        // Disable clicking of the tiles
        canTouch = false;

        // Reset wonRound variable
        wonRound = true;

        // Resets the board
        resetBtnColors();
    }

    // Clears data from game variables. This should be used at the beginning of every round.
    public void resetGameVariables() {
        MainActivity.game.clearGuesses();
        MainActivity.game.clearButtonsGuessed();
        MainActivity.game.clearTargetTiles();
        MainActivity.game.clearTileColors();
    }

    // Swaps color values
    public void colorSwap(int color, int index) {
        if (index < MainActivity.game.getColorsArray().size()) {
            int tmpColor = MainActivity.game.getColorsArray().get(index);

            for (int x = 0; x < MainActivity.game.getColorsArray().size(); ++x) {
                if (MainActivity.game.getColorsArray().get(x) == color) {
                    MainActivity.game.getColorsArray().set(index, color);
                    MainActivity.game.getColorsArray().set(x, tmpColor);
                }
            }
        }
    }
}


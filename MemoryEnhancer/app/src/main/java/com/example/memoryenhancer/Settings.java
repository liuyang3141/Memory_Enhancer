package com.example.memoryenhancer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    private Spinner targetTile, interval;
    private static TextView curTargetTiles, curInterval, curTargetTileColors;

    private static Button targetTileColor1, targetTileColor2, targetTileColor3;
    protected static int numOfTiles;
    protected static int intervalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Call this activity's function to use ActionBar utility methods
        ActionBar actionBar= getSupportActionBar();

        // Set title in the ActionBar
        actionBar.setTitle("Settings");

        init();

    }

    // Inflates the options menu when the user opens the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);

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
    public void init() {
        // Initialize the values for current number of target tiles and interval
        curTargetTiles = (TextView) findViewById(R.id.text_current_number_of_target_tiles_answer);
        curTargetTiles.setText(String.valueOf(MainActivity.game.getNumOfTiles()));
        curInterval = (TextView) findViewById(R.id.text_current_interval_answer);
        curInterval.setText(String.valueOf(MainActivity.game.getInterval()));
        curTargetTileColors = (TextView) findViewById(R.id.text_current_target_tile_colors_answer);
        curTargetTileColors.setText(String.valueOf(MainActivity.game.getTargetTilesColors().size()));

        // Initialize the colors for targetTileColor1-3
        targetTileColor1 = (Button) findViewById(R.id.button_target_tile_color1);
        targetTileColor2 = (Button) findViewById(R.id.button_target_tile_color2);
        targetTileColor3 = (Button) findViewById(R.id.button_target_tile_color3);

        fillTargetTileColorButtons();

        hideTargetTileColors();

        // Initialize the spinners
        numOfTiles = MainActivity.game.getNumOfTiles();
        intervalTime = MainActivity.game.getInterval();

        targetTile = (Spinner) findViewById(R.id.sp_target_tiles);
        interval = (Spinner) findViewById(R.id.sp_interval);

        ArrayAdapter<CharSequence> targetTilesAdapter = ArrayAdapter.createFromResource(this, R.array.num_target_tiles, android.R.layout.simple_spinner_item);
        targetTilesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        targetTile.setAdapter(targetTilesAdapter);
        targetTile.setOnItemSelectedListener(new TargetTileSpinnerSelection());

        ArrayAdapter<CharSequence> intervalAdapter = ArrayAdapter.createFromResource(this, R.array.interval_time, android.R.layout.simple_spinner_item);
        intervalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interval.setAdapter(intervalAdapter);
        interval.setOnItemSelectedListener(new IntervalSpinnerSelection());
    }

    public static void updateText() {
        curTargetTiles.setText(String.valueOf(MainActivity.game.getNumOfTiles()));
        curInterval.setText(String.valueOf(MainActivity.game.getInterval()));
        curTargetTileColors.setText(String.valueOf(MainActivity.game.getTargetTilesColors().size()));
    }

    public static void hideTargetTileColors() {
        if (MainActivity.game.getTargetTilesColors().size() == 1) {
            // Hide button 3
            targetTileColor3.setVisibility(View.GONE);

            // Enable button 1
            targetTileColor1.setEnabled(true);
        }
        else if (MainActivity.game.getTargetTilesColors().size() == 2) {
            // Show button 3
            targetTileColor3.setVisibility(View.VISIBLE);

            // Enable button 2
            targetTileColor2.setEnabled(true);

            // Disable button 1 if second target tile color isn't none
            if (MainActivity.game.getTargetTilesColors().get(1) != -1)
                targetTileColor1.setEnabled(false);
        }
        else if (MainActivity.game.getTargetTilesColors().size() == 3) {
            // Disable buttons 1 and 2 if third target tile color isn't none
            if (MainActivity.game.getTargetTilesColors().get(2) != -1) {
                targetTileColor1.setEnabled(false);
                targetTileColor2.setEnabled(false);
            }
            // Otherwise, enable only button 2.
            else {
                targetTileColor1.setEnabled(false);
                targetTileColor2.setEnabled(true);
            }
        }
    }

    // Populates the targetTileColor buttons
    public static void fillTargetTileColorButtons() {
        // Populate the targetTileColor1-3 button with the current target tile color(s).
        switch (MainActivity.game.getTargetTilesColors().size()) {
            case 1:
                targetTileColor1.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(0));
                break;
            case 2:
                targetTileColor1.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(0));
                targetTileColor2.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(1));
                break;
            case 3:
                targetTileColor1.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(0));
                targetTileColor2.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(1));
                targetTileColor3.setBackgroundColor(MainActivity.game.getTargetTilesColors().get(2));
                break;
            default:
                // Do nothing
        }
    }
    public void onClick(View view) {
        Intent intent;

        switch(view.getId()) {
            case R.id.btn_save:
                MainActivity.game.setNumOfTiles(numOfTiles);
                MainActivity.game.setInterval(intervalTime);
                break;
            case R.id.button_target_tile_color1:
                intent = new Intent(this, ColorPicker.class);
                intent.putExtra("Message", "1");
                startActivity(intent);
                break;
            case R.id.button_target_tile_color2:
                intent = new Intent(this, ColorPicker.class);
                intent.putExtra("Message", "2");
                startActivity(intent);
                break;
            case R.id.button_target_tile_color3:
                intent = new Intent(this, ColorPicker.class);
                intent.putExtra("Message", "3");
                startActivity(intent);
                break;
            default:
                break;
        }
        //hideTargetTileColors();
    }
}
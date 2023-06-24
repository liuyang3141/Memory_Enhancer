package com.example.memoryenhancer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    protected static MemoryEnhancer game;
    protected static final String GAME_KEY = "game";
    protected static SharedPreferences prefs;
    protected static String sharedPrefFile = "com.example.android.memoryenhancer";
    protected static SharedPreferences.Editor prefsEditor;
    protected static Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call this activity's function to use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // Set title
        actionBar.setTitle("Memory Enhancer");

        initGame();
    }

    // Inflates the options menu when the user opens the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // Launch activity when user clicks on menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
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
    public void initGame() {
        game = new MemoryEnhancer(this);
        /*
        // Fill colors with the colors listed in colors.xml in values folder
        int colors[] = getResources().getIntArray(R.array.colors_array);

        // Creating temp arrays to hold values to pass to MemoryEnhancer constructor
        ArrayList<Integer> tmpColorsArray = new ArrayList<Integer>();
        ArrayList<Integer> tmpTargetTilesColors = new ArrayList<Integer>();

        // Add default color of target tile to the array
        tmpTargetTilesColors.add(colors[0]);

        // Fill temp array with all possible colors for tiles
        for (int x = 0; x < colors.length; ++x) {
            tmpColorsArray.add(colors[x]);
        }

        // Initialize default values. Default values are 2 target tiles, 3 second interval.
        GameStats defaultStats = new GameStats();
        game = new MemoryEnhancer(2, 3000, tmpColorsArray, tmpTargetTilesColors, defaultStats);
        */

        // Load shared preferences.
        prefs = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        prefsEditor = prefs.edit();

        /*
        prefsEditor.clear();
        prefsEditor.apply();
        */

        gson = new Gson();
        String json = prefs.getString(GAME_KEY, "");


        // If loaded MemoryEnhancer object is not empty then set current MemoryEnhancer object
        // to the loaded object.
        if(json != "") {
            game = gson.fromJson(json, MemoryEnhancer.class);
        }
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }
}
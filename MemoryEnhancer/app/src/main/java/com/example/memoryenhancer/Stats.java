package com.example.memoryenhancer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Stats extends AppCompatActivity {
    TextView roundsPlayed;
    TextView roundsWon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        // Call this activity's function to use ActionBar utility methods
        ActionBar actionBar= getSupportActionBar();

        // Set title in the ActionBar
        actionBar.setTitle("Stats");

        showStats();
    }

    // Inflates the options menu when the user opens the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stats, menu);

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
            case R.id.help:
                intent = new Intent(this, GameHelp.class);
                startActivity(intent);
                break;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    // Initialize values for number of rounds played and number of rounds won
    public void showStats() {
        roundsPlayed = (TextView) findViewById(R.id.text_rounds_played_answer);
        roundsPlayed.setText(String.valueOf(MainActivity.game.getGameStats().getRoundsPlayed()));

        roundsWon = (TextView) findViewById(R.id.text_rounds_won_answer);
        roundsWon.setText(String.valueOf(MainActivity.game.getGameStats().getRoundsWon()));
    }
}
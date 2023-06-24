package com.example.memoryenhancer;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class TargetTileSpinnerSelection extends Activity implements AdapterView.OnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Set number of target tiles depending on the index value of the num_target_tiles array in strings.xml
        // represented by the pos integer.
        switch(pos) {
            case 0:
                Settings.numOfTiles = 1;
                break;
            case 1:
                Settings.numOfTiles = 2;
                break;
            case 2:
                Settings.numOfTiles = 3;
                break;
            case 3:
                Settings.numOfTiles = 4;
                break;
            case 4:
                Settings.numOfTiles = 5;
                break;
            case 5:
                Settings.numOfTiles = 6;
                break;
            case 6:
                Settings.numOfTiles = 7;
                break;
            case 7:
                Settings.numOfTiles = 8;
                break;
            case 8:
                Settings.numOfTiles = 9;
                break;
            case 9:
                Settings.numOfTiles = 10;
                break;
            default:
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}

package com.example.memoryenhancer;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class IntervalSpinnerSelection extends Activity implements AdapterView.OnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Set interval values depending on the index value of the interval_time array in strings.xml
        // represented by the pos integer.
        switch(pos) {
            case 0:
                Settings.intervalTime = 5000;
                break;
            case 1:
                Settings.intervalTime = 4000;
                break;
            case 2:
                Settings.intervalTime = 3000;
                break;
            case 3:
                Settings.intervalTime = 2000;
                break;
            case 4:
                Settings.intervalTime = 1000;
                break;
            case 5:
                Settings.intervalTime = 750;
                break;
            case 6:
                Settings.intervalTime = 500;
                break;
            case 7:
                Settings.intervalTime = 250;
                break;
            case 8:
                Settings.intervalTime = 100;
                break;
            default:
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}

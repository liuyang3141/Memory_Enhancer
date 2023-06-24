package com.example.memoryenhancer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ColorPicker extends AppCompatActivity {
    // Used for checking the intent message value passed by Settings activity
    protected static String button_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        init();

        Intent intent = getIntent();
        button_number = intent.getStringExtra("Message");
    }

    public void init() {
        List<ColorItem> color_items = new ArrayList<ColorItem>();
        color_items.add(new ColorItem("Green"));
        color_items.add(new ColorItem("Light Green"));
        color_items.add(new ColorItem("Dark Green"));
        color_items.add(new ColorItem("Purple"));
        color_items.add(new ColorItem("Light Purple"));
        color_items.add(new ColorItem("Dark Purple"));
        color_items.add(new ColorItem("Red"));
        color_items.add(new ColorItem("Light Red"));
        color_items.add(new ColorItem("Dark Red"));
        color_items.add(new ColorItem("Brown"));
        color_items.add(new ColorItem("Light Brown"));
        color_items.add(new ColorItem("Dark Brown"));
        color_items.add(new ColorItem("Blue"));
        color_items.add(new ColorItem("Light Blue"));
        color_items.add(new ColorItem("Dark Blue"));
        color_items.add(new ColorItem("Grey"));
        color_items.add(new ColorItem("Light Grey"));
        color_items.add(new ColorItem("Dark Grey"));
        color_items.add(new ColorItem("Orange"));
        color_items.add(new ColorItem("Light Orange"));
        color_items.add(new ColorItem("Dark Orange"));
        color_items.add(new ColorItem("Yellow"));
        color_items.add(new ColorItem("Light Yellow"));
        color_items.add(new ColorItem("Dark Yellow"));
        color_items.add(new ColorItem("None"));


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ColorAdapter(getApplicationContext(), color_items));
    }
}
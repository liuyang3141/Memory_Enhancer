package com.example.memoryenhancer;
// Stores the items in the RecyclerView in Settings where
// user picks the target tiles colors
public class ColorItem {
    private String color_name;

    public ColorItem(String color_name) {
        this.color_name = color_name;
    }
    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
}

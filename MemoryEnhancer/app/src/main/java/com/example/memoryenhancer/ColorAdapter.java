package com.example.memoryenhancer;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {
    private final Context context;
    private final List<ColorItem> color_items;

    public ColorAdapter(Context context, List<ColorItem> color_items) {
        this.context = context;
        this.color_items = color_items;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ColorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        // Used for choosing colors for target tiles. Value is passed to ColorPicker.color.
        int colors[] = context.getResources().getIntArray(R.array.colors_array);

        // Change color of the background to match the colors_array in colors.xml
        switch (position) {
            case 0:
                holder.color_name.setBackgroundResource(R.color.green);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 1:
                holder.color_name.setBackgroundResource(R.color.light_green);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 2:
                holder.color_name.setBackgroundResource(R.color.dark_green);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 3:
                holder.color_name.setBackgroundResource(R.color.purple);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 4:
                holder.color_name.setBackgroundResource(R.color.light_purple);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 5:
                holder.color_name.setBackgroundResource(R.color.dark_purple);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 6:
                holder.color_name.setBackgroundResource(R.color.red);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 7:
                holder.color_name.setBackgroundResource(R.color.light_red);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 8:
                holder.color_name.setBackgroundResource(R.color.dark_red);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 9:
                holder.color_name.setBackgroundResource(R.color.brown);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 10:
                holder.color_name.setBackgroundResource(R.color.light_brown);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 11:
                holder.color_name.setBackgroundResource(R.color.dark_brown);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 12:
                holder.color_name.setBackgroundResource(R.color.blue);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 13:
                holder.color_name.setBackgroundResource(R.color.light_blue);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 14:
                holder.color_name.setBackgroundResource(R.color.dark_blue);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 15:
                holder.color_name.setBackgroundResource(R.color.grey);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 16:
                holder.color_name.setBackgroundResource(R.color.light_grey);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 17:
                holder.color_name.setBackgroundResource(R.color.dark_grey);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 18:
                holder.color_name.setBackgroundResource(R.color.orange);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 19:
                holder.color_name.setBackgroundResource(R.color.light_orange);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 20:
                holder.color_name.setBackgroundResource(R.color.dark_orange);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 21:
                holder.color_name.setBackgroundResource(R.color.yellow);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 22:
                holder.color_name.setBackgroundResource(R.color.light_yellow);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 23:
                holder.color_name.setBackgroundResource(R.color.dark_yellow);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
            case 24:
                holder.color_name.setBackgroundResource(R.color.none);
                holder.color_name.setText(color_items.get(position).getColor_name());
                break;
        }

        // Adds the target tile colors to targetTilesColors array list in MainActivity.game.
        holder.color_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (ColorPicker.button_number) {
                    case "1":
                        if (MainActivity.game.getTargetTilesColors().size() == 1) {
                            MainActivity.game.getTargetTilesColors().set(0, colors[holder.getAdapterPosition()]);
                        }
                        else if (MainActivity.game.getTargetTilesColors().size() > 1) {
                            while (MainActivity.game.getTargetTilesColors().size() > 1) {
                                MainActivity.game.getTargetTilesColors().remove(MainActivity.game.getTargetTilesColors().size() - 1);
                            }
                        }

                        // Populate targetTileColor buttons with the appropriate user selected color
                        Settings.fillTargetTileColorButtons();

                        // If none color was chosen remove color from targetTilesColors
                        if (holder.getAdapterPosition() == 24)
                            MainActivity.game.getTargetTilesColors().remove(0);

                        break;
                    case "2":
                        if (MainActivity.game.getTargetTilesColors().size() < 2)
                            MainActivity.game.getTargetTilesColors().add(colors[holder.getAdapterPosition()]);
                        else if (MainActivity.game.getTargetTilesColors().size() > 2) {
                            while (MainActivity.game.getTargetTilesColors().size() > 2) {
                                MainActivity.game.getTargetTilesColors().remove(MainActivity.game.getTargetTilesColors().size() - 1);
                            }
                        }
                        else
                            MainActivity.game.getTargetTilesColors().set(1, colors[holder.getAdapterPosition()]);

                        // Populate targetTileColor buttons with the appropriate user selected color
                        Settings.fillTargetTileColorButtons();

                        // If none color was chosen remove color from targetTilesColors
                        if (holder.getAdapterPosition() == 24)
                            MainActivity.game.getTargetTilesColors().remove(1);

                        break;
                    case "3":
                        if (MainActivity.game.getTargetTilesColors().size() < 3)
                            MainActivity.game.getTargetTilesColors().add(colors[holder.getAdapterPosition()]);
                        else if (MainActivity.game.getTargetTilesColors().size() > 3) {
                            while (MainActivity.game.getTargetTilesColors().size() > 3) {
                                MainActivity.game.getTargetTilesColors().remove(MainActivity.game.getTargetTilesColors().size() - 1);
                            }
                        }
                        else
                            MainActivity.game.getTargetTilesColors().set(2, colors[holder.getAdapterPosition()]);

                        // Populate targetTileColor buttons with the appropriate user selected color
                        Settings.fillTargetTileColorButtons();

                        // If none color was chosen remove color from targetTilesColors
                        if (holder.getAdapterPosition() == 24)
                            MainActivity.game.getTargetTilesColors().remove(2);

                        break;
                    default:
                        // Do nothing
                }

                // Update text in Settings activity
                Settings.updateText();

                Settings.hideTargetTileColors();
            }
        });
    }

    @Override
    public int getItemCount() {
        return color_items.size();
    }
}

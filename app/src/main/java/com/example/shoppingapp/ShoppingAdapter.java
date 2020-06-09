package com.example.shoppingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {
    private ArrayList<ShoppingItem> shoppingItems;

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent , false);
        ShoppingViewHolder svh = new ShoppingViewHolder(v);
        return svh;
    }
    public ShoppingItem getItemAt(int position) {
        return shoppingItems.get(position);
    }

    public ShoppingAdapter(ArrayList<ShoppingItem> shopItems){
        shoppingItems = shopItems;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
            ShoppingItem currentItem = shoppingItems.get(position);
             holder.imageView.setImageResource(currentItem.getImageID());
             holder.titleView.setText(currentItem.getItemTitle());
             holder.descriptionView.setText(currentItem.getItemPrice());
    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView titleView;
        public TextView descriptionView;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleView = itemView.findViewById(R.id.titleView);
            descriptionView = itemView.findViewById(R.id.descriptionView);

        }
    }
}

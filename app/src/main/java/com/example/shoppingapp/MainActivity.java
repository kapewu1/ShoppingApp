package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements  BottomSlideAddMenu.BottomSlideMenuListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter itemAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button addButton;
    private ArrayList<ShoppingItem> mShoppingItems;
    private TextView total_price ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        total_price = findViewById(R.id.price);


        createItemList();
        buildRecycleView();
       //h setTotalPrice();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


            }
        });


        addButton = findViewById(R.id.addItem);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSlideAddMenu bottomMenu = new BottomSlideAddMenu();
                bottomMenu.show(getSupportFragmentManager(), "bottomSlideMenu");
            }
        });
    }

    private void setTotalPrice() {
        double shop_price = 0;
        double value=0;
        for (ShoppingItem item: mShoppingItems
             ) {
             value = Double.parseDouble(item.getItemPrice());
            shop_price += value;
        }
        double v = Math.round(shop_price * 100.0) / 100.0;

        String textValue = Double.toString(v);


        total_price.setText(textValue);
    }


    private void buildRecycleView() {

        recyclerView = findViewById(R.id.recycleViewer);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        itemAdapter = new ShoppingAdapter(mShoppingItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);

    }

    private void createItemList() {
        mShoppingItems = new ArrayList<>();


    }


    @Override
    public void onButtonClicked(ShoppingItem newItem) {
        mShoppingItems.add(newItem);
        itemAdapter.notifyDataSetChanged();
        setTotalPrice();
    }
}

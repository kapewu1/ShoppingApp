package com.example.shoppingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSlideAddMenu extends BottomSheetDialogFragment {
        private BottomSlideMenuListener mListener;
        private EditText item_name;
        private EditText item_amount;
        private EditText item_price;
        private Button send_values;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_editpanel, container, false);

        item_name = v.findViewById(R.id.item_name);
        item_amount = v.findViewById(R.id.item_amount);
        item_price = v.findViewById(R.id.item_price);
        send_values = v.findViewById(R.id.set_button);


        send_values.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isEmpty(item_name)){
                    Toast.makeText(getActivity(),
                            "Podaj nazwe produktu", Toast.LENGTH_LONG).show();
                }
               else if(isEmpty(item_amount)){
                    Toast.makeText(getActivity(),
                            "Podaj ilość produktów", Toast.LENGTH_LONG).show();
                }
               else if(isEmpty(item_price)){
                    Toast.makeText(getActivity(),
                            "Podaj cenę produktu", Toast.LENGTH_LONG).show();
                }
               else {
                    String price = String.valueOf(countItemPrice());
                    ShoppingItem item = new ShoppingItem(R.drawable.fruit, item_name.getText().toString(), price
                            , Double.parseDouble(item_amount.getText().toString()));

                    mListener.onButtonClicked(item);
                    dismiss();
                }
            }
        });

        return v;
    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
    private double countItemPrice()
    {
        double price = 0;

        double item_value = Double.parseDouble(item_price.getText().toString());
        double item_quant = Double.parseDouble(item_amount.getText().toString());

        price = item_quant * item_value;

        double value = Math.round(price * 100.0) / 100.0;
        return value;
  }

    public interface BottomSlideMenuListener{
        void onButtonClicked(ShoppingItem newItem);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (BottomSlideMenuListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + "must implement BottomSlideMenuListener");
        }
    }
}

package com.example.shoppingapp;

import android.provider.BaseColumns;

public class ShoppingConst {

    private ShoppingConst (){}

    public static final class ShopEntry implements BaseColumns{
    public static final String TABLE_NAME = "shopList";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_PRICE = "price";


    }
}

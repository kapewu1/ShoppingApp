package com.example.shoppingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ShoppingDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shoplist.db";
    public static final int DATABASE_VERSION = 1;


    public ShoppingDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SHOPLIST_TABLE = "CREATE TABLE " +
                ShoppingConst.ShopEntry.TABLE_NAME + " (" +
                ShoppingConst.ShopEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ShoppingConst.ShopEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ShoppingConst.ShopEntry.COLUMN_AMOUNT + " TEXT NOT NULL, " +
                ShoppingConst.ShopEntry.COLUMN_PRICE  +
                ");";
        db.execSQL(SQL_CREATE_SHOPLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ShoppingConst.ShopEntry.TABLE_NAME);
        onCreate(db);
    }
}

package com.example.shoppingapp;

public class ShoppingItem {
    private int imageID;
    private String itemTitle;
    private String itemPrice;
    private double itemAmount;

    public ShoppingItem(int id, String title, String price, double amount) {
        imageID = id;
        itemTitle = title;
        itemPrice = price;
        itemAmount = amount;
    }
    public int getImageID() {
        return imageID;
    }
    public String getItemTitle(){
        return itemTitle;
    }
    public String getItemPrice() {
        return itemPrice;
    }
    public double getItemAmount() {
        return itemAmount;
    }
}

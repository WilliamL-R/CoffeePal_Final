package com.example.u1563819.CoffeePal.Model;

/**
 * Created by u1563819 on 19/02/2019.
 */

public class Order {
    private String ItemId;
    private String ItemName;
    private String Quantity;
    private String Price;

    public Order(){

    }

    public Order(String itemId, String itemName, String quantity, String price) {
        ItemId = itemId;
        ItemName = itemName;
        Quantity = quantity;
        Price = price;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    //Ignore "£", look into this if causing issues
    public String ignorePound(String value){

        String header = value;
        header = header.startsWith("£") ? header.substring(1) : header;
        System.out.println(header);
        return header;
    }

}

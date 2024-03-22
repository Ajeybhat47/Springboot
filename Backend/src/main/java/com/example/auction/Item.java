package com.example.auction;

public class Item {
    private int itemId;
    private String itemName;
    private String description;
    private double initialPrice;
    private int sellerId;

    public Item(int itemId, String itemName, String description, double initialPrice, int sellerId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.initialPrice = initialPrice;
        this.sellerId = sellerId;
    }

    // getters and setters
    public int getItemId() {
        return itemId;
    }   

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }   

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }   

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    

    
}

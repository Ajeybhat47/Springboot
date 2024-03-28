package com.example.auction;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;
    

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "initial_price")
    private double initialPrice;

    @Column(name = "seller_id")
    private Long sellerId;

    // Constructors, getters, setters, and other methods

    public Item() {
    }

    public Item(String itemName, String description, double initialPrice, Long sellerId) {
        this.itemName = itemName;
        this.description = description;
        this.initialPrice = initialPrice;
        this.sellerId = sellerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", initialPrice=" + initialPrice +
                ", sellerId=" + sellerId +
                '}';
    }

}

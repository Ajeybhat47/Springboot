package com.example.auction.Models;

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
    private Double initialPrice;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY for lazy loading
    @JoinColumn(name = "seller_id")
    private User seller;

    // Getters and setters

    public Item() {
    }

    public Item(String itemName, String description, Double initialPrice, User seller) {
        this.itemName = itemName;
        this.description = description;
        this.initialPrice = initialPrice;
        this.seller = seller;
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

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", initialPrice=" + initialPrice +
                ", seller=" + seller +
                '}';
    }
    
}

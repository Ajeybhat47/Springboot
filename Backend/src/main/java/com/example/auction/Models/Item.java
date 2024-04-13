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

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "initial_price")
    private Double initialPrice;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY for lazy loading
    @JoinColumn(name = "seller_id")
    private Farmer seller;

    @Column(name = "is_sold")
    private boolean isSold = false;

    // Constructors
    public Item() {
    }

    public Item(String itemName, String category, String description, Double initialPrice, Farmer seller) {
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.initialPrice = initialPrice;
        this.seller = seller;
    }

    // Getters and setters
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Farmer getSeller() {
        return seller;
    }

    public void setSeller(Farmer seller) {
        this.seller = seller;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    // ToString method
    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", initialPrice=" + initialPrice +
                ", seller=" + seller +
                '}';
    }
}

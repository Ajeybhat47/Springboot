package com.example.auction.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmer")
@PrimaryKeyJoinColumn(name = "user_id")
public class Farmer extends User {
    // Additional attributes specific to Farmer can be added here

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "seller")
    private List<Item> itemsForSale;

    // getter setter constructor

    public Farmer() {
    }

    public Farmer(String address, List<Item> itemsForSale) {
        this.address = address;
        this.itemsForSale = itemsForSale;
    }

    public Farmer(String username, String password, String email, String address, List<Item> itemsForSale) {
        super(username, password, email);
        this.address = address;
        this.itemsForSale = itemsForSale;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }

    public void setItemsForSale(List<Item> itemsForSale) {
        this.itemsForSale = itemsForSale;
    }

    

    

}


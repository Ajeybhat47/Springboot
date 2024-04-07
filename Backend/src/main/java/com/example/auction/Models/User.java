package com.example.auction.Models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "winner")
    private List<Auction> wonAuctions;

    @OneToMany(mappedBy = "seller")
    private List<Item> itemsForSale;

    @OneToMany(mappedBy = "bidder")
    @JsonBackReference // For custom serialization to break the loop
    private List<Bid> bids;

    
    // Getters and setter
    public User() {
    }

    public User(String email, String password, String username, String role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Auction> getWonAuctions() {
        return wonAuctions;
    }

    public void setWonAuctions(List<Auction> wonAuctions) {
        this.wonAuctions = wonAuctions;
    }

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }

    public void setItemsForSale(List<Item> itemsForSale) {
        this.itemsForSale = itemsForSale;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    

}

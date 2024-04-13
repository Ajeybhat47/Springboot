package com.example.auction.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "trader")
@PrimaryKeyJoinColumn(name = "user_id")
public class Trader extends User {
    // Additional attributes specific to Bidder can be added here

    @OneToMany(mappedBy = "winner")
    private List<Auction> wonAuctions;

    @OneToMany(mappedBy = "bidder")
    @JsonBackReference // For custom serialization to break the loop
    private List<Bid> bids;

    // getter setter constructor

    public Trader() {
    }

    public Trader(List<Auction> wonAuctions, List<Bid> bids) {
        this.wonAuctions = wonAuctions;
        this.bids = bids;
    }


}

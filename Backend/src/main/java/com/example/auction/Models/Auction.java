package com.example.auction.Models;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id")
    private Long auctionId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToMany(mappedBy = "auction")
    @JsonBackReference // For custom serialization to break the loop
    private List<Bid> bids;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private User winner;

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "status")
    private String status;

    // Getters and setters

    public Auction() {
    }

    public Auction(Item item, Double basePrice, String status) {
        this.item = item;
        this.basePrice = basePrice;
        this.status = status;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", item=" + item +
                ", basePrice=" + basePrice +
                ", status='" + status + '\'' +
                ", winner=" + winner +
                '}';
    }


}
package com.example.auction;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "bid")
public class Bid {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Long bidId;
    
    @ManyToOne
    @JoinColumn(name = "bidder_id")
    private User bidder;
    
    @Column(name = "bid_amount")
    private Double bidAmount;
    
    @Column(name = "bid_time")
    private LocalDateTime bidTime;
    
    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
    
    // Getters and setters

    public Bid() {
    }


    public Bid(User bidder, Double bidAmount, LocalDateTime bidTime, Auction auction) {
        this.bidder = bidder;
        this.bidAmount = bidAmount;
        this.bidTime = bidTime;
        this.auction = auction;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }


    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", bidder=" + bidder +
                ", bidAmount=" + bidAmount +
                ", bidTime=" + bidTime +
                ", auction=" + auction +
                '}';
    }
    
}

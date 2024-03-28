package com.example.auction;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Long bidId;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;


    @Column(name = "bidder_id")
    private Long bidderId;

    @Column(name = "bid_amount")
    private double bidAmount;

    @Column(name = "bid_time")
    private Date bidTime;

    
    // Constructors, getters, setters, and other methods

    public Bid() {
    }

    public Bid(Long bidderId, double bidAmount, Date bidTime, Auction auction) {
        this.bidderId = bidderId;
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

    public Long getBidderId() {
        return bidderId;
    }

    public void setBidderId(Long bidderId) {
        this.bidderId = bidderId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
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
                ", bidderId=" + bidderId +
                ", bidAmount=" + bidAmount +
                ", bidTime=" + bidTime +
                ", auction=" + auction +
                '}';
    }
}

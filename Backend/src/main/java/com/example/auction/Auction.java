package com.example.auction;

import jakarta.persistence.*;
import java.util.List;

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



    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Bid> bids;

    

    @Column(name = "base_price")
    private double basePrice;

    @Column(name = "status")
    private String status;

    @Column(name = "winner_id")
    private Long winnerId;

    

    // Constructors, getters, setters, and other methods

    public Auction() {
    }

    public Auction(Item item, double basePrice, String status, Long winnerId) {
        this.item = item;
        this.basePrice = basePrice;
        this.status = status;
        this.winnerId = winnerId;
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

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", item=" + item +
                ", basePrice=" + basePrice +
                ", status='" + status + '\'' +
                ", winnerId=" + winnerId +
                '}';
    }

}

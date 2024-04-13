package com.example.auction.Models;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id")
    private Long auctionId;

    @OneToOne
    @JoinColumn(name = "winning_bid")
    private Bid winningBid;

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "status")
    private String status;

    @Column(name = "closing_time")
    private LocalDateTime closingTime;

    // Joining references
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToMany(mappedBy = "auction")
    @JsonBackReference // For custom serialization to break the loop
    private List<Bid> bids;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Trader winner;

    // Constructors
    public Auction() {
    }

    public Auction(Item item, Double basePrice, String status, LocalDateTime closingTime) {
        this.item = item;
        this.basePrice = basePrice;
        this.status = status;
        this.closingTime = closingTime;
    }

    // Getters and setters
    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Bid winningBid) {
        this.winningBid = winningBid;
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

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Trader getWinner() {
        return winner;
    }

    public void setWinner(Trader winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", item=" + item +
                ", basePrice=" + basePrice +
                ", status='" + status + '\'' +
                ", closingTime=" + closingTime +
                ", winner=" + winner +
                '}';
    }
}

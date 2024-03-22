package com.example.auction;

import java.util.HashMap;

public class Auction {

    private int auctionId;
    private Item item;
    private double basePrice;
    private String status;
    private int winnerId;
    // map to store bids
    private HashMap<Integer, Bid> bids;

    public Auction(int auctionId, Item item, double basePrice, String status, int winnerId) {
        this.auctionId = auctionId;
        this.item = item;
        this.basePrice = basePrice;
        this.status = status;
        this.winnerId = winnerId;
    }

    // getters and setters
    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
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

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public void findWinner() {
        // Logic to find winner
        System.out.println("Winner found for auction: " + this.auctionId);
    }

    public void addBid(Bid bid) {
        bids.put(bid.getBidId(), bid);
    }
    
    
}

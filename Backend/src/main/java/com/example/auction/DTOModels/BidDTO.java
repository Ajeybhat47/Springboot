package com.example.auction.DTOModels;

import java.time.LocalDateTime;

public class BidDTO {
    
    private Long bidId;
    private Long auctionId;
    private Long bidderId;
    private Double bidAmount;
    private LocalDateTime bidTime;

    public BidDTO() {
    }

    public BidDTO(Long bidId, Long auctionId, Long bidderId,Double bidAmount, LocalDateTime bidTime) {
        this.bidId = bidId;
        this.auctionId = auctionId;
        this.bidderId = bidderId;
        
        this.bidAmount = bidAmount;
        this.bidTime = bidTime;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getBidderId() {
        return bidderId;
    }

    public void setBidderId(Long bidderId) {
        this.bidderId = bidderId;
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

    @Override
    public String toString() {
        return "bidsDTO{" +
                "bidId=" + bidId +
                ", auctionId=" + auctionId +
                ", bidderId=" + bidderId +
                ", bidAmount=" + bidAmount +
                ", bidTime=" + bidTime +
                '}';
    }



}

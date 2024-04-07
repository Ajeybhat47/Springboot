package com.example.auction.DTOModels;

import java.time.LocalDateTime;

import com.example.auction.Models.Bid;

public class BidDTO {
    
    private Long bidId;
    private Long auctionId;
    private Long bidderId;
    private Double bidAmount;
    private LocalDateTime bidTime;

    public BidDTO() {
    }

    public BidDTO(Bid bid) {
        this.bidId = bid.getBidId();
        this.auctionId = bid.getAuction().getAuctionId();
        this.bidderId = bid.getBidder().getUserId();
        this.bidAmount = bid.getBidAmount();
        this.bidTime = bid.getBidTime();
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

    public static BidDTO mapEntityToDto(Bid bid) {
        return new BidDTO(
                bid.getBidId(),
                bid.getAuction().getAuctionId(),
                bid.getBidder().getUserId(),
                bid.getBidAmount(),
                bid.getBidTime()
        );
    }
}

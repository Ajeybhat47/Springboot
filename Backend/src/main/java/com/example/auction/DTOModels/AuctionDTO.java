package com.example.auction.DTOModels;

import com.example.auction.Models.Auction;

public class AuctionDTO {

    private Long auctionId;
    private String status;
    private Double initialPrice;
    private Long itemId;
    private Long winnerId;

    public AuctionDTO() {
    }
 
    public AuctionDTO(Long auctionId, String status, Double initialPrice, Long itemId, Long winnerId) {
        this.auctionId = auctionId;
        this.status = status;
        this.initialPrice = initialPrice;
        this.itemId = itemId;
        this.winnerId = winnerId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }



    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    @Override
    public String toString() {
        return "AuctionDTO{" +
                "auctionId=" + auctionId +
                ", status='" + status + '\'' +
                ", initialPrice=" + initialPrice +
                ", itemId=" + itemId +
                ", winnerId=" + winnerId +
                '}';
    }

    public static AuctionDTO mapEntityToDto(Auction auction) {
        
        if(auction.getWinner() != null)
            return new AuctionDTO(auction.getAuctionId(), auction.getStatus(), auction.getBasePrice(), auction.getItem().getItemId() , auction.getWinner().getUserId());
    
        return new AuctionDTO(auction.getAuctionId(), auction.getStatus(), auction.getBasePrice(), auction.getItem().getItemId() , null);
    }



    
}

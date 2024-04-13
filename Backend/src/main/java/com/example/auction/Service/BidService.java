package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.auction.DTOModels.BidDTO;
import com.example.auction.Models.Auction;
import com.example.auction.Models.Bid;

import com.example.auction.Repository.AuctionRepository;
import com.example.auction.Repository.BidRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.example.auction.Models.Trader;

import com.example.auction.Repository.TraderRepository;
@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private TraderRepository traderRepository;

    public BidDTO getBidById(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow(() -> new NoSuchElementException("Bid not found for ID: " + bidId));
        return new BidDTO(bid);
    }

    public List<BidDTO> getAllBids(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionId(auctionId);
        return bids.stream().map(BidDTO::new).collect(Collectors.toList());
    }

    public BidDTO getBidByTraderId(Long traderId, Long auctionId) {
        Bid bid = bidRepository.findByBidderId(traderId, auctionId);
        if (bid == null) {
            return null;
        }
        return new BidDTO(bid);
    }
    
    public String addBid(Bid bid, Long auctionId, Long traderId) {
        if (auctionId == null || traderId == null || bid == null) {
            throw new IllegalArgumentException("Auction ID, Trader ID, and Bid information must not be null.");
        }

        Auction auction = auctionRepository.findById(auctionId).orElseThrow(() -> new NoSuchElementException("Auction not found for ID: " + auctionId));
        Trader trader = traderRepository.findById(traderId).orElseThrow(() -> new NoSuchElementException("Trader not found for ID: " + traderId));

        if (getBidByTraderId(traderId, auctionId) != null) {
            throw new IllegalArgumentException("Each trader can place only one bid per auction.");
        }

        bid.setBidTime(java.time.LocalDateTime.now());
        bid.setBidder(trader);
        bid.setAuction(auction);
        bid.setBidStatus("pending");

        bidRepository.save(bid);
        return "Bid has been added successfully";
    }

    public void updateBid(Long bidId, Double price) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Price must be a positive value.");
        }

        Bid bid = bidRepository.findById(bidId).orElseThrow(() -> new NoSuchElementException("Bid not found for ID: " + bidId));

        bid.setBidAmount(price);
        bidRepository.save(bid);
    }
}

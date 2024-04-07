package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.auction.DTOModels.BidDTO;
import com.example.auction.Models.Auction;
import com.example.auction.Models.Bid;
import com.example.auction.Models.User;
import com.example.auction.Repository.AuctionRepository;
import com.example.auction.Repository.BidRepository;
import com.example.auction.Repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private UserRepository userRepository;

    public BidDTO getBidById(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow(() -> new NoSuchElementException("Bid not found for ID: " + bidId));
        return new BidDTO(bid);
    }

    public List<BidDTO> getAllBids(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionId(auctionId);
        return bids.stream().map(BidDTO::new).collect(Collectors.toList());
    }

    public BidDTO getBidByUserId(Long userId,Long auctionId) {

        Bid bid = bidRepository.findByBidderId(userId,auctionId);
        if (bid == null) {
            return null;
        }
        return new BidDTO(bid);
    }
    
    
    public String addBid(Bid bid, Long auctionId, Long userId) {
        if (auctionId == null || userId == null || bid == null) {
            throw new IllegalArgumentException("Auction ID, User ID, and Bid information must not be null.");
        }

        Auction auction = auctionRepository.findById(auctionId).orElseThrow(() -> new NoSuchElementException("Auction not found for ID: " + auctionId));
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found for ID: " + userId));

        if(getBidByUserId(userId, auctionId) != null ){
            throw new IllegalArgumentException("Per user only one bid is allowed.");
        }

        bid.setBidTime(java.time.LocalDateTime.now());
        bid.setBidder(user);
        bid.setAuction(auction);
        bid.setBidStatus("pending");

        bidRepository.save(bid);
        return "Bid is added successfully";
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

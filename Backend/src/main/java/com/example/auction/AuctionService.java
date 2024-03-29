package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Transactional
    public void createAuction(Auction auction) {
        // Additional business logic if needed
        auctionRepository.save(auction);
    }

    @Transactional
    public void addBidToAuction(Long auctionId, Bid bid) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction not found with id: " + auctionId));
        // Additional business logic if needed
        auction.getBids().add(bid);
        bid.setAuction(auction);
        auctionRepository.save(auction);
    }

    @Transactional(readOnly = true)
    public Auction getAuctionById(Long auctionId) {
        return auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction not found with id: " + auctionId));
    }

    @Transactional(readOnly = true)
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    // Other methods related to auction business logic can be added here
}

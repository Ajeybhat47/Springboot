package com.example.auction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.auction.DTOModels.BidDTO;
import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.User;
import com.example.auction.Service.UserService;
import com.example.auction.Models.Auction;
import com.example.auction.Repository.AuctionRepository;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private BidService bidService;
    
    @Autowired
    private UserService UserService;

    @Transactional
    public void createAuction(Auction auction) {
        // Additional business logic if needed
        auctionRepository.save(auction);
    }

    // Other methods related to auction business logic can be added here

    public UserDTO getWinner(Long auctionId) {
        Auction auction = auctionRepository.findById(auctionId).orElse(null);

        if (auction == null) {
            System.out.println("No auction found with id: " + auctionId);
            return null;
        }

        if(auction.getWinner() == null)
        {
            Long winnerId = findWinner(auctionId);
            User winner = UserService.getUserById(winnerId);

            auction.setWinner(winner);
            auctionRepository.save(auction);
        }

        return new UserDTO(auction.getWinner().getUserId(), auction.getWinner().getUsername(), auction.getWinner().getEmail(),auction.getWinner().getRole());
        
    }

    public Long findWinner(Long auctionId) {
        List<BidDTO> bids = bidService.getBidsForAuction(auctionId);

        if (bids.isEmpty()) {
            System.out.println("No bids found for auction with id: " + auctionId);
            return null;
        }

        Long winnerId = null;
        double maxamt = 0;

        for (BidDTO bid : bids) {
            if (bid.getBidAmount() > maxamt) {
                maxamt = bid.getBidAmount();
                winnerId = bid.getBidderId();
            }
        }

        return winnerId;

    }
}

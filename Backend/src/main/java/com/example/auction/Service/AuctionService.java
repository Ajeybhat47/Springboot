package com.example.auction.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.auction.DTOModels.AuctionDTO;
import com.example.auction.DTOModels.BidDTO;
import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.Auction;
import com.example.auction.Models.Item;
import com.example.auction.Models.User;
import com.example.auction.Repository.AuctionRepository;

@Service
public class AuctionService 
{

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BidService bidService;

    @Autowired
    private UserService userService;

    @Transactional
    public String createAuction(Auction auction, Long itemId) {
        // Fetch item from database using provided itemId
        Item item = itemService.getItemById(itemId);

        if (item == null) {
            return "Item with ID " + itemId + " not found";
        }

        // Associate the item with the auction
        auction.setItem(item);

        auctionRepository.save(auction);
        return "Auction created successfully";
    }

    public List<AuctionDTO> getAllAuctions() {
        List<Auction> auctions = auctionRepository.findAll();
        
        return auctions.stream().map(AuctionDTO::mapEntityToDto).collect(Collectors.toList());
    }

    public List<AuctionDTO> getAllAuctionsByStatus(String status) {

        List<Auction> auctions = auctionRepository.findAllByStatus(status);
        return auctions.stream().map(AuctionDTO::mapEntityToDto).collect(Collectors.toList());

    }



    public List<BidDTO> getAllBids(Long auctionId) {
        Auction auction = auctionRepository.findById(auctionId).orElse(null);
        if (auction == null) {
            throw new IllegalArgumentException("Auction not found with ID: " + auctionId);
        }
        return bidService.getBidsForAuction(auctionId);
    }




    public UserDTO getWinner(Long auctionId) 
    {
        Auction auction = auctionRepository.findById(auctionId).orElse(null);

        if (auction == null) {
            throw new IllegalArgumentException("Auction not found with ID: " + auctionId);
        }

        // Implementation to find the winner
        if(auction.getWinner() != null) {
            return UserDTO.mapEntityToDto(auction.getWinner());
        }
        else
        {
            Long winnerId = findWinner(auctionId);

            if (winnerId == null) {
                throw new IllegalArgumentException("Auction not found with ID: " + auctionId);   
            }

            User winner = userService.getUserById(winnerId);

            if (winner == null) {
                return null;
            
            
            }
            return UserDTO.mapEntityToDto(winner);
        }
    }
    // Method to find the winner, you can implement your logic here
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

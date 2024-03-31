package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired 
    private UserRepository userRepository;

    public void createBid(Bid bid) {
        if(bid != null)
            bidRepository.save(bid);
        else
            System.out.println("Bid is null");
    }


    public List<Bid> getBidsForAuction(Long auctionId) {
        return bidRepository.findByAuctionId(auctionId);
    } 
    

    public String addBid(Bid bid,Long auctionId,Long userId)
    {
        if(auctionId !=null && userId != null && bid !=null)
        {
            Auction auction = auctionRepository.getReferenceById(auctionId);
            User user = userRepository.getReferenceById(userId);
            bid.setBidder(user);
            bid.setAuction(auction);
            
            bidRepository.save(bid);
            return "Done";
        }
        else{
            return "error";
        }
        
       
        
    }
    
}

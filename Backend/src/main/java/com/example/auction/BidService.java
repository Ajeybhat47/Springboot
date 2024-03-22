package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    public void createBid(Bid bid) {
        if(bid != null)
            bidRepository.save(bid);
        else
            System.out.println("Bid is null");
    }
    
}

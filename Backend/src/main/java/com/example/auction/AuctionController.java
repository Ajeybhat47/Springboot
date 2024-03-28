package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;
    @Autowired
    private UserService userService;
    @Autowired
    private BidService bidService;

    public void createAuction(Auction auction) {
        auctionService.createAuction(auction);
    }

    public void addBidToAuction(int auctionId, Bid bid) {
        auctionService.addBidToAuction(auctionId, bid);
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public void createBid(Bid bid) {
        bidService.createBid(bid);
    }
}

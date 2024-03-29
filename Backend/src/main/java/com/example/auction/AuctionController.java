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

    @PostMapping("/createAuction")
    public void createAuction(@RequestBody Auction auction) {
        auctionService.createAuction(auction);
    }

    @PostMapping("/addBidToAuction/{auctionId}")
    public void addBidToAuction(@PathVariable("auctionId") Long auctionId, @RequestBody Bid bid) {
        auctionService.addBidToAuction(auctionId, bid);
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/createBid")
    public void createBid(@RequestBody Bid bid) {
        bidService.createBid(bid);
    }
}

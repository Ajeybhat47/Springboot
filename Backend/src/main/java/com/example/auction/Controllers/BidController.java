package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.Models.Bid;
import com.example.auction.Service.BidService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/bid")
public class BidController {
    
    @Autowired
    private BidService bidService;
    
    
    public void createBid(Bid bid) {
        bidService.createBid(bid);
    }
    

    @PostMapping("/addBid")
    public ResponseEntity<String> postMethodName(@RequestBody Bid bid , @RequestParam("auctionId") Long auctionId,@RequestParam("userId") Long userId) {

        bidService.addBid(bid,auctionId,userId);
        
        return ResponseEntity.ok("Bid is added successfully");
    }
    
}

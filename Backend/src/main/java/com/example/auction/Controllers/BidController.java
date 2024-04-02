package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.DTOModels.BidDTO;
import com.example.auction.Models.Bid;
import com.example.auction.Service.BidService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/bid")
public class BidController {
    
    @Autowired
    private BidService bidService;
    
    @GetMapping("getBidById")
    public ResponseEntity<BidDTO> getBidById(@RequestParam("bidId") Long bidId) {
        BidDTO bid = bidService.getBidById(bidId);
        return ResponseEntity.ok(bid);
    }


    @PostMapping("/addBid")
    public ResponseEntity<String> postMethodName(@RequestBody Bid bid , @RequestParam("auctionId") Long auctionId,@RequestParam("userId") Long userId) {

        bidService.addBid(bid,auctionId,userId);
        
        return ResponseEntity.ok("Bid is added successfully");
    }
    
    // recive bidId and updated bid price
    @PutMapping("/updateBid")
    public ResponseEntity<String> updateBid(@RequestParam("bidId") Long bidId, @RequestParam("price") Double price) {
        bidService.updateBid(bidId, price);
        return ResponseEntity.ok("Bid is updated successfully");
    }
}

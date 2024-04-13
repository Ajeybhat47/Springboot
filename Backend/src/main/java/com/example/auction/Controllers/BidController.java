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
    
    @PostMapping("/addBid")
    public ResponseEntity<?> addBid(@RequestBody Bid bid, @RequestParam("auctionId") Long auctionId, @RequestParam("traderId") Long traderId) {
        try {
            String result = bidService.addBid(bid, auctionId, traderId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getBidByTraderId")
    public ResponseEntity<?> getBidByTraderId(@RequestParam("traderId") Long traderId, @RequestParam("auctionId") Long auctionId) {
        BidDTO bid = bidService.getBidByTraderId(traderId, auctionId);
        if (bid != null) {
            return ResponseEntity.ok(bid);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateBid")
    public ResponseEntity<?> updateBid(@RequestParam("bidId") Long bidId, @RequestParam("price") Double price) {
        try {
            bidService.updateBid(bidId, price);
            return ResponseEntity.ok("Bid updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

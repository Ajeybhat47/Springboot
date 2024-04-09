package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auction.DTOModels.AuctionDTO;
import com.example.auction.DTOModels.BidDTO;
import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.Auction;
import com.example.auction.Service.AuctionService;

import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @PostMapping("/createAuction")
    public ResponseEntity<?> createAuction(@RequestBody Auction auction, @RequestParam("itemId") Long itemId) {
        try {
            String result = auctionService.createAuction(auction, itemId);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create auction: " + e.getMessage());
        }
    }

    @GetMapping("/{auctionId}/getAllBids")
    public ResponseEntity<?> getAllBids(@PathVariable Long auctionId) {
        try {
            List<BidDTO> bids = auctionService.getAllBids(auctionId);
            return ResponseEntity.ok(bids);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve bids: " + e.getMessage());
        }
    }

    @GetMapping("/getAllActiveAuctions")
    public ResponseEntity<?> getAllActiveAuctions() {
        try {
            List<AuctionDTO> auctions = auctionService.getAllAuctionsByStatus("active");
            return ResponseEntity.ok(auctions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve active auctions: " + e.getMessage());
        }
    }

    @GetMapping("/getAllAuctions")
    public ResponseEntity<?> getAllAuctions() {
        try {
            List<AuctionDTO> auctions = auctionService.getAllAuctions();
            return ResponseEntity.ok(auctions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve auctions: " + e.getMessage());
        }
    }

    @GetMapping("/getAllClosedAuctions")
    public ResponseEntity<?> getAllClosedAuctions() {
        try {
            List<AuctionDTO> auctions = auctionService.getAllAuctionsByStatus("closed");
            return ResponseEntity.ok(auctions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve closed auctions: " + e.getMessage());
        }
    }

    @PostMapping("/closeAuction")
    public ResponseEntity<?> closeAuction(@RequestParam Long auctionId) {
        try {
            String result = auctionService.closeAuction(auctionId);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to close auction: " + e.getMessage());
        }
    }

    @GetMapping("/{auctionId}/getWinner")
    public ResponseEntity<?> getWinner(@PathVariable Long auctionId) {
        try {
            UserDTO winner = auctionService.getWinner(auctionId);
            if (winner != null) {
                return ResponseEntity.ok(winner);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Winner not found for auction with ID " + auctionId);
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve winner: " + e.getMessage());
        }
    }
}

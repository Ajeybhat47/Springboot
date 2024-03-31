package com.example.auction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.Auction;


public interface AuctionRepository extends JpaRepository<Auction, Long> {
    
}

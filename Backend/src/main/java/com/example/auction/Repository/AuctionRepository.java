package com.example.auction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.auction.Models.Auction;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    // Find all auctions by status
    @Query("SELECT a FROM Auction a WHERE a.status = ?1")
    List<Auction> findAllByStatus(String status);

}

package com.example.auction;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BidRepository extends JpaRepository<Bid, Long> {

    @Query("SELECT b FROM Bid b WHERE b.auction.auctionId = :auctionId")
    List<Bid> findByAuctionId(Long auctionId);

}

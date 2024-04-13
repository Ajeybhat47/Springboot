package com.example.auction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.Trader;

public interface TraderRepository extends JpaRepository<Trader, Long> {

}

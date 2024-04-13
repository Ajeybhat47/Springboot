package com.example.auction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
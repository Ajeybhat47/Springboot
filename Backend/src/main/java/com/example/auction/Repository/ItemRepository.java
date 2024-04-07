package com.example.auction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
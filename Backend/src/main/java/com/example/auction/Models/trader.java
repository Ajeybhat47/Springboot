package com.example.auction.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "trader")
@PrimaryKeyJoinColumn(name = "user_id")
public class trader extends User {
    // Additional attributes specific to Bidder can be added here
}

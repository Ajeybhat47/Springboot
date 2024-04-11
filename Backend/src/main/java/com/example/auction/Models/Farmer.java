package com.example.auction.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmer")
@PrimaryKeyJoinColumn(name = "user_id")
public class Farmer extends User {
    // Additional attributes specific to Farmer can be added here
}


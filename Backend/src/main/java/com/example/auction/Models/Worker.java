package com.example.auction.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "worker")
@PrimaryKeyJoinColumn(name = "user_id")
public class Worker extends User {
    // Additional attributes specific to Worker can be added here
}
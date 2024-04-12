package com.example.auction.Repository;
// UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.User;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

package com.example.auction.Repository;
// UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

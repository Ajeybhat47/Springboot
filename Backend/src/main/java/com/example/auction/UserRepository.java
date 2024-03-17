package com.example.auction;
// UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.user_id = :val")
    public User Custom(@Param("val") Long id);

    @Query("SELECT u FROM User u WHERE u.email = :val")
    public User fetchByemail(@Param("val") String email);

}

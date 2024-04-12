package com.example.auction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.Models.Notification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser_UserId(Long userId);
}
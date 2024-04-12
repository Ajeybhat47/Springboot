package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auction.Models.Notification;
import com.example.auction.Service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}/getNotifications")
    public ResponseEntity<List<Notification>> getNotificationsForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationsForUser(userId));
    }

    @GetMapping("/getAllNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @PostMapping("/createNotification")
    public ResponseEntity<String> createNotification(@RequestBody Notification notification) {
        notificationService.createNotification(notification);
        return ResponseEntity.ok("Notification created successfully");
    }

    @DeleteMapping("/{id}/deleteNotification")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Notification deleted successfully");
    }

    @GetMapping("/{id}/getNotification")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }

    @DeleteMapping("/{userId}/deleteAllNotifications")
    public ResponseEntity<String> deleteAllNotificationsForUser(@PathVariable Long userId) {
        notificationService.deleteAllNotificationsForUser(userId);
        return ResponseEntity.ok("All notifications deleted successfully");
    }

    @DeleteMapping("/deleteAllNotifications")
    public ResponseEntity<String> deleteAllNotifications() {
        notificationService.deleteAllNotifications();
        return ResponseEntity.ok("All notifications deleted successfully");
    }



}

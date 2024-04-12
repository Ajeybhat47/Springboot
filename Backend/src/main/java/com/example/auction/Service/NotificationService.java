package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auction.Models.Notification;
import com.example.auction.Repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService{

    @Autowired

    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsForUser(Long userId) {
        return notificationRepository.findByUser_UserId(userId);
    }
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id){
        notificationRepository.deleteById(id);
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public void deleteAllNotificationsForUser(Long userId) {
        List<Notification> notifications = notificationRepository.findByUser_UserId(userId);
        for (Notification notification : notifications) {
            notificationRepository.deleteById(notification.getNotificationId());
        }
    }

    public void deleteAllNotifications() {
        notificationRepository.deleteAll();
    }


}
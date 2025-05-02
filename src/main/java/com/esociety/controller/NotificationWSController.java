package com.esociety.controller;

import com.esociety.model.Notification;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class NotificationWSController {
    @MessageMapping("/send-notification")
    @SendTo("/topic/notifications")
    public Notification sendNotification(Notification notification) {
        notification.setTimestamp(LocalDateTime.now());
        return notification;
    }
}

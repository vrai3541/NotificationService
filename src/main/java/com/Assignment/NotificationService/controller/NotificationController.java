package com.Assignment.NotificationService.controller;

import com.Assignment.NotificationService.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @PostMapping("/user")
    public void add(@RequestBody MultipartFile file,Long userId){

        notificationService.ProcessDataAndSendNotification(file,userId);
    }
}

package com.Assignment.NotificationService.controller;


import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.dto.BasicResponse;
import com.Assignment.NotificationService.entity.NotificationPlans;
import com.Assignment.NotificationService.entity.Recipients;
import com.Assignment.NotificationService.entity.Subscription;
import com.Assignment.NotificationService.entity.Users;
import com.Assignment.NotificationService.service.DataFeeder;
import com.Assignment.NotificationService.service.notification.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    private
    UserRepository userRepository;

    @Autowired
    DataFeeder dataFeeder;

    @Autowired
    private
    SubscriptionService subscriptionService;


    @GetMapping(value = "/")
    public ResponseEntity<?> get() {

        dataFeeder.feedData();
        return ResponseEntity.ok(new BasicResponse("Welcome to Notification service"));

    }

    @PostMapping(value = "/subscribe/{userid}")
    public ResponseEntity<?> subscribeUser(@PathVariable Long userid, @RequestBody String plan) {

        Users user = userRepository.findById(userid).get();
        subscriptionService.subscribePlan(user, plan);

        return ResponseEntity.ok(new BasicResponse(""));
    }


}

package com.Assignment.NotificationService.controller;


import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.dto.BasicResponse;
import com.Assignment.NotificationService.entity.NotificationPlans;
import com.Assignment.NotificationService.entity.Recipients;
import com.Assignment.NotificationService.entity.Subscription;
import com.Assignment.NotificationService.entity.Users;
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
    private
    SubscriptionService subscriptionService;


    @GetMapping(value = "/")
    public ResponseEntity<?> get() {

        loadInitialDatatoDataBase();
        return ResponseEntity.ok(new BasicResponse("Welcome to Notification service"));

    }

    @PostMapping(value = "/subscribe/{userid}")
    public ResponseEntity<?> subscribeUser(@PathVariable Long userid, @RequestBody String plan) {

        Users user = userRepository.findById(userid).get();
        subscriptionService.subscribePlan(user, plan);

        return ResponseEntity.ok(new BasicResponse(""));
    }


    private void loadInitialDatatoDataBase() {


        List<Recipients> recipients = new ArrayList<>();

        Subscription subscription = new Subscription();

        subscription.setSubscriptionStatus("Active");
        subscription.setSubscriptionDate(LocalDateTime.now());
        subscription.setUserId(0);
        subscription.setSubscriptionType(NotificationPlans.Platinum);
        subscription.setNotificationCount(0L);

        Users myUser = new Users();

        myUser.setSubscription(subscription);
        myUser.setClientName("varun");
        myUser.setEmailId("varunB270@gmail.com");
        myUser.setPhoneNumber("9811525780");
        myUser.setRecipients(recipients);
        userRepository.save(myUser);

        Users myUser1 = new Users();

        myUser1.setSubscription(subscription);
        myUser1.setClientName("bansal");
        myUser1.setEmailId("varunB270123@gmail.com");
        myUser1.setPhoneNumber("983425356666");
        myUser1.setRecipients(recipients);
        userRepository.save(myUser1);

        Users myUser2 = new Users();

        myUser2.setSubscription(subscription);
        myUser2.setClientName("varun");
        myUser2.setEmailId("varunBfeeeeeff@gmail.com");
        myUser2.setPhoneNumber("34848348034804");
        myUser2.setRecipients(recipients);
        userRepository.save(myUser2);

        System.out.println("User saved " + myUser.getRecipients());

    }

}

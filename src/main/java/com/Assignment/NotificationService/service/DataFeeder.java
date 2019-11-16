package com.Assignment.NotificationService.service;


import com.Assignment.NotificationService.dao.RecipientRepository;
import com.Assignment.NotificationService.dao.SubscriptionRepository;
import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.entity.Recipients;
import com.Assignment.NotificationService.entity.Subscription;
import com.Assignment.NotificationService.entity.Users;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.Assignment.NotificationService.entity.NotificationPlans.*;


@Service
public class DataFeeder {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    RecipientRepository recipientRepository;



public void feedData(){

    Subscription subscription1 =new Subscription();
    subscription1.setNotificationCount(0L);
    subscription1.setSubscriptionType(Gold);
    subscription1.setUserId(0L);
    subscription1.setSubscriptionDate(LocalDateTime.now());
    subscription1.setSubscriptionStatus("Active");

    List<Recipients> recipients =new ArrayList<>();

    Users user1 =new Users();
    user1.setRecipients(recipients);
    user1.setPhoneNumber("9822445676");
    user1.setEmailId("user1@gmail.com");
    user1.setSubscription(subscription1);
    user1.setClientName("user1");

    userRepository.save(user1);

    Users user2 =new Users();
    user2.setRecipients(recipients);
    user2.setPhoneNumber("9822445676");
    user2.setEmailId("user2@gmail.com");
    user2.setSubscription(subscription1);
    user2.setClientName("user2");

    userRepository.save(user2);

    Users user3 =new Users();
    user3.setRecipients(recipients);
    user3.setPhoneNumber("9822445676");
    user3.setEmailId("user3@gmail.com");
    user3.setSubscription(subscription1);
    user3.setClientName("user3");

    userRepository.save(user3);

    Users user4 =new Users();
    user4.setRecipients(recipients);
    user4.setPhoneNumber("9822445676");
    user4.setEmailId("user4@gmail.com");
    user4.setSubscription(subscription1);
    user4.setClientName("user4");

    userRepository.save(user4);

    Users user5 =new Users();
    user5.setRecipients(recipients);
    user5.setPhoneNumber("9822445676");
    user5.setEmailId("user5@gmail.com");
    user5.setSubscription(subscription1);
    user5.setClientName("user5");

    userRepository.save(user5);

    Users user6 =new Users();
    user6.setRecipients(recipients);
    user6.setPhoneNumber("9822445676");
    user6.setEmailId("user6@gmail.com");
    user6.setSubscription(subscription1);
    user6.setClientName("user6");

    userRepository.save(user6);

    Users user7 =new Users();
    user7.setRecipients(recipients);
    user7.setPhoneNumber("9822445676");
    user7.setEmailId("user7@gmail.com");
    user7.setSubscription(subscription1);
    user7.setClientName("user7");

    userRepository.save(user7);

    List<Users> users =userRepository.findAll();

    for (Users user:users
         ) {

        Subscription subscription =new Subscription();

        subscription.setSubscriptionStatus("Active");
        subscription.setUserId(user.getId());
        subscription.setSubscriptionDate(LocalDateTime.now());
        subscription.setNotificationCount(0L);
        subscription.setSubscriptionType(Silver);

        user.setSubscription(subscription);

        Recipients recipients1=new Recipients();

        recipients1.setUsers(user);
        recipients1.setName(user.getClientName()+"  Recipient");
        recipients1.setPhoneNumber("93244849444");
        recipients1.setPushToken(user.getEmailId()+"3455657#####");
        recipients1.setEmailId(user.getClientName()+"Recipient@gmail.com");
        recipients.add(recipients1);

        user.setRecipients(recipients);
        userRepository.save(user);
    }


    }


}





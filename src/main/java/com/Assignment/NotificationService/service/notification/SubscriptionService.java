package com.Assignment.NotificationService.service.notification;

import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.entity.NotificationPlans;
import com.Assignment.NotificationService.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.Assignment.NotificationService.entity.NotificationPlans.*;

@Service
public class SubscriptionService {

    @Autowired
    UserRepository userRepository;

    public void subscribePlan(Users user, String plan)
    {
        if(plan.equals(Platinum.name()))
            user.getSubscription().setSubscriptionType(Platinum);
        else if(plan.equals(Gold.name()))
            user.getSubscription().setSubscriptionType(Gold);
        else
            user.getSubscription().setSubscriptionType(Silver);

        user.getSubscription().setSubscriptionStatus("Active");
        user.getSubscription().setSubscriptionDate(LocalDateTime.now());

        userRepository.save(user);
        System.out.println("user subscribed  "+plan +"Plan");


    }
}

package com.Assignment.NotificationService.service.notification;

import com.Assignment.NotificationService.dao.SubscriptionRepository;
import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.entity.NotificationPlans;
import com.Assignment.NotificationService.entity.Subscription;
import com.Assignment.NotificationService.entity.Users;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.Assignment.NotificationService.entity.NotificationPlans.*;

@Service
public class SubscriptionService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

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
    @Scheduled(cron = "0 0 24 * * ?")
    private void refreshMessageLimit(){

        System.out.println("Renewing message limit");

        List<Subscription> subscriptions =subscriptionRepository.findAll();

        for (Subscription subscription:
             subscriptions) {

            subscription.setNotificationCount(0L);

            subscriptionRepository.save(subscription);

        }



    }

}

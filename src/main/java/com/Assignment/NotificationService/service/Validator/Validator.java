package com.Assignment.NotificationService.service.Validator;

import com.Assignment.NotificationService.entity.Users;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Validator {

    public boolean validateUserPlan(Users user) {


        if (user.getSubscription().getSubscriptionDate().compareTo(LocalDateTime.now()) >= 0) {
            return false;

        } else if (user.getSubscription().getNotificationCount() >= user.getSubscription().getSubscriptionType().getLimit()) {
            return false;
        } else return user.getSubscription().getSubscriptionStatus().equals("Expired");
    }


}

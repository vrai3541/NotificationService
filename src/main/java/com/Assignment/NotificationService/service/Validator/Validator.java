package com.Assignment.NotificationService.service.Validator;

import com.Assignment.NotificationService.dto.BasicResponse;
import com.Assignment.NotificationService.entity.NotificationPlans;
import com.Assignment.NotificationService.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Validator {

    public ResponseEntity<?> validateUserPlan(Users user) {


        if (user.getSubscription().getSubscriptionDate().compareTo(LocalDateTime.now()) >= 0) {

            return ResponseEntity.ok(new BasicResponse("Subscription Expired Please renew"));


        } else if (!user.getSubscription().getSubscriptionType().equals(NotificationPlans.Platinum) &&  user.getSubscription().getNotificationCount() >= user.getSubscription().getSubscriptionType().getLimit()) {
              return ResponseEntity.ok(new BasicResponse("You have completed your limit please try tomorrow or upgrade plan"));

        } else if(user.getSubscription().getSubscriptionStatus().equals("Expired")){

              return ResponseEntity.ok(new BasicResponse("Subscription Expired Please renew"));

        }
        else{

            return ResponseEntity.ok(true);
        }
    }


}

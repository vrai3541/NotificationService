package com.Assignment.NotificationService.service.Validator;

import com.Assignment.NotificationService.dto.Notification;
import com.Assignment.NotificationService.entity.Subscription;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public Notification validate(Notification notification){

        Subscription currentSubscription=notification.users.getSubscription();

        //return  new Notification(notification.users,notification.dailyNotificationCount,notification.)


    }

    public boolean canSendNotification(Notification notification){
        return notification.dailyNotificationCount < 100000;
    }

}

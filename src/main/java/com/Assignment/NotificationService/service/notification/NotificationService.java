package com.Assignment.NotificationService.service.notification;

import ch.qos.logback.core.util.FixedDelay;
import com.Assignment.NotificationService.dao.NotificationQueueRepository;
import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.dto.Notification;
import com.Assignment.NotificationService.entity.*;
import com.Assignment.NotificationService.service.notificationSender.EmailSender;
import com.Assignment.NotificationService.service.notificationSender.PushSender;
import com.Assignment.NotificationService.service.notificationSender.SmsSender;
import lombok.Data;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class NotificationService {


    @Autowired
    NotificationQueueRepository notificationQueueRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailSender emailSender;

    @Autowired
    PushSender pushSender;

    @Autowired
    SmsSender smsSender;

    public void createAndProcessNotification(Users user, String message) {

        List<Recipients> recipients = user.getRecipients();

        NotificationPlans plans = user.getSubscription().getSubscriptionType();

        recipients.forEach(recipient ->
                notify(createNotification(recipient, message), user, plans)
        );
    }

    private Notification createNotification(Recipients recipient, String message) {

        Notification notification = new Notification();

        notification.setRecepientEmail(recipient.getEmailId());
        notification.setNotificationMessage(message);
        notification.setRecepientNumber(recipient.getPhoneNumber());
        notification.setRecepientPushToken(recipient.getPushToken());
        notification.setStatus("New");
        notification.setRecepientName(recipient.getName());
        notification.setUserId(recipient.getUsers().getId());

        return notification;
    }


    private void notify(Notification notification, Users user, NotificationPlans plans) {

        switch (plans) {
            case Gold: {

                emailSender.sendNotification(notification);
                smsSender.sendNotification(notification);
                pushSender.sendNotification(notification);

            }

            case Platinum: {

                emailSender.sendNotification(notification);
                smsSender.sendNotification(notification);
                pushSender.sendNotification(notification);
            }

            case Silver: {

                emailSender.sendNotification(notification);
                smsSender.sendNotification(notification);
                pushSender.sendNotification(notification);

            }


        }

        updateNotificationCount(user);
    }

    private void updateNotificationCount(Users user) {

        Subscription subscription = user.getSubscription();

        subscription.setNotificationCount(subscription.getNotificationCount() + 1);

        user.setSubscription(subscription);
        userRepository.save(user);

    }

@Scheduled(fixedDelay=100)
    public void retryFailedMessages(){

        List<FailedNotificationQueue> failedMessages=notificationQueueRepository.findAll();

        List<FailedNotificationQueue> filteredFailedMessages=   failedMessages.stream().filter(message-> message.getRetryCount()<3).collect(Collectors.toList());

    for (FailedNotificationQueue message:filteredFailedMessages) {

        Users user =userRepository.findById(message.getId()).get();

        Recipients recipient=new Recipients();

        recipient.setPushToken(message.getRecipientPushToken());
        recipient.setPhoneNumber(message.getRecipientPhone());
        recipient.setName("");
        recipient.setUsers(user);

        Notification newNotification=createNotification(recipient,message.getMessage());
       String type =message.getNotificationType();
       switch (type){

           case "Email":{

               emailSender.sendNotification(newNotification);

           }
           case "Push":{

               pushSender.sendNotification(newNotification);

           } case "Sms":{

               smsSender.sendNotification(newNotification);

           }

       }



    }


    }

}

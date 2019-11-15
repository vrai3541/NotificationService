package com.Assignment.NotificationService.service.notificationSender;

import com.Assignment.NotificationService.dao.NotificationArchivesRepository;
import com.Assignment.NotificationService.dao.NotificationQueueRepository;
import com.Assignment.NotificationService.dto.Notification;
import com.Assignment.NotificationService.entity.FailedNotificationQueue;
import com.Assignment.NotificationService.entity.NotificationArchives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailSender implements NotificationSender{

    @Autowired
    NotificationQueueRepository notificationQueueRepository;

    @Autowired
    NotificationArchivesRepository notificationArchivesRepository;


    @Override
    public String sendNotification(Notification notification) {

        if(notification.getRecepientEmail()==null){

            queueFailedMessageForRetry(notification);


        }


        System.out.println("New Email"+notification.getRecepientEmail()+""+notification.getNotificationMessage());
        saveIntoNotificationArchive(notification);
        return "Success";
    }

    @Override
    public void queueFailedMessageForRetry(Notification notification) {

        FailedNotificationQueue notificationQueueMessage =new FailedNotificationQueue();

        notificationQueueMessage.setMessage(notification.getNotificationMessage());
        notificationQueueMessage.setMessageSentDate(LocalDateTime.now());
        notificationQueueMessage.setNotificationStatus("Failed");
        notificationQueueMessage.setRetryCount(notification.getRetryCount()+1);
        notificationQueueMessage.setRecipientEmail(notification.getRecepientEmail());
        notificationQueueMessage.setRecipientPhone(notification.getRecepientNumber());
        notificationQueueMessage.setRecipientPushToken(notification.getRecepientPushToken());
        notificationQueueMessage.setNotificationType("Email");

        notificationQueueRepository.save(notificationQueueMessage);


    }

    @Override
    public void saveIntoNotificationArchive(Notification notification) {

        NotificationArchives notificationArchives =new NotificationArchives();
        notificationArchives.setMessage(notification.getNotificationMessage());
        notificationArchives.setNotificationType("Email");
        notificationArchives.setRecipientEmail(notification.getRecepientEmail());
        notificationArchives.setRecipientPhone(notification.getRecepientNumber());
        notificationArchives.setRecipientPushToken(notification.getRecepientPushToken());
        notificationArchives.setUserId(notification.getUserId().toString());
        notificationArchives.setSentDate(LocalDateTime.now());

        notificationArchivesRepository.save(notificationArchives);
    }

}

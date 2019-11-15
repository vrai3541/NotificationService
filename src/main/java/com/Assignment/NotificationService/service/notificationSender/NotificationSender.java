package com.Assignment.NotificationService.service.notificationSender;

import com.Assignment.NotificationService.dto.Notification;

public interface NotificationSender {

    public String sendNotification(Notification notification);

    public void queueFailedMessageForRetry(Notification notification);

    public void  saveIntoNotificationArchive(Notification notification);
}

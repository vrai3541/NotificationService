package com.Assignment.NotificationService.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
public class FailedNotificationQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String recipientEmail;

    private  String recipientPhone;

    private  String recipientPushToken;

    private  String message;

    private LocalDateTime messageSentDate;

    private  String NotificationStatus;

    private  int RetryCount;

    private String notificationType;

}

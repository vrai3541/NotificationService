package com.Assignment.NotificationService.dto;


import com.Assignment.NotificationService.entity.NotificationData;
import com.Assignment.NotificationService.entity.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Notification {


    private String notificationMessage;
    private String recepientName;
    private String recepientEmail;
    private String recepientNumber;
    private String recepientPushToken ="";
    private String Status="New";
    private int retryCount=0;
    private Date sentDate=new Date();
    private Long userId;

}

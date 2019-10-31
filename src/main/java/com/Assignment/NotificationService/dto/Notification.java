package com.Assignment.NotificationService.dto;


import com.Assignment.NotificationService.entity.NotificationData;
import com.Assignment.NotificationService.entity.Users;
import lombok.Data;

import java.util.List;

@Data
public class Notification {

    public Users users;
    public List<NotificationData> notificationData;
    public  boolean isSmsEnabled =false;
    public  boolean isEmailEnabled =false;
    public  boolean isPushEnabled =false;

    public  long dailyNotificationCount =0;




}

package com.Assignment.NotificationService.entity;


import lombok.Data;

import javax.persistence.*;

@Data
public class NotificationData {

   private String notificationMessage;
    private String recepientName;
    private String recepientEmail;
    private String recepientNumber;
    private String recepientPushToken ="";

}

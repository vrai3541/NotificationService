package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Subscription {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer userId;

    private NotificationPlans subscriptionType;

    private String SubscriptionStatus;

    private Long NotificationCount;

    private LocalDateTime subscriptionDate;



}

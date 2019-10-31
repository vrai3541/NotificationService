package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Data
public class Subscription {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer userId;

    private NotificationServicePlan plan;

    private Date validUpto;


}

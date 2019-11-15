package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Data
@Entity
public class NotificationArchives {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

private String message;

private String notificationType;

private  String userId;

private LocalDateTime sentDate;

private String recipientEmail=" ";

private  String recipientPhone=" ";

private String recipientPushToken=" ";

}

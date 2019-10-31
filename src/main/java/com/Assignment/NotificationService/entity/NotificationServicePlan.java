package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class NotificationServicePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String planType;

    private String planCost;

    private boolean isEmailSupport;

    private boolean isSmsSupport;

    private boolean isPushSupport;

    private Long limit;

}

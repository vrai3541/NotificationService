package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientName;

    private String emailId;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="recepient")
    private List<NotificationData> recepientsList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Subscription subscription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private DailyCount dailyCount;


}

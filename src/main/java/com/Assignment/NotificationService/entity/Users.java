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

    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "users")
    private List<Recipients> recipients;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL)
    private  Subscription subscription;

}

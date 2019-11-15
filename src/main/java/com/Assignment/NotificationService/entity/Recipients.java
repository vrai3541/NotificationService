package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recipients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String phoneNumber;

    private String emailId;

    private String pushToken;

    @ManyToOne
    @JoinColumn(name = "users_fk")
    private Users users;


}

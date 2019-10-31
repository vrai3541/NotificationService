package com.Assignment.NotificationService.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Recepient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  String email;
    private String phoneNumber;
    private String pushToken;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private  Users user;

}

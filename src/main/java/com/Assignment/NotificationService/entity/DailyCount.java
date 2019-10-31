package com.Assignment.NotificationService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class DailyCount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long todayCount;

    private Date todayDate;

    private  long userID;


}

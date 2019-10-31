package com.Assignment.NotificationService.service.notification;

import com.Assignment.NotificationService.dao.DailyCountRepository;
import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.dto.Notification;
import com.Assignment.NotificationService.entity.*;
import com.Assignment.NotificationService.util.CsvParser;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class NotificationService {

    @Autowired
    CsvParser csvParser;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DailyCountRepository dailyCountRepository;

    void ProcessDataAndSendNotification(MultipartFile file, Long userId){

        List<NotificationData> notificationData = csvParser.getRecepientList(file);
        Optional<Users> user = userRepository.findById(userId);
        DailyCount dailyCount= dailyCountRepository.findOne(userId,new Date());
        NotificationServicePlan subscriptionPlan= user.get().getSubscription().getPlan();
        Notification notification = createNotification(notificationData,subscriptionPlan,user.get(),dailyCount);

    }

    public Notification createNotification(List<NotificationData> notificationData,NotificationServicePlan subscriptionPlan, Users users,DailyCount dailyCount){

        Notification notification =new Notification();
        notification.isEmailEnabled=subscriptionPlan.isEmailSupport();
        notification.isSmsEnabled=subscriptionPlan.isEmailSupport();
        notification.isPushEnabled=subscriptionPlan.isEmailSupport();
        notification.users=users;


        return  new Notification(




        );

    }


}

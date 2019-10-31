package com.Assignment.NotificationService.util;


import com.Assignment.NotificationService.entity.NotificationData;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class CsvParser {
    static List<NotificationData> notificationData = null;
    public List<NotificationData> getRecepientList(MultipartFile file){
        return notificationData;
    }
}

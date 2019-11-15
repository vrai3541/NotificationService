package com.Assignment.NotificationService.controller;

import com.Assignment.NotificationService.dao.UserRepository;
import com.Assignment.NotificationService.dto.BasicResponse;
import com.Assignment.NotificationService.entity.Users;
import com.Assignment.NotificationService.service.Validator.Validator;
import com.Assignment.NotificationService.service.notification.NotificationService;
import javassist.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    Validator validator;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/notify")
    public ResponseEntity<?> sendNotification(@RequestBody Long userId , String message){

        try {


            Users user = userRepository.findById(userId).get();

            if (validator.validateUserPlan(user)) {
                notificationService.createAndProcessNotification(user, message);

                return ResponseEntity.ok(new BasicResponse(""));

            } else {

                return ResponseEntity.ok(new BasicResponse(""));

            }
        } catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
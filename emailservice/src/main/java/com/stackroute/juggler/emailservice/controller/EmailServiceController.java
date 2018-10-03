package com.stackroute.juggler.emailservice.controller;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.emailservice.domain.EmailDetails;
import com.stackroute.juggler.emailservice.service.NotificationService;
import com.stackroute.juggler.rsvp.domain.EventDetails;

@RestController
@RequestMapping("/api/v1/email")
public class EmailServiceController {

    private NotificationService notificationService;
    
    @Autowired
    public EmailServiceController(NotificationService notificationService) {
        super();
        this.notificationService = notificationService;
    }
//    @GetMapping("/getEventDetails")
//    public EventDetails getEventDetails(EventDetails event) {
//        notificationService.getEventDetails(event);
//        return
//        
//    }
//    @PostMapping("/sendEmail")
//    public String sendInvitations(@RequestBody EmailDetails emailDetails)
//            throws MessagingException {
//        System.out.println("controller1");
//        
//        notificationService.sendNotification();
//        System.out.println("controller2");
//        return "Thank you for registering";
//    }

}

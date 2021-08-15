package com.breaktime.backend.controller;


import com.breaktime.backend.dto.UserDataDto;
import com.breaktime.backend.entity.Activity;
import com.breaktime.backend.entity.Interests;
import com.breaktime.backend.entity.User;
import com.breaktime.backend.service.*;
import nl.martijndwars.webpush.Subscription;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    NotificationService NotificationService;

    @Autowired
    UserService UserService;
    @Autowired
    ActivityService ActivityService;
    @Autowired
    CategoryService CategoryService;
    @Autowired
    InterestsService InterestService;


    @RequestMapping(value = "/subscribe",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void newSubscriber(@RequestBody UserDataDto UserDataDto)
    {
        System.out.println(UserDataDto.email);
        System.out.println(UserDataDto.toString());
        Subscription subData = UserDataDto.subscriptionData;
        NotificationService.subscribe(subData);

        JSONObject payload = new JSONObject();
        payload.put("title","Welcome To BreakTime!");
        payload.put("message","This is how I will remind you to take a break.");

        UserService.saveUser(new User(UserDataDto.email,subData.endpoint,subData.keys.p256dh,subData.keys.auth));
        NotificationService.sendNotification(subData,payload.toJSONString());
    }



    @Scheduled(initialDelay = 5000L,fixedDelayString = "PT1H")
    public void sendNotificationsToAll(){
        System.out.println("Executing timed notification");
        List<User> allUsers = UserService.getAllUsers();

        JSONObject payload = new JSONObject();
        for(User usr : allUsers)
        {
            System.out.println(usr.toString());
            Interests random_Interest = InterestService.getRandomInterestForUser(usr.getEmail());
            Activity random_Activity = ActivityService.getRandomActivityForCategory(random_Interest.getCategoryID());
            Subscription sub = UserService.getSubscriptionFromEmail(usr.getEmail());
            payload.put("title","BreakTime Alert");
            payload.put("message",random_Activity.getTask());

            NotificationService.sendNotification(sub,payload.toJSONString());

        }
    }

//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void sendNotification(){
//        NotificationService.sendNotificationstoAll();
//    }


}

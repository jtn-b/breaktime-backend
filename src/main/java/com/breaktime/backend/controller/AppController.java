package com.breaktime.backend.controller;


import com.breaktime.backend.service.NotificationService;
import nl.martijndwars.webpush.Subscription;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AppController {

    @Autowired
    NotificationService NotificationService;

    @RequestMapping(value = "/subscribe",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void newSubscriber(@RequestBody Subscription subscriberData)
    {
        NotificationService.subscribe(subscriberData);

        JSONObject payload = new JSONObject();
        payload.put("title","Take A Break");
        payload.put("message","You might want to a take a few steps.");

        NotificationService.sendNotification(subscriberData,payload.toJSONString());
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void sendNotification(){
        NotificationService.sendNotificationstoAll();
    }

}

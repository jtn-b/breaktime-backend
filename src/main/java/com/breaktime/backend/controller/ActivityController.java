package com.breaktime.backend.controller;

import com.breaktime.backend.entity.Activity;
import com.breaktime.backend.entity.Category;
import com.breaktime.backend.service.ActivityService;
import com.breaktime.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    ActivityService ActivityService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Activity addActivity(@RequestBody Activity Activity){
        return ActivityService.addTask(Activity);
    }

}

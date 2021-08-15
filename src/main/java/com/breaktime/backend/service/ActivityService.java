package com.breaktime.backend.service;

import com.breaktime.backend.entity.Activity;
import com.breaktime.backend.entity.Interests;
import com.breaktime.backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository ActivityRepository;

    @PostConstruct
    public void initDB(){
        ActivityRepository.deleteAll();
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1,"Take a break, try doing 20 keep ups!"));
        activities.add(new Activity(2,"Take a break, meditate for 5 minutes"));
        activities.add(new Activity(3,"Take a break, listen to this rock classic from Led Zeppelin","https://www.youtube.com/watch?v=QkF3oxziUI4"));
        ActivityRepository.saveAll(activities);
    }


    public Activity addTask(Activity activity)
    {
        ActivityRepository.save(activity);
        return activity;
    }

//    public void addTask(int categoryID,String task)
//    {
//        ActivityRepository.save(new Activity(categoryID,task));
//    }
//
//    public void addTaskWithLink(int categoryID,String task,String redirectLink)
//    {
//        ActivityRepository.save(new Activity(categoryID,task,redirectLink));
//    }

    public List<Activity> getTasksForCategory(int categoryID)
    {
        return ActivityRepository.findByCategoryID(categoryID);
    }

    public Activity getRandomActivityForCategory(int categoryID)
    {
        List<Activity> all_activities = getTasksForCategory(categoryID);
        int min = 0;
        int max = all_activities.size()-1;
        int randomIdx = (int)(Math.random()*(max-min+1)+min);
        return all_activities.get(randomIdx);
    }
}

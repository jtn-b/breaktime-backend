package com.breaktime.backend.controller;

import com.breaktime.backend.entity.Interests;
import com.breaktime.backend.service.InterestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interests")

public class InterestsController {

    @Autowired
    InterestsService IntService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Interests> getUserInterests(String email){
        return IntService.getUserInterests(email);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Interests createCategory(@RequestBody Interests Interest){
         IntService.createUserInterest(Interest);
         return Interest;
    }


}

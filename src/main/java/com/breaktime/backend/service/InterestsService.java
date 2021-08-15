package com.breaktime.backend.service;

import com.breaktime.backend.entity.Category;
import com.breaktime.backend.entity.Interests;
import com.breaktime.backend.repository.InterestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class InterestsService {
    @Autowired
    InterestsRepository InterestsRepository;

    @PostConstruct
    public void initDB(){
        List<Interests> interests = new ArrayList<>();
        interests.add(new Interests("jatinbhatnagar05@gmail.com",1));
        interests.add(new Interests("jatinbhatnagar05@gmail.com",2));
        interests.add(new Interests("jatinbhatnagar05@gmail.com",3));
        InterestsRepository.saveAll(interests);

    }


    public List<Interests> getUserInterests(String email)
    {
        return InterestsRepository.findByEmail(email);
    }

    public void createUserInterest(String email,int categoryID)
    {
        InterestsRepository.save(new Interests(email,categoryID));
    }
}

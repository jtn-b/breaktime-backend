package com.breaktime.backend.service;

import com.breaktime.backend.entity.User;
import com.breaktime.backend.repository.UserRepository;
import nl.martijndwars.webpush.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public void saveUser(User user)
    {
        repository.save(user);
    }

    public User getUserByEmail(String email)
    {
        return repository.findByEmail(email);
    }

    public User deleteUserByEmail(String email)
    {
        return repository.deleteByEmail(email);
    }

    public Subscription getSubscriptionFromEmail(String email)
    {
        User usr = getUserByEmail(email);
        Subscription sub = new Subscription();
        sub.endpoint = usr.getEndpoint();
        sub.keys.auth = usr.getAuth();
        sub.keys.p256dh = usr.getP256dh();

        return sub;
    }

}

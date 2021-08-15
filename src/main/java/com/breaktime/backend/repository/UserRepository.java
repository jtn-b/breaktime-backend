package com.breaktime.backend.repository;

import com.breaktime.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    public User findByEmail(String email);
    public User deleteByEmail(String email);
}

package com.breaktime.backend.repository;

import com.breaktime.backend.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestsRepository extends JpaRepository<Interests,Integer> {

    public List<Interests> findByEmail(String email);
}

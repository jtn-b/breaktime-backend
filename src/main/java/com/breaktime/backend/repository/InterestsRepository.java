package com.breaktime.backend.repository;

import com.breaktime.backend.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestsRepository extends JpaRepository<Interests,Integer> {

    List<Interests> findByEmail(String email);
}

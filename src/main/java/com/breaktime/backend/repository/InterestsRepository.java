package com.breaktime.backend.repository;

import com.breaktime.backend.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestsRepository extends JpaRepository<Interests,Integer> {
}
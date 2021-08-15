package com.breaktime.backend.repository;

import com.breaktime.backend.entity.Activity;
import com.breaktime.backend.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    public List<Interests> findByCategoryID(int categoryID);
}

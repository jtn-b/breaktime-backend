package com.breaktime.backend.repository;

import com.breaktime.backend.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    public List<Activity> findByCategoryID(int categoryID);
}

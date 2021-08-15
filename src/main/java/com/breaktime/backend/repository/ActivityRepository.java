package com.breaktime.backend.repository;

import com.breaktime.backend.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {

     List<Activity> findByCategoryID(int categoryID);
}

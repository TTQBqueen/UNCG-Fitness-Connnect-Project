package com.UNCG_Fitness.UNCG_Fitness_Connect.review;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT r FROM Review r WHERE r.status = :status")
    List<Review> findByStatus(@Param("status")String status);


    @Query(value = "select * from review where class_id = :classId", nativeQuery = true)
    public List<Review> getReviewByClassId(@Param("classId") int classId);
}
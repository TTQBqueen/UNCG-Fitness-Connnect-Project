package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface ClassRepository extends JpaRepository<Class, Integer> {
        @Query(value = "select * from class where user_id = :userId", nativeQuery = true)
        public List<Class> getUserClasses(@Param("userId") long userId);
    }

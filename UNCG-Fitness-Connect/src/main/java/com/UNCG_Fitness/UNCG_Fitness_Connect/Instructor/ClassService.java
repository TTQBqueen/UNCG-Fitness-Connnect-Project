package com.UNCG_Fitness.UNCG_Fitness_Connect.Instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepository;

    public Object getAllClasses() {
        return classRepository.findAll();
    }

    public Object getAllUserClasses(long userId) {
        // Using a static userId since we are the only user
        return classRepository.getUserClasses(userId);
    }

    public Class getClassById(int id) {
        return classRepository.findById(id).orElse(null);
    }

}

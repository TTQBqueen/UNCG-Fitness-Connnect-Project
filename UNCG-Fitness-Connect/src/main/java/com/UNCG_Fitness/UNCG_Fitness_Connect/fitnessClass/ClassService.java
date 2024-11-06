package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

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

    public void createNewGoal(Class class) {
        if (classRepository.existsById(class.getClassId())) {

        }
        class = new Class(class.getUser(), class.getTitle(), class.getDetails(), class.getTargetDate());
        classRepository.save(class);
    }


}

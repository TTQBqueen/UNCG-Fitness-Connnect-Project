package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.review.Review;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepository;

    // Fetch all Classes.
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    // Fetch a single Classes by ID.
    public Class getClassById(int classId) {
        return classRepository.findById(classId).orElse(null);
    }

    //fetch class by title
    public List<Class> getClassesByTitle(String title) {
        return classRepository.getClassesByTitle(title);
    }

    //fetch classes by creatorID
    public List<Class> getClassesByCreatorId(int creatorId) {
        return classRepository.getClassesByCreatorId(creatorId);
    }

    // Fetch Classes by level.
    public List<Class> getClassesByLevel(String level) {
        return classRepository.getClassesByLevel(level);
    }

    // Fetch an class by part of a title
    public List<Class> getClassesByTitleContains(String title) {
        return classRepository.findByTitleContainingIgnoreCase(title);
    }

    // add Class .
    public void saveClass(Class fitnessClass) {
        classRepository.save(fitnessClass);
    }

//    // update existing Class.
//    public void updateClass(int classId, Class fitnessClass) {
//        Class existing = getClassById(classId);
//        if (existing == null) {
//            throw new IllegalArgumentException("Class not found with ID: " + classId);
//        }
//        classRepository.save(existing);
//    }

    // delete class
    public String deleteClassById(int classId) {
        classRepository.deleteById(classId);
        return "Class removed !! " + classId;
    }

    public void saveClass(Class fitnessClass, User user) {
        classRepository.save(fitnessClass);
    }

    public List<Class> getClassesByInstructor(int userId) {
        return classRepository.findByCreator_Id(userId);
    }

}
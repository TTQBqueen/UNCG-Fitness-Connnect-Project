package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

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

    // Fetch a class by part of a title
    public List<Class> getClassesByTitleContains(String title) {
        return classRepository.findByTitleContainingIgnoreCase(title);
    }
    // add Class .
    public void addNewClass(Class fitnessClass) {classRepository.save(fitnessClass);
    }

    // update existing Class.
    public Class updateClass(int classID, Class fitnessClass) {
        Class existingClass = getClassById(classID);
        existingClass.setTitle(fitnessClass.getTitle());
        existingClass.setCreatorId(fitnessClass.getCreatorId());
        existingClass.setDetails(fitnessClass.getDetails());
        existingClass.setDate(fitnessClass.getDate());
        existingClass.setStartTime(fitnessClass.getStartTime());
        existingClass.setEndTime(fitnessClass.getEndTime());
        existingClass.setLevel(fitnessClass.getLevel());
        existingClass.setInstructorName(fitnessClass.getInstructorName());
        existingClass.setStatus(fitnessClass.getStatus());
        existingClass.setImagePath(fitnessClass.getImagePath());
        existingClass.setUpdatedAt(fitnessClass.getUpdatedAt());

        return classRepository.save(existingClass);
    }
    // delete class
    public String deleteClassById(int classId) {
        classRepository.deleteById(classId);
        return "Class removed !! " + classId;
    }



}


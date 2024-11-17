
package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//All the  live here some are alread built in with using the api that on this file
public interface ClassRepository extends JpaRepository<Class, Integer> {

    //returns animals with name
    List<Class> getClassesByTitle(String name);

    //returns animals with classification
    List<Class> getClassesByLevel(String level);

    //returns animals with part of title
    List<Class> findByTitleContainingIgnoreCase(String title);

    List<Class> getClassesByCreatorId(int creatorId);

        List<Class> findByCreator_Id(int creatorId);


}

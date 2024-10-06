package com.HW4.demo.animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//All the qures live here some are alread built in with using the api that on this file
public interface AnimalRepository  extends JpaRepository<Animal, Integer> {

    //returns animals with name
    List<Animal> getAnimalsByName(String name);

    //returns animals with classification
    List<Animal> getAnimalsByClassification(String classification);

    //returns animals with part of nanme
    List<Animal> findByNameContainingIgnoreCase(String name);

    }
    


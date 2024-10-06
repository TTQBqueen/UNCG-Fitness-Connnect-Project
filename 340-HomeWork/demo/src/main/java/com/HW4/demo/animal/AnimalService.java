package com.HW4.demo.animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    // Fetch all Animal.
    public List<Animal> getAllAnimals() {
        return repository.findAll();
    }

    // Fetch a single Animals by ID.
    public Animal getAnimalById(int animalId) {
        return repository.findById(animalId).orElse(null);
    }

    //fetch animal by name
    public List<Animal> getAnimalsByName(String name) {
        return repository.getAnimalsByName(name);
    }

    // Fetch Animals by classification.
    public List<Animal> getAnimalsByClassification(String classification) {
        return repository.getAnimalsByClassification(classification);
    }

    // Fetch an animal by part of a name
    public List<Animal> getAnimalsByNameContains(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
    // add Animal .
    public void addNewAnimal(Animal animal) {repository.save(animal);
    }

    // update existing Animal.
    public Animal updateAnimal(int animalID, Animal animal) {
        Animal existingAnimal = getAnimalById(animalID);
        existingAnimal.setName(animal.getName());
        existingAnimal.setScientificName(animal.getScientificName());
        existingAnimal.setClassification(animal.getClassification());
        existingAnimal.setHabitat(animal.getHabitat());
        existingAnimal.setDescription(animal.getDescription());
        return repository.save(existingAnimal);
    }
    // delete animal
    public String deleteAnimalById(int animalId) {
        repository.deleteById(animalId);
        return "Animal removed !! " + animalId;
    }
    
}

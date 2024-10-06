package com.HW4.demo.animal;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * AnimalsController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")

public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals .
     * http://localhost:8080/animals/all
     *
     * @return a list of Animals  objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for a Animals.
     * @return One Animal object.
     */


     @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Get a list of Animals based on their classication.
     * http://localhost:8080/animals/class
     *
     * @param classification the search key.
     * @return A list of Animals objects matching the classification key.
     */

    @GetMapping("/class")
    public List<Animal> getAnimalsByClassification(@RequestParam(name = "classification", defaultValue = "manmmals") String classification) {
        return service.getAnimalsByClassification(classification);
    }


/**
     * Get a list of Animals based on their name.
     * http://localhost:8080/animals?name=cat
     *
     * @param name the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("")
    public List<Animal> getAnimalsByName(@RequestParam(name = "name", defaultValue = "animal") String name) {
        return service.getAnimalsByName(name);
    }
    /**
     * Get a list of Animals based on their name.
     * http://localhost:8080/animals/search?name=blue
     *
     * @param name the search key.
     * @return A list of Animal objects matching the search key.
     */

    @GetMapping("/search")
    public List<Animal> getAnimalsByNameContains(@RequestParam(name = "name", required = false) String name) {
        return service.getAnimalsByNameContains(name);
    }

     /**
     * Create a new Animals entry.
     * http://localhost:8080/animals/new --data '{ "AnimalId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/Animals/update/2 --data '{
     * "animalId": 1, "name": "cat", "ScientificName": "Felion", "Classification": "manmmal", "Habitat": "outside" , "Description": "this is a cat" }'
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}

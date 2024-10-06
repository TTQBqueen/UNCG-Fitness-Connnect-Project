package com.HW4.demo.animal;
import jakarta.persistence.*;

@Entity
//All my student are going to be in a table
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String scientificName;

    @Column(nullable = false)
    private String classification;

    @Column(nullable = false)
    private String habitat;

    @Column(nullable = true)
    private String description;
    
    public Animal(int animalId, String name, String scientificName, String classification, String habitat, String description) {
        this.animalId = animalId;
        this.name = name;
        this.scientificName = scientificName;
        this.classification = classification;
        this.habitat = habitat;
        this.description = description;
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
    public String getClassification() {
        return classification;
    }
    public void setClassification(String classification) {
        this.classification = classification;
    }
    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}

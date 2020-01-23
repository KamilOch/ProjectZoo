package com.example.zoo.zoo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalService {

    private static List<Animal> animals;

    @Autowired
    public AnimalService(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> createBaseAnimalsList() {
        animals.add(new Animal("Słoń", 30, "Ela"));
        animals.add(new Animal("Tygrys", 7, "Edek"));
        animals.add(new Animal("Foka", 3, "Pestka"));

        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }


    public void deleteAnimal(String name) {
        Animal deletedAnimal;
        for (Animal animal : animals
        ) {
            if (name.equals(animal.getName())) {
                deletedAnimal = animal;
                animals.remove(deletedAnimal);
                break;
            }
        }
    }
}
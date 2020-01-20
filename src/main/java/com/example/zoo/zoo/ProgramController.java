package com.example.zoo.zoo;

import com.example.zoo.zoo.animal.Animal;
import com.example.zoo.zoo.animal.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;

@Controller
public class ProgramController {

    private AnimalService animalService;
    List<Animal> animalList;

    public ProgramController(AnimalService animalService) {
        this.animalService = animalService;

        animalList = animalService.createBaseAnimalsList();
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/animalsList")
    public String animalList(Model model) {
        model.addAttribute("animals", animalList);
        return "animals";
    }

    @GetMapping("/addAnimal")
    public String addAnimal(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "name", required = false) String name
    ) {
        if (type != null && name != null) {
            Animal newAnimal = new Animal(type, age, name);
            animalService.addAnimal(newAnimal);
        }
        return "addingAnimal";
    }
}
package com.example.zoo.zoo;

import com.example.zoo.zoo.animal.Animal;
import com.example.zoo.zoo.animal.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProgramController {

    private AnimalService animalService;
    List<Animal> animalList;

    @Autowired
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

    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimalById(
            @PathVariable String id
    ) {
        animalService.deleteAnimalById(Integer.parseInt(id));
        return "redirect:/animalsList";
    }
    //TODO
    @RequestMapping("/editAnimal")
    public String editAnimal(
            @ModelAttribute("animal") Animal animal,
            Model model
    ) {
        model.addAttribute("editedAnimal", animal);
        return "editingAnimal";
    }

}
package com.example.zoo.zoo;

import com.example.zoo.zoo.animal.Animal;
import com.example.zoo.zoo.animal.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimalById(
            @PathVariable String id
    ) {
        animalService.deleteAnimalById(Integer.parseInt(id));
        return "redirect:/animalsList";
    }

    //TODO
    @GetMapping("/editAnimal/{id}")
    public String editAnimal(
            @PathVariable Integer id,
            Model model
    ) {
        Animal editedAnimal = animalService.findById(id);
        model.addAttribute("editedAnimal", editedAnimal);
        return "editingAnimal";
    }

    @GetMapping("/saveEditedAnimal")
    public String saveEditedAnimal(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "name", required = false) String name
    ) {
        animalService.editAnimal(id, type, age, name);
        return "redirect:/animalsList";
    }

}
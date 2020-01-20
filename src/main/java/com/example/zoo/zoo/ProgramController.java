package com.example.zoo.zoo;

import com.example.zoo.zoo.animal.Animal;
import com.example.zoo.zoo.animal.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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
}

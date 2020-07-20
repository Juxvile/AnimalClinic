package myFirstSpringBootApp.controller;



import myFirstSpringBootApp.domain.Animal;
import myFirstSpringBootApp.repository.AnimalRepo;
import myFirstSpringBootApp.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/animals")
public class AnimalController {
    AnimalService animalService;
    @Autowired
    public void setAnimalService (AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping
    public String getAnimals(Model model) {
        model.addAttribute("animals", animalService.findAllAnimals());
        return "animals";

    }
    @PostMapping
    public String addAnimal(@ModelAttribute Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animals";
    }
}

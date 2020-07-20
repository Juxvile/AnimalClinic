package myFirstSpringBootApp.service;


import myFirstSpringBootApp.domain.Animal;
import myFirstSpringBootApp.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalService {
    @Autowired
    public AnimalRepo animalRepo;

    public void addAnimal(Animal animal) {
        animalRepo.save(animal);
    }

    public Iterable<Animal> findAllAnimals() {
        return animalRepo.findAll();
    }
}

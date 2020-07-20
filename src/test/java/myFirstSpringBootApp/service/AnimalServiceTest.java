package myFirstSpringBootApp.service;

import myFirstSpringBootApp.domain.Animal;
import myFirstSpringBootApp.repository.AnimalRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnimalServiceTest {


    @Autowired
    AnimalRepo animalRepo;

    Animal animal = new Animal("dfsdfsf","dsfsfd","gfdgd");
    Animal animal2 = new Animal ("fgdgdfg", "gfdgdfgg", "fggdgfdg");

    @Test
    void addAnimal() {
        animalRepo.save(animal);
        animalRepo.save(animal2);

    }

    @Test
    void findAllAnimals() {
    }
}
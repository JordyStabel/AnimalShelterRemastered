package other;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import dal.repository.AnimalRepository;
import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Reservation extends Observable{

    private List<Animal> animals = new ArrayList<Animal>();
    //private AnimalRepository animalRepository = new AnimalRepository();

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public void newCat(String name, Gender gender, String badHabits, Double price){
        Cat cat = new Cat(name, gender, badHabits, price);
        this.animals.add(cat);
        saveToDB(cat);
        notifyObservers(cat);
    }

    public void newDog(String name, Gender gender, Double price){
        Dog dog = new Dog(name, gender, price);
        this.animals.add(dog);
        saveToDB(dog);
        notifyObservers(dog);
    }
    
    private void saveToDB(Animal animal){
        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.save(animal);
    }
}

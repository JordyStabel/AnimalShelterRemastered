package other;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Reservation extends Observable{

    private List<Animal> animals = new ArrayList<Animal>();

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public void newCat(String name, Gender gender, String badHabits){
        Cat cat = new Cat(name, gender, badHabits);
        this.animals.add(cat);
        notifyObservers(cat);
    }

    public void newDog(String name, Gender gender){
        Dog dog = new Dog(name, gender);
        this.animals.add(dog);
        notifyObservers(dog);
    }
}

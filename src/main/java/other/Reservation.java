package other;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    public List<Animal> animals = new ArrayList<Animal>();

    public void NewCat(String name, Gender gender, String badHabits){
        this.animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender){
        this.animals.add(new Dog(name, gender));
    }
}

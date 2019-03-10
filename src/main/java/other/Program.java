package other;

import animals.Cat;
import animals.Dog;
import enums.Gender;

public class Program {

    public static void main(String[] args){

       Dog dog = new Dog("Luna", Gender.Female);

       System.out.println(dog.toString());
       System.out.println(dog.isNeedsWalk());
       System.out.println(dog.getLastWalk());

        Cat cat = new Cat("Luna", Gender.Female, "Bad with young children");

        System.out.println(cat.toString());
        System.out.println(cat.getBadHabits());
    }
}

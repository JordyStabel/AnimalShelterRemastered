package animals;

import enums.Category;
import enums.Gender;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Animal {

    private String badHabits;

    public Cat() {}

    public Cat(String name, Gender gender, String badHabits, Double price) {
        super(name, gender, Category.CAT, price);
        this.badHabits = badHabits;
    }

    public String getBadHabits() {
        return this.badHabits;
    }

    private void setBadHabits(String badHabits) {
        this.badHabits = badHabits;
    }

    @Override
    public double getPrice() {
        double price = 350;
        price = price - (badHabits.length() * 20);
        return (price < 35 ) ? 35 : price;
    }

    @Override
    public String toString() {
        return "Cat{" +
                ", badHabits='" + badHabits + '\'' +
                '}';
    }
}

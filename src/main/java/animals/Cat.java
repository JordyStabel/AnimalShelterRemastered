package animals;

import enums.Category;
import enums.Gender;

public class Cat extends Animal {

    private String badHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender, Category.CAT);
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
        return super.toString() + ", €" + getPrice() + String.format(", bad habits %s", this.badHabits.toLowerCase());
    }
}

package animals;

import enums.Category;
import enums.Gender;

import java.util.Date;


public class Dog extends Animal {

    private static int dogCount = 0;
    private Date lastWalk;
    private boolean needsWalk;

    public Dog(String name, Gender gender) {
        super(name, gender, Category.DOG);
        this.lastWalk = new Date();
    }

    public Date getLastWalk() {
        return lastWalk;
    }

    private void setLastWalk(Date lastWalk) {
        this.lastWalk = lastWalk;
    }

    public boolean isNeedsWalk() {
        return (new Date().getTime() - this.lastWalk.getTime() > (24*60*60*1000));
    }

    private void setNeedsWalk(boolean needsWalk) {
        this.needsWalk = needsWalk;
    }

    @Override
    public String toString() {
        return super.toString() + ", €" + getPrice() + String.format(", last walk: %s", this.lastWalk);
    }

    @Override
    public double getPrice() {
        double price = 500;
        price = price - (dogCount * 50);
        return (price < 50 ) ? 50 : price;
    }
}

package animals;

import enums.Category;
import enums.Gender;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Animal {

    private static int dogCount = 0;
    private Date lastWalk;
    private boolean needsWalk;

    public Dog() {}

    public Dog(String name, Gender gender, Double price) {
        super(name, gender, Category.DOG, price);
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
        return "Dog{" + super.toString() +
                "lastWalk=" + lastWalk +
                ", needsWalk=" + needsWalk +
                '}';
    }

    @Override
    public double getPrice() {
        double price = 500;
        price = price - (dogCount * 50);
        return (price < 50 ) ? 50 : price;
    }
}

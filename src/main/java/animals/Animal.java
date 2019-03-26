package animals;

import enums.Category;
import enums.Gender;
import other.Reservor;
import shop.ISellable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Animals")
public abstract class Animal implements ISellable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Gender gender;

    @ManyToOne
    @JoinTable(name = "reservedBy")
    private Reservor reservedBy;

    @Column(name = "category")
    private Category category;

    @Column(name = "price")
    private Double price;

    public Animal() {}

    public Animal(String name, Gender gender, Category category, Double price){
        this.name = name;
        this.gender = gender;
        this.category = category;
        this.price = price;
    }

    public Animal(int id, String name, Gender gender, Category category, Double price){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.category = category;
        this.price = price;
    }

    public boolean reserve(String reservedBy){
        if (this.reservedBy == null){
            this.reservedBy = new Reservor(reservedBy, new Date());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", reservedBy=" + reservedBy +
                ", category=" + category +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    private void setGender(Gender gender) {
        this.gender = gender;
    }

    public Reservor getReservedBy() {
        return reservedBy;
    }

    private void setReservedBy(Reservor reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

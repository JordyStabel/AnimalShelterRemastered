package animals;

import enums.Gender;
import other.Reservor;

import java.util.Date;

public class Animal {

    private String name;
    private Gender gender;
    private Reservor reservedBy;

    public Animal(String name, Gender gender){
        this.name = name;
        this.gender = gender;
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
        String reserved = "Not reserved";
        if (this.reservedBy != null){
            reserved = String.format("Reserved by %s", this.reservedBy.getName());
        }
        return String.format("%s, %s, %s", this.name, this.gender, reserved);
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
}

package other;

import java.util.Date;

public class Reservor {

    private String name;
    private Date reservedAt;

    public Reservor(String name, Date reservedAt){
        this.name = name;
        this.reservedAt = reservedAt;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    private void setReservedAt(Date reservedAt) {
        this.reservedAt = reservedAt;
    }
}

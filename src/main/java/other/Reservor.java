package other;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reservor")
public class Reservor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date reservedAt;

    public Reservor() {}

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

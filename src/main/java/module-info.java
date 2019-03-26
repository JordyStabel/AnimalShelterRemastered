module AnimalShelter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.transaction;
    requires java.naming;

    opens ui;
    exports ui;
}
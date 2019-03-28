package ui;

import animals.Animal;
import dal.repository.AnimalRepository;
import enums.Category;
import enums.Gender;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import other.Reservation;
import shop.ISellable;
import shop.Shop;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class Controller implements Initializable {

    private Reservation reservations;
    private Shop shop;

    /**
     * ComboBoxes
     */
    @FXML
    private ComboBox<Category> category_CB;

    /**
     * TextFields
     */
    @FXML
    private TextField name_TF;
    @FXML
    private TextField price_TF;
    @FXML
    private TextField reserverName_TF;

    /**
     * RadioButtons
     */
    @FXML
    private RadioButton male_RB;
    @FXML
    private RadioButton female_RB;

    /**
     * TextAreas
     */
    @FXML
    private TextArea badHabits_TA;

    /**
     * ListViews
     */
    @FXML
    private ListView animals_LV;
    @FXML
    private ListView shop_LV;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        category_CB.setItems(observableArrayList(Category.CAT, Category.DOG, Category.ITEM));
        reservations = new Reservation();
        shop = new Shop();
        reservations.subscribe(shop);
    }

    @FXML
    private void addNewItem() {
        switch (category_CB.getValue()) {
            case CAT:
                reservations.newCat(name_TF.getText(), male_RB.isSelected() ? Gender.Male : Gender.Female, badHabits_TA.getText(), 0.0);
                break;
            case DOG:
                reservations.newDog(name_TF.getText(), male_RB.isSelected() ? Gender.Male : Gender.Female, 0.0);
                break;
            case ITEM:
                shop.addNewItem(name_TF.getText(), Double.parseDouble(price_TF.getText()));
                break;
            default:
                Alert alert = createNewAlert(
                        Alert.AlertType.ERROR,
                        "Error",
                        "Oops, something went wrong",
                        "This input isn't supported. \n Please select something (else).");
                alert.show();
        }
        ObservableList<Animal> animals = animals_LV.getItems();
        animals.clear();
        animals.addAll(reservations.getAllAnimals());
        ObservableList<ISellable> inventory = shop_LV.getItems();
        inventory.clear();
        inventory.addAll(shop.getInventory());
    }

    @FXML
    private void categoryCBChange() {
        if (category_CB.getValue() != null){
            badHabits_TA.setDisable(category_CB.getValue() != Category.CAT);
            price_TF.setDisable(category_CB.getValue() != Category.ITEM);
            male_RB.setDisable(category_CB.getValue() == Category.ITEM);
            female_RB.setDisable(category_CB.getValue() == Category.ITEM);
        }
    }

    @FXML
    private void addReserver() {
        Animal animal = (Animal) animals_LV.getSelectionModel().getSelectedItem();
        Alert alert;
        if (animal.reserve(reserverName_TF.getText())) {
            alert = createNewAlert(
                    Alert.AlertType.INFORMATION,
                    "Success",
                    "Animal reserved",
                    "You successfully reserved: " + animal.getName());
        } else {
            alert = createNewAlert(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Oops, something went wrong",
                    animal.getName() + " Is already reserved by someone");
        }
        animals_LV.refresh();
        shop_LV.refresh();
        alert.show();
    }

    private Alert createNewAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert;
    }
}

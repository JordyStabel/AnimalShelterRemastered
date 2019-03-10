package ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class Controller {
    @FXML private Spinner<Integer> spinner;
    @FXML private Label output;

    @FXML
    public void initialize() {
        initSpinner();
    }

    private void initSpinner() {
        spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20)
        );
    }

    @FXML
    private void handleCalculateButton(ActionEvent event) {
        output.setText("" + " This is a test, change this");//calc.Factorial.fac(spinner.getValueFactory().getValue()));
    }
}

package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._01Schueler_1Attribut_GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private Schueler s1;
    private Schueler s2;

    public Controller() {

    }

    @FXML
    public TextField tfInput1;

    @FXML
    public TextField tfInput2;

    @FXML
    public Label lOutput;

    @FXML
    void oaIsGreater() {
        if (!inputEmpty()) {
            inputFelderEinlesen();
            lOutput.setText(String.valueOf(s1.isGreater(s2)));
        } else {
            alert();
        }
    }

    private void alert() {
        new Alert(Alert.AlertType.ERROR, "Bitte beider Eingabefelder ausfüllen!").showAndWait();
    }

    @FXML
    void oaIsLess() {
        if (!inputEmpty()) {
            inputFelderEinlesen();
            lOutput.setText(String.valueOf(s1.isLess(s2)));
        }
    }

    @FXML
    void oaIsEqual() {
        if (!inputEmpty()) {
            inputFelderEinlesen();
            lOutput.setText(String.valueOf(s1.isEqual(s2)));
        }
    }

    @FXML
    void oaClear() {
        tfInput1.clear();
        tfInput2.clear();
        lOutput.setText("");
    }

    private boolean inputEmpty() {
        return (tfInput1.getText().isEmpty() && tfInput2.getText().isEmpty());
    }

    private void inputFelderEinlesen() {
        s1 = new Schueler(tfInput1.getText());
        s2 = new Schueler(tfInput2.getText());
    }
}

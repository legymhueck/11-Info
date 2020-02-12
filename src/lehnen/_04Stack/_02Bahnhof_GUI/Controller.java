package lehnen._04Stack._02Bahnhof_GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private Bahnhof bh;

    public Controller() {
        bh = new Bahnhof();
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private TextField tf_Wagon;

    @FXML
    private TextArea ta_GleisA;

    @FXML
    private TextArea ta_GleisB;

    @FXML
    private TextArea ta_GleisC;


    @FXML
    void oa_hinzufuegen() {
        if (!tf_Wagon.getText().isEmpty() && !doppelt()) {
            int i = Integer.parseInt(tf_Wagon.getText());
            bh.getA().getGleis().push(new Wagon(i));
            tf_Wagon.clear();
            oa_anzeigen();
        } else if (tf_Wagon.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Feld leer!").showAndWait();
        } else if (doppelt()) {
            new Alert(Alert.AlertType.ERROR, "Wagon doppelt!").showAndWait();
            tf_Wagon.clear();
        }
    }

    @FXML
    void oa_sortieren() {
        while (!bh.getA().getGleis().isEmpty() || !bh.getC().getGleis().isEmpty()) {
            bh.sortieren();
        }
        oa_anzeigen();
    }

    @FXML
    void oa_einzeln() {
        bh.sortieren();
        oa_anzeigen();
    }

    @FXML
    void oa_anzeigen() {
        ta_GleisA.clear();
        ta_GleisB.clear();
        ta_GleisC.clear();
        while (!bh.getA().getGleis().isEmpty()) {
            bh.getD().getGleis().push(bh.getA().getGleis().top());
            bh.getA().getGleis().pop();
        }
        while (!bh.getD().getGleis().isEmpty()) {
            ta_GleisA.appendText("Wagon " + bh.getD().getGleis().top().getNummer() + "\n");
            bh.getA().getGleis().push(bh.getD().getGleis().top());
            bh.getD().getGleis().pop();
        }
        while (!bh.getB().getGleis().isEmpty()) {
            bh.getD().getGleis().push(bh.getB().getGleis().top());
            bh.getB().getGleis().pop();
        }
        while (!bh.getD().getGleis().isEmpty()) {
            ta_GleisB.appendText("Wagon " + bh.getD().getGleis().top().getNummer() + "\n");
            bh.getB().getGleis().push(bh.getD().getGleis().top());
            bh.getD().getGleis().pop();
        }
        while (!bh.getC().getGleis().isEmpty()) {
            bh.getD().getGleis().push(bh.getC().getGleis().top());
            bh.getC().getGleis().pop();
        }
        while (!bh.getD().getGleis().isEmpty()) {
            ta_GleisC.appendText("Wagon " + bh.getD().getGleis().top().getNummer() + "\n");
            bh.getC().getGleis().push(bh.getD().getGleis().top());
            bh.getD().getGleis().pop();
        }
    }

    @FXML
    void oa_loeschen() {
        ta_GleisA.clear();
        ta_GleisB.clear();
        ta_GleisC.clear();

        bh.getA().loeschen();
        bh.getB().loeschen();
        bh.getC().loeschen();
        bh.getD().loeschen();
    }

    public boolean doppelt() {
        boolean doppelt = false;
        Stack<Wagon> temp = new Stack<Wagon>();
        while (!bh.getA().getGleis().isEmpty()) {
            Wagon w = bh.getA().getGleis().top();
            int nummer = w.getNummer();
            int eingabe = Integer.parseInt(tf_Wagon.getText());
            if (nummer == eingabe) {
                doppelt = true;
            }
            bh.getA().getGleis().pop();
            temp.push(w);
        }

        // 2. Stack wieder zurückschreiben und dabei die einzelnen Wagons ausgeben
        while (!temp.isEmpty()) {
            Wagon w = temp.top();
            temp.pop();
            bh.getA().getGleis().push(w);

        }
        return doppelt;
    }
}

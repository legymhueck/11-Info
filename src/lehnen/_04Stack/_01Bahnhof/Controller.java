package lehnen._04Stack._01Bahnhof;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        if (!tf_Wagon.getText().isEmpty()) {
            int i = Integer.parseInt(tf_Wagon.getText());
            bh.getA().getGleis().push(new Wagon(i));
            tf_Wagon.clear();
            oa_anzeigen();
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
    }
}

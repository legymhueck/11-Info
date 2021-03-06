package lehnen._04Stack._04Bahnhof_GUI_doppelteVerbieten;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private Bahnhof bahnhof;

    public Controller() {
        bahnhof = new Bahnhof();
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

            int i = 0;
            boolean bOK = true;
            try {
                i = Integer.parseInt(tf_Wagon.getText());
            }
            catch (Exception e){
                new Alert(Alert.AlertType.ERROR, "Bitte Integer-Wert eingeben!").show();
                bOK = false;
            }

            if (bOK) {
                bahnhof.getA().wagonAbstellen(new Wagon(i));
                tf_Wagon.clear();
            }
            oa_anzeigen();
        } else if (doppelt()) {
            new Alert(Alert.AlertType.ERROR, "Wagon doppelt!").showAndWait();
            tf_Wagon.clear();
        }
    }

    @FXML
    void oa_sortieren() {
        bahnhof.sortieren();
        oa_anzeigen();
    }

    @FXML
    void oa_einzeln() {
        bahnhof.naechsterSortierSchritt();
        oa_anzeigen();
    }

    @FXML
    void oa_anzeigen() {
        gleisAnzeigen(ta_GleisA, bahnhof.getA());
        gleisAnzeigen(ta_GleisB, bahnhof.getB());
        gleisAnzeigen(ta_GleisC, bahnhof.getC());
    }

    void gleisAnzeigen(TextArea pTA, Gleis pGleis) {
        pTA.clear();

        Gleis tmp = new Gleis("tmp");

        // temporär umschieben, um dann in der GUI in der richtigen Reihenfolge anzeigen zu können
        while (!pGleis.istLeer()) {
            tmp.wagonAbstellen(pGleis.wagonHolen());
        }

        while (!tmp.istLeer()) {
            Wagon w = tmp.wagonHolen();
            pTA.appendText("Wagon " + w.getNummer() + "\n");
            pGleis.wagonAbstellen(w);
        }
    }

    @FXML
    void oa_loeschen() {
        bahnhof.getA().loeschen();
        bahnhof.getB().loeschen();
        bahnhof.getC().loeschen();

        oa_anzeigen();
    }

    public boolean doppelt() {
        boolean doppelt = false;
        Stack<Wagon> temp = new Stack<>();
        while (!bahnhof.getA().istLeer()) {
            Wagon w = bahnhof.getA().wagonHolen();
            int nummer = w.getNummer();
            int eingabe = Integer.parseInt(tf_Wagon.getText());
            if (nummer == eingabe) {
                doppelt = true;
            }
            bahnhof.getA().wagonHolen();
            temp.push(w);
        }

        // 2. Stack wieder zurückschreiben und dabei die einzelnen Wagons ausgeben
        while (!temp.isEmpty()) {
            Wagon w = temp.top();
            temp.pop();
            bahnhof.getA().wagonAbstellen(w);

        }
        return doppelt;
    }
}

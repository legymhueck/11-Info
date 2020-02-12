package lehnen._04Stack._03_Bahnhof_GUI_doppelteZulassen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lehnen._04Stack._02Bahnhof_GUI.Stack;

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
        if (!tf_Wagon.getText().isEmpty()) {

            int i = 0;
            boolean bOK = true;
            try {
                i = Integer.parseInt(tf_Wagon.getText());
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Bitte Integer-Wert eingeben!").show();
                bOK = false;
            }

            if (bOK) {
                bahnhof.getA().wagonAbstellen(new Wagon(i));
                tf_Wagon.clear();
            }
            oa_anzeigen();
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
}

package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._03FabianJansen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField tf_vorname1;
    @FXML
    private TextField tf_vorname2;
    @FXML
    private TextField tf_nachname1;
    @FXML
    private TextField tf_nachname2;
    @FXML
    private TextField tf_klasse1;
    @FXML
    private TextField tf_klasse2;
    @FXML
    private TextArea ta_ergebnis;
    @FXML
    private Button b_vorname_greater;
    @FXML
    private Button b_vorname_equal;
    @FXML
    private Button b_vorname_less;

    public Controller() {

    }

    public Schueler schuelerBauen(String pVorname, String pNachname, String pKlasse) {
        return new Schueler(pVorname, pNachname, pKlasse);
    }

    @FXML
    void oa_vornamegreater(ActionEvent event) {
        Schueler s = schuelerBauen(tf_vorname1.getText(), tf_nachname1.getText(), tf_klasse1.getText());
        Schueler s2 = schuelerBauen(tf_vorname2.getText(), tf_nachname2.getText(), tf_klasse2.getText());
        ta_ergebnis.clear();
        ta_ergebnis.appendText(Boolean.toString(s.isGreater(s2)));
    }

    @FXML
    void oa_vornameless(ActionEvent event) {
        Schueler s = schuelerBauen(tf_vorname1.getText(), tf_nachname1.getText(), tf_klasse1.getText());
        Schueler s2 = schuelerBauen(tf_vorname2.getText(), tf_nachname2.getText(), tf_klasse2.getText());
        ta_ergebnis.clear();
        ta_ergebnis.appendText(Boolean.toString(s.isLess(s2)));
    }

    @FXML
    void oa_vornameequal(ActionEvent event) {
        Schueler s = schuelerBauen(tf_vorname1.getText(), tf_nachname1.getText(), tf_klasse1.getText());
        Schueler s2 = schuelerBauen(tf_vorname2.getText(), tf_nachname2.getText(), tf_klasse2.getText());
        ta_ergebnis.clear();
        ta_ergebnis.appendText(Boolean.toString(s.isEqual(s2)));
    }
}

package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._04Suchen_Einfuegen_Loeschen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lehnen._08NichtLineareDatenstrukturen._08ComparableContent._02Schueler_3Attribute.Schueler;
import resources._01NRW._01Datenstrukturklassen._02Baum.BinaryTree;

public class Controller {
    /**
     * Attribute
     */
    private Methoden methoden;
    private BinaryTree<Schueler> meinSchuelerBaum;

    @FXML
    private TextField tfNachname;

    @FXML
    private TextField tfVorname;

    @FXML
    private TextField tfKlasse;

    @FXML
    private TextArea taAusgabe;

    // -------------------------------------------------

    /**
     * Konstruktor
     */
    public Controller() {
        methoden = new Methoden();
        meinSchuelerBaum = new BinaryTree<>();
        methoden.einfuegen(meinSchuelerBaum, new Schueler("Müller", "Heinz", "Q1"));
    }

    public void initialize() {

    }

    /**
     * Button actions
     */
    @FXML
    void oaEinfuegen() {
        if (inputFelderNichtLeer()) {
            methoden.einfuegen(meinSchuelerBaum, new Schueler(tfNachname.getText(), tfVorname.getText(), tfKlasse.getText()));
        }
    }

    @FXML
    void oaSuchen() {
        if (inputFelderNichtLeer() && !meinSchuelerBaum.isEmpty()) { // Auf leeren Baum testen??
            Schueler zuSuchenderSchueler = new Schueler(tfNachname.getText(), tfVorname.getText(), tfKlasse.getText());
            if (methoden.suchen(meinSchuelerBaum, zuSuchenderSchueler) != null) {
                taAusgabe.setText("Schüler gefunden");
            } else {
                taAusgabe.setText("Schüler NICHT gefunden");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Bitte alle Felder ausfüllen!").showAndWait();
        }
    }

    @FXML
    void oaPreOrder() {
        taAusgabe.clear();
        preorder(meinSchuelerBaum);
    }

    @FXML
    void oaInOrder() {
        taAusgabe.clear();
        inorder(meinSchuelerBaum);
    }

    @FXML
    void oaPostOrder() {
        taAusgabe.clear();
        postorder(meinSchuelerBaum);
    }

    @FXML
    void oaClear() {
        tfVorname.clear();
        tfNachname.clear();
        tfKlasse.clear();
        taAusgabe.clear();
    }


    @FXML
    void oaLoeschen() {
        taAusgabe.clear();
        if (inputFelderNichtLeer() && !meinSchuelerBaum.isEmpty()) {
            // Schülerdaten aus den Textfeldern ist der zu löschende Schüler
            Schueler zuLoeschenderSchueler = new Schueler(tfNachname.getText(), tfVorname.getText(), tfKlasse.getText());
            if (methoden.suchen(meinSchuelerBaum, zuLoeschenderSchueler) != null) {
                meinSchuelerBaum = methoden.loeschen(meinSchuelerBaum, zuLoeschenderSchueler);
                taAusgabe.setText("Schüler wurde gelöscht.");
            } else {
                taAusgabe.setText("Schüler wurde NICHT gelöscht, da er nicht vorhanden ist.");
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Bitte alle Felder ausfüllen!").showAndWait();
        }
    }

    public void preorder(BinaryTree<Schueler> pBaum) { // WLR
        if (pBaum.getContent() != null) {
            taAusgabe.appendText(pBaum.getContent() + "\n");
        }
        if (pBaum.getLeftTree() != null) {
            preorder(pBaum.getLeftTree());
        }
        if (pBaum.getRightTree() != null) {
            preorder(pBaum.getRightTree());
        }
    }

    public void inorder(BinaryTree<Schueler> pBaum) { // LWR
        if (pBaum.getLeftTree() != null) {
            inorder(pBaum.getLeftTree());
        }
        if (pBaum.getContent() != null) {
            taAusgabe.appendText(pBaum.getContent() + "\n");
        }
        if (pBaum.getRightTree() != null) {
            inorder(pBaum.getRightTree());
        }
    }

    public void postorder(BinaryTree<Schueler> pBaum) { // LRW
        if (pBaum.getLeftTree() != null) {
            inorder(pBaum.getLeftTree());
        }
        if (pBaum.getRightTree() != null) {
            inorder(pBaum.getRightTree());
        }
        if (pBaum.getContent() != null) {
            taAusgabe.appendText(pBaum.getContent() + "\n");
        }
    }

    private boolean inputFelderNichtLeer() {
        return (!(tfNachname.getText().isEmpty() && tfVorname.getText().isEmpty() && tfKlasse.getText().isEmpty()));
    }
}

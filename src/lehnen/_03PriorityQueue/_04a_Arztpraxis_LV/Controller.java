package lehnen._03PriorityQueue._04a_Arztpraxis_LV;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/* --- Imports no longer necessary or for later
//import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
---- End currently unnecessary imports */

public class Controller {
    // Attribute
    public Main main;

    // Objekt der Klasse PriorityQueue erzeugen
    private PriorityQueue priorityQueue = new PriorityQueue();

    // Variables for ids
    @FXML
    private TextField textPatientAufnahme;
    @FXML
    private TextField textPrioAufnahme;
    @FXML
    private TextField textPatientSprechzimmer;
    @FXML
    private TextArea areaPatient;
    @FXML
    private TextArea areaPrio;
    @FXML
    private Button buttonInsert;
    @FXML
    private Button buttonGo;
    @FXML
    private Button buttonNext;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonFertig;

    public void setMain(Main pMain) {
        main = pMain;
    }


    /* --- Start of methods to handle fxml events --- */

    @FXML
    void initialize() {
        checkWaitingAreaButtons();
        checkAufnahme();
    }

    @FXML
    private void checkAufnahme() {
        String strName = textPatientAufnahme.getText();
        String strPrio = textPrioAufnahme.getText();

        if ((strName == null) || (strPrio == null) || strName.isEmpty() || strPrio.isEmpty()) {
            buttonInsert.setDisable(true);
        } else {
            try {
                int nPrio = Integer.parseInt(strPrio);
                if (nPrio > 0)
                    buttonInsert.setDisable(false);
                else
                    buttonInsert.setDisable(true);
            } catch (Exception e) {
                buttonInsert.setDisable(true);
            }
        }
    }

    private void checkWaitingAreaButtons() {
        if (priorityQueue.isEmpty()) {
            buttonClear.setDisable(true);
            buttonGo.setDisable(true);
            buttonNext.setDisable(true);
        } else {
            buttonClear.setDisable(false);
            buttonGo.setDisable(false);
            buttonNext.setDisable(false);
        }

        if ((textPatientSprechzimmer.getText() == null) || textPatientSprechzimmer.getText().isEmpty()) {
            buttonFertig.setDisable(true);
        } else {
            buttonFertig.setDisable(false);
        }
    }

    @FXML
    private void addPatient() {
        // Werte aus Textfeldern auslesen und dabei Priorität in int umwandeln
        String strName = textPatientAufnahme.getText();
        int nPrio = 1;

        try {
            nPrio = Integer.parseInt(textPrioAufnahme.getText());
            Patient pPatient = new Patient(nPrio, strName);
            priorityQueue.insert(pPatient);

            updateWaitingRoom();

            // Nach Einfügen ins Display beide Textfelder loeschen.
            textPatientAufnahme.setText("");
            textPrioAufnahme.setText("");
            checkAufnahme();
        } catch (Exception e) {
            textPrioAufnahme.setText("1");
        }
    }

    @FXML
    private void removePatient() {
        int currentpos = areaPatient.getCaretPosition();

        priorityQueue.liste.toFirst();
        String strText = areaPatient.getText();
        for (int i = 0; i < currentpos; i++) {
            if (strText.substring(i, i + 1).contentEquals("\n"))
                priorityQueue.liste.next();
        }

        priorityQueue.liste.remove();

        updateWaitingRoom();
    }

    @FXML
    private void callNextPatient() {
        Patient pPatient = (Patient) priorityQueue.front();
        priorityQueue.dequeue();

        updateWaitingRoom();

        textPatientSprechzimmer.setText(pPatient.getName());
        buttonFertig.setDisable(false);
    }

    @FXML
    private void clearAll() {
        while (!priorityQueue.isEmpty())
            priorityQueue.dequeue();

        updateWaitingRoom();
    }

    @FXML
    private void patientHealed() {
        textPatientSprechzimmer.setText("");
        checkWaitingAreaButtons();
    }

    private void updateWaitingRoom() {
        areaPatient.clear();
        areaPrio.clear();

        priorityQueue.liste.toFirst();
        while (priorityQueue.liste.current != null) {
            Patient pPatient = (Patient) priorityQueue.liste.getContent();
            areaPatient.appendText(pPatient.getName() + "\n");
            areaPrio.appendText(pPatient.getPriority() + "\n");
            priorityQueue.liste.next();
        }
        checkWaitingAreaButtons();
    }
}

package lehnen._05Rekursion._09Uebung_20200309._01Aufgabe;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

public class MainView extends Application {
    private VBox root;
    private HBox textFieldHBox;
    private HBox buttonHBox;
    private Scene scene;
    private TextField[] textFieldArray;
    private Board board;
    private ExecutorService executor;
    private Runnable runnableTask;
    boolean bIsIUpating;

    public MainView() {
        // GUI
        textFieldArray = new TextField[9];
        executor = Executors.newCachedThreadPool();

        // Business Logic
        board = new Board();
        bIsIUpating = false;
    }

    @Override
    public void start(Stage pStage) throws MalformedURLException {
        root = new VBox();
        scene = new Scene(root, 600, 400, Color.BEIGE);

        scene.getStylesheets().add(new URL(String.valueOf(getClass().getResource("styles.css"))).toExternalForm());

        // TextFields
        createTextFields();
        // Buttons
        createButtonBoxAndButtons();

        pStage.setScene(scene);
        pStage.show();
    }

    public void createTextFields() {
        textFieldHBox = new HBox();
        textFieldHBox.getStyleClass().add("textFieldHBox");
        for (int i = 0; i < textFieldArray.length; i++) {
            textFieldArray[i] = createTextField(i);
            textFieldArray[i].setFocusTraversable(false);
            textFieldHBox.getChildren().add(textFieldArray[i]);
        }
        root.getChildren().add(textFieldHBox);
    }


    public void createButtonBoxAndButtons() {
        // Button Permutationen
        Button b_permutations = new Button("Permutationen");
        b_permutations.setOnAction(event -> {
            runnableTask = () -> displayPermutations();
            executor.submit(runnableTask);
        });

        // Button sortieren
        Button b_sortieren = new Button("sortieren");
        b_sortieren.setOnAction(event -> {
            sort();
        });

        //Button Zufallszahlen erzeugen
        Button b_erzeugen = new Button("erzeugen");
        b_erzeugen.setOnAction(event -> {
            arrayFuellenUndDoppelteAussortieren();

        });

        // Button lösen iterativ
        Button b_solve_iterative = new Button("lösen (iterativ)");
        b_solve_iterative.setOnAction(event -> {
            solve_iterative();
        });

        // Button lösen rekursiv
        Button b_solve_recursive = new Button("lösen (rekursiv)");
        b_solve_recursive.setOnAction(event -> {
            solve_recursive();
        });

        // Button Felder löschen
        Button b_clear = new Button("empty");
        b_clear.setOnAction(event -> empty());

        // Button Fenster schließen
        Button b_exit = new Button("exit");
        b_exit.setOnAction(event -> System.exit(0));


        // ButtonBox
        buttonHBox = new HBox();
        buttonHBox.getStyleClass().add("buttonHBox");
        buttonHBox.getChildren().addAll(b_permutations, b_erzeugen, b_solve_iterative, b_solve_recursive, b_sortieren, b_clear, b_exit);

        root.getChildren().add(buttonHBox);
    }

    private void empty() {
        board.clear();
        updateView();
    }

    private void displayPermutations() {
        board.displayPermulations(this);

        updateView();
    }

    private void solve_recursive() {
        board.solve_recursive();
        updateView();
    }


    private void solve_iterative() {
        board.solve_iterative();
        updateView();
    }

    public void arrayFuellenUndDoppelteAussortieren() {
        board.random_fill(3);
        updateView();
    }

    private void sort() {
        board.sort();
        updateView();

    }

    public void updateCell(int pIdx, int pValue) {
        if (!bIsIUpating) {
            bIsIUpating = true;
            TextField tf = textFieldArray[pIdx];
            if (pValue > 0) {
                tf.setText(String.valueOf(pValue));
            } else {
                tf.setText("");
            }

            // this update is called from within the algorithm, which is why the value is never system but always user
            tf.setStyle("-fx-text-fill: blue");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            bIsIUpating = false;
        }
    }

    public void updateView() {

        try {
            if (!bIsIUpating) {
                bIsIUpating = true;

                for (int i = 0; i < textFieldArray.length; i++) {
                    int value = board.getValue(i);
                    boolean bSystem = board.isSystemValue(i);
                    TextField tf = textFieldArray[i];

                    if (value > 0) {
                        tf.setText(String.valueOf(value));
                    } else {
                        tf.setText("");
                    }

                    if (bSystem) {
                        tf.setStyle("-fx-text-fill: black");
                    } else {
                        tf.setStyle("-fx-text-fill: blue");
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();

                }
                bIsIUpating = false;
            }
        } catch (Exception e) {
            // just ignore it...
            System.out.println("ERROR! Exception caught in UpdateView! " + e.getMessage());
        }
    }


    private TextField createTextField(int idx) {
        TextField textField = new TextField();
        textField.getStyleClass().add("textfield");
        textField.setTextFormatter(new TextFormatter<Integer>(change -> {
            if (change.getControlNewText().matches("[1-9]{0,1}")) {
                return change;
            } else {
                return null;
            }
        }));
        textField.setId(String.valueOf(idx));
        textField.setOnAction(this::onTextfieldChanged);
        textField.setOnKeyReleased(this::onTextfieldChanged);
        return textField;
    }

    private void onTextfieldChanged(Event event) {
        if (event.getSource().getClass() == TextField.class) {
            TextField tf = (TextField) event.getSource();

            int pos = Integer.parseInt(tf.getId());

            String strText = tf.getText();
            if (strText.isEmpty()) {
                board.setValue(pos, 0, false);
            } else {
                int value = Integer.parseInt(strText);
                board.setValue(pos, value, true);
            }
            updateView();
        }
    }
}

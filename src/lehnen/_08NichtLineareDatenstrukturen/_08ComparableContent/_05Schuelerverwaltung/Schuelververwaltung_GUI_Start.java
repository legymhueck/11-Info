package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._05Schuelerverwaltung;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import resources._01NRW._01Datenstrukturklassen._02Baum.BinarySearchTree;

public class Schuelververwaltung_GUI_Start extends Application {

    private BorderPane root;
    private Scene scene;
    private VBox topNodes;
    private TableView<Schueler> tableView;
    private ObservableList<Schueler> data;
    private Schuelerverwaltung schuelerverwaltung;
    private TableColumn firstColumn;
    private TableColumn secondColumn;
    private TableColumn thirdColumn;

    private TextField tfVorname;
    private TextField tfNachname;
    private TextField tfEmail;

    public Schuelververwaltung_GUI_Start() {
        schuelerverwaltung = new Schuelerverwaltung();
        data = FXCollections.observableArrayList();


    }

    @Override
    public void start(Stage pStage) {
        root = new BorderPane();
        scene = new Scene(root, 980, 400, Color.BEIGE);

        root.setTop(createTopNodes());
        root.setCenter(createTableView());
        createEventHandler();

        pStage.setScene(scene);
        pStage.setTitle("Schülerverwaltung");
        pStage.getIcons().add(new Image("/resources/Logo/logo_gymhueck.png"));
        pStage.show();
    }

    private void generateTestData() {
        schuelerverwaltung.neuenNutzerAnlegen("Hans", "Meier", "hans.meier@outlook.com");
        schuelerverwaltung.neuenNutzerAnlegen("Adam", "Abels", "adamabels@gmx.net");
        schuelerverwaltung.neuenNutzerAnlegen("Linda", "Heinze", "linda_heinze@web.de");
        schuelerverwaltung.neuenNutzerAnlegen("Frank", "Zarowski", "frank@zarowski.com");
        schuelerverwaltung.neuenNutzerAnlegen("Eva", "Müller", "eva.mueller@gmail.com");
        schuelerverwaltung.neuenNutzerAnlegen("Luke", "Müller", "luke.mueller@gmail.com");
        inorderAnzeigen();
    }

    private void createEventHandler() {
        tableView.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            if (!tableView.getItems().isEmpty()) {
                tfVorname.setText(tableView.getSelectionModel().getSelectedItem().getVorname());
                tfNachname.setText(tableView.getSelectionModel().getSelectedItem().getNachname());
                tfEmail.setText(tableView.getSelectionModel().getSelectedItem().getEmail());
            }
        });
    }

    private TableView createTableView() {
        tableView = new TableView();
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        firstColumn = new TableColumn("Vorname");
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("vorname"));

        secondColumn = new TableColumn("Nachname");
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        secondColumn.setStyle("-fx-font-weight: bold");

        thirdColumn = new TableColumn("E-Mail");
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.setItems(data);
        tableView.getColumns().addAll(firstColumn, secondColumn, thirdColumn);

        return tableView;
    }

    private VBox createTopNodes() {
        /**
         * Buttons
         */
        Button bAdd = new Button("Hinzufügen");
        Button bRemoveSelectedRow = new Button("Zeile löschen");
        Button bProfilVorhanden = new Button("Profil vorhanden?");
        Button bInorder = new Button("Inorder");
        Button bPreorder = new Button("Preorder");
        Button bPostorder = new Button("Postorder");
        Button bClear = new Button("Clear");
        Button bTestData = new Button("Testdaten");
        Button bBaumZeichnen = new Button("Baum zeichnen");
        Button bExit = new Button("Exit");

        /**
         * Text Fields
         */
        tfVorname = new TextField();
        tfVorname.setTooltip(new Tooltip("Vorname"));
        tfVorname.setPromptText("Vorname");

        tfNachname = new TextField();
        tfNachname.setTooltip(new Tooltip("Nachname"));
        tfNachname.setPromptText("Nachname");

        tfEmail = new TextField();
        tfEmail.setTooltip(new Tooltip("E-Mail"));
        tfEmail.setPromptText("E-Mail");
        tfEmail.setPrefWidth(250);

        /**
         * Top Nodes
         */

        HBox topTextFields = new HBox(tfVorname, tfNachname, tfEmail);
        topTextFields.setPadding(new Insets(10, 0, 10, 0));
        topTextFields.setSpacing(10);
        topTextFields.setAlignment(Pos.CENTER);

        HBox topButtons = new HBox(bAdd, bRemoveSelectedRow, bProfilVorhanden, bInorder, bPreorder, bPostorder, bClear, bTestData, bBaumZeichnen, bExit);
        topButtons.setPadding(new Insets(10, 0, 10, 0));
        topButtons.setSpacing(10);
        topButtons.setAlignment(Pos.CENTER);


        /**
         * Actions
         */
        bAdd.setOnAction(event -> {
            if (!(textFelderLeer())) {
                schuelerverwaltung.neuenNutzerAnlegen(tfVorname.getText(), tfNachname.getText(), tfEmail.getText());
                inorderAnzeigen();
                tfVorname.clear();
                tfNachname.clear();
                tfEmail.clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Bitte alle Textfelder ausfüllen!").showAndWait();
            }
        });

        bRemoveSelectedRow.setOnAction(event -> {
            if (!textFelderLeer()) {
                schuelerverwaltung.nutzerLoeschen(tableView.getSelectionModel().getSelectedItem().getVorname(),
                        tableView.getSelectionModel().getSelectedItem().getNachname(),
                        tableView.getSelectionModel().getSelectedItem().getEmail());
                tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
                inorderAnzeigen();
                tfVorname.clear();
                tfNachname.clear();
                tfEmail.clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Bitte alle Textfelder ausfüllen!").showAndWait();
            }
        });

        bProfilVorhanden.setOnAction(event -> {
            if (!textFelderLeer()) {
                if (schuelerverwaltung.profilVorhanden(tfVorname.getText(), tfNachname.getText(), tfEmail.getText())) {
                    tableView.getItems().setAll(schuelerverwaltung.profilSchuelerVorhanden(tfVorname.getText(), tfNachname.getText(), tfEmail.getText()));
                    new Alert(Alert.AlertType.CONFIRMATION, "Profil vorhanden!").showAndWait();
                } else {
                    tableView.getItems().clear();
                    new Alert(Alert.AlertType.ERROR, "Benutzername NICHT vorhanden!").showAndWait();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Bitte alle Textfelder ausfüllen!").showAndWait();
            }
        });

        bInorder.setOnAction(event -> {
            inorderAnzeigen();
        });

        bPreorder.setOnAction(event -> {
            preorderAnzeigen();
        });

        bPostorder.setOnAction(event -> {
            postorderAnzeigen();
        });

        bClear.setOnAction(event -> {
            tfVorname.clear();
            tfNachname.clear();
            tfEmail.clear();
            tableView.getItems().clear();
        });

        bTestData.setOnAction(event -> {
            generateTestData();
        });

        bBaumZeichnen.setOnAction(event -> {
            baumzeichnen();
        });

        bExit.setOnAction(event -> {
            System.exit(0);
        });

        topNodes = new VBox(topTextFields, topButtons);
        return topNodes;
    }

    private void baumzeichnen() {
        if (!schuelerverwaltung.getSchuelerBinarySearchTree().isEmpty()) {
            new BaumZeichner(800, 600, schuelerverwaltung.getSchuelerBinarySearchTree());
        }
    }

    private void inorderAnzeigen() {
        data.removeAll(data);
        inorder(schuelerverwaltung.getSchuelerBinarySearchTree());
    }

    private void preorderAnzeigen() {
        data.removeAll(data);
        preorder(schuelerverwaltung.getSchuelerBinarySearchTree());
    }

    private void postorderAnzeigen() {
        data.removeAll(data);
        postorder(schuelerverwaltung.getSchuelerBinarySearchTree());
    }

    public void inorder(BinarySearchTree<Schueler> pBaum) { // LWR
        if (pBaum.getLeftTree() != null) {
            inorder(pBaum.getLeftTree());
        }
        if (pBaum.getContent() != null) {
            data.add(pBaum.getContent());
        }
        if (pBaum.getRightTree() != null) {
            inorder(pBaum.getRightTree());
        }
    }

    public void preorder(BinarySearchTree<Schueler> pSuchBaum) { // WLR
        if (pSuchBaum.getContent() != null) {
            data.add(pSuchBaum.getContent());
        }
        if (pSuchBaum.getLeftTree() != null) {
            preorder(pSuchBaum.getLeftTree());
        }
        if (pSuchBaum.getRightTree() != null) {
            preorder(pSuchBaum.getRightTree());
        }
    }

    public void postorder(BinarySearchTree<Schueler> pBaum) { // LRW
        if (pBaum.getLeftTree() != null) {
            postorder(pBaum.getLeftTree());
        }
        if (pBaum.getRightTree() != null) {
            postorder(pBaum.getRightTree());
        }
        if (pBaum.getContent() != null) {
            data.add(pBaum.getContent());
        }
    }

    private boolean textFelderLeer() {
        return tfVorname.getText().isEmpty() || tfNachname.getText().isEmpty() || tfEmail.getText().isEmpty();
    }
}

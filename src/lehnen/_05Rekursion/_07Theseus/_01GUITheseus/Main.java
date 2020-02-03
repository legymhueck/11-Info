package lehnen._05Rekursion._07Theseus._01GUITheseus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

public class Main extends Application {
    private ToolBar toolBar;
    private Button buttonNeu;
    private TextField tfPercent;
    private VBox root;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;
    private Label l;

    // Ein privates Attribut der Klasse Main deklarieren
    private Affine affine;

    public Main() {
        // Das private Attribut initialisieren
        affine = new Affine();

        // Den Skalierungsfaktor setzen
        affine.appendScale(40, 40);
    }

    @Override
    public void start(Stage pStage) {
        root = new VBox();
        scene = new Scene(root, 400, 400 + 40);

        createToolBar();
        createCanvas();
        fillBoardWithRectangles(Double.parseDouble(tfPercent.getText()));
        createLines();

        pStage.setScene(scene);
        pStage.show();
    }

    public void createToolBar() {
        buttonNeu = new Button("Neu");
        buttonNeu.setOnAction(this::neu);
        tfPercent = new TextField("0.25");
        tfPercent.setPrefWidth(50);
        toolBar = new ToolBar();
        toolBar.getItems().addAll(buttonNeu, tfPercent);
        toolBar.setPrefHeight(40);
        root.getChildren().addAll(toolBar);
    }

    private void neu(ActionEvent actionEvent) {
        root.getChildren().remove(canvas);
        createCanvas();
        fillBoardWithRectangles(Double.parseDouble(tfPercent.getText()));
        createLines();
    }

    private void createCanvas() {
        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();
        gc.setTransform(affine);
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        root.getChildren().add(canvas);
    }

    private void createLines() {
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(0.05);
        for (int x = 0; x <= canvas.getWidth(); x += 1) {
            gc.strokeLine(x, 0, x, canvas.getHeight());
        }
        for (int y = 0; y <= canvas.getHeight(); y += 1) {
            gc.strokeLine(0, y, canvas.getWidth(), y);
        }
    }

    private void fillBoardWithRectangles(double pPercent) {
        // only fill board where field is active
        gc.setFill(Color.BLACK);
        for (int x = 0; x <= canvas.getWidth(); x += 1) {
            for (int y = 0; y <= canvas.getHeight(); y += 1) {
                if (Math.random() <pPercent) {
                    gc.fillRect(x, y, 1, 1);
                }
            }
        }
    }
}
package lehnen._05Rekursion._07Theseus._20200226_Hausaufgabe;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainView extends VBox {
    private final Canvas canvas;
    private final ToolBar toolBar;
    private final Board board;
    private final Affine affine;
    private TextField tf_percent;
    private TextField tf_speed;

    private ExecutorService executor = Executors.newCachedThreadPool();
    private Runnable task;

    public MainView(int pWidth, int pHeight, int pSimulationWidth, int pSimulationHeight) {
        board = new Board(pSimulationWidth, pSimulationHeight);

        affine = new Affine();
        affine.appendScale(pWidth / pSimulationWidth, pHeight / pSimulationHeight);

        toolBar = new ToolBar();
        toolBar.setPrefHeight(40);
        Button b_play = new Button("play");

        b_play.setOnAction(event -> {
            task = () -> findWay();
            executor.execute(task);
        });

        Button b_stop = new Button("stop");
        b_stop.setOnAction(event -> {
            board.stop();
        });

        Button b_new = new Button("new");
        b_new.setOnAction(this::paintBlackRectangle);

        Button b_clear = new Button("clear");
        b_clear.setOnAction(event -> clearBoard());

        Text t_percent = new Text("Percent:");
        tf_percent = new TextField();
        tf_percent.setText("25");
        tf_percent.setPrefWidth(30);

        Text t_speed = new Text("Speed:");
        tf_speed = new TextField();
        tf_speed.setText("50");
        tf_speed.setPrefWidth(50);

        Button b_exit = new Button("exit");
        b_exit.setOnAction(event -> System.exit(0));

        toolBar.getItems().addAll(b_new, b_play, b_clear, b_stop, t_percent, tf_percent, t_speed, tf_speed, b_exit);

        canvas = new Canvas(pWidth, pHeight);
        getChildren().addAll(toolBar, canvas);
    }

    private void paintBlackRectangle(ActionEvent actionEvent) {
        double percent = Integer.parseInt(tf_percent.getText());
        board.stop();
        board.generateBlockedCells(percent);
        draw();
    }

    private void clearBoard() {
        board.stop();
        board.clear();
        draw();
    }

    private void findWay() {
        board.stop();
        board.reset();
        draw();
        Rekursion r = new Rekursion(this);
        r.findWay(0, 0);
    }
    void draw() {
        for (int x = 0; x < board.getBoardWidth(); x++) {
            for (int y = 0; y < board.getBoardHeight(); y++) {
                drawCell(x, y);
            }
        }
    }

    public void drawCell(int pX, int pY) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setTransform(affine);

        // Wähle die richtige Füllfarbe für die Zelle abhängig vom Status
        if (board.getState(pX, pY) == State.POSSIBLE) {
            gc.setFill(Color.GREEN);
        } else if (board.getState(pX, pY) == State.IMPOSSIBLE) {
            gc.setFill(Color.RED);
        } else if (board.getState(pX, pY) == State.BLOCKED) {
            gc.setFill(Color.BLACK);
        } else if (board.getState(pX, pY) == State.FREE) {
            gc.setFill(Color.BEIGE);
        }
        // Färbe den Hintergrund der Zelle mit der gewählten Farbe
        gc.fillRect(pX, pY, 1, 1);

        // Zeichne einen Rand um die gerade gefärbte Zelle
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(0.05);
        gc.strokeLine(pX, pY, pX + 1, pY);
        gc.strokeLine(pX, pY, pX, pY + 1);
        gc.strokeLine(pX, pY + 1, pX + 1, pY + 1);
        gc.strokeLine(pX + 1, pY, pX + 1, pY + 1);
    }

    public int getToolBarHeight() {
        return (int) toolBar.getPrefHeight();
    }

    public Board getBoard() {
        return board;
    }

    public TextField getTf_speed() {
        return tf_speed;
    }
}
package lehnen._05Rekursion._02Potenzierer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private VBox root;
    private Scene scene;

    public Main() {

    }

    @Override
    public void start(Stage pStage) {
        pStage.setTitle("Was bin ich?");
        pStage.getIcons().add(new Image("lehnen/_00Material/_00Media/gymhueck.png"));
        root = new VBox();
        scene = new Scene(root, 240, 200, Color.BEIGE);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        TextField tf_eingabe1 = new TextField();
        tf_eingabe1.setMaxWidth(100);
        tf_eingabe1.setAlignment(Pos.CENTER);
        tf_eingabe1.setPromptText("Eingabe 1");


        TextField tf_eingabe2 = new TextField();
        tf_eingabe2.setMaxWidth(100);
        tf_eingabe2.setAlignment(Pos.CENTER);
        tf_eingabe2.setPromptText("Eingabe 2");

        TextField tf_ausgabe = new TextField();
        tf_ausgabe.setMaxWidth(100);
        tf_ausgabe.setAlignment(Pos.CENTER);
        tf_ausgabe.setPromptText("Ausgabe");

        Button b_ausfuehren = new Button("Ausführen");
        b_ausfuehren.setOnAction(actionEvent -> {
            tf_ausgabe.setText("" + wasBinIch(Long.parseLong(tf_eingabe1.getText()), Long.parseLong(tf_eingabe2.getText())));
        });

        root.getChildren().addAll(tf_eingabe1, tf_eingabe2, b_ausfuehren, tf_ausgabe);

        pStage.setScene(scene);
        pStage.show();
    }

    // Anfang Methoden
    private long wbi2(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            return wbi2(a, b / 2) * wbi2(a, b - (b / 2));
        }
    }

    private long wasBinIch(long pA, long pB) {
        if (pB == 0) {
            return 1;
        } else {
            long r = wasBinIch(pA, pB / 2);
            if (pB % 2 == 0) {
                return r * r;
            } else {
                return r * r * pA;
            }
        }
    }
}



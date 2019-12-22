package lehnen._05Rekursion._01Palindrom;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
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
        pStage.setTitle("Rekursion");
        pStage.getIcons().add(new Image("lehnen/_00Material/_00Media/gymhueck.png"));
        root = new VBox();
        scene = new Scene(root, 230, 160, Color.BEIGE);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        TextField tf_eingabe = new TextField();
        tf_eingabe.setMaxWidth(140);
        tf_eingabe.setPromptText("Eingabe");
        tf_eingabe.setAlignment(Pos.CENTER);
        tf_eingabe.setTextFormatter(new TextFormatter<>(change -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        TextField tf_ausgabe = new TextField();
        tf_ausgabe.setMaxWidth(140);
        tf_ausgabe.setPromptText("Ausgabe");
        tf_ausgabe.setAlignment(Pos.CENTER);

        Button b_ausfuehren = new Button("Ausführen");
        b_ausfuehren.setOnAction(actionEvent -> {
            tf_ausgabe.setText(wasTueIch(toUppercase(tf_eingabe)));
        });

        root.getChildren().addAll(tf_eingabe, b_ausfuehren, tf_ausgabe);

        pStage.setScene(scene);
        pStage.show();
    }

    private String wasTueIch(String pWort) {
        if (pWort.length() <= 1) {
            return pWort;
        } else {
            return wasTueIch(pWort.substring(1, pWort.length())) + pWort.charAt(0);  // wegen Arbeitsblatt
        }
    }

    private String toUppercase(TextField pTextfield) {
        pTextfield.setTextFormatter(new TextFormatter<>(change -> {
            pTextfield.setText(change.getText().toUpperCase());
            return change;
        }));
        return pTextfield.getText();
    }
}


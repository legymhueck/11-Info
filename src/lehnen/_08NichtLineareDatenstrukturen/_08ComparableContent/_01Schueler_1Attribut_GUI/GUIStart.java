package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._01Schueler_1Attribut_GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIStart extends Application {

    @Override
    public void start(Stage pStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("comparableContent.fxml"));
        Parent root = fxmlLoader.load();
        pStage.setTitle("Comparable Content");
        pStage.setScene(new Scene(root));
        pStage.show();
    }
}

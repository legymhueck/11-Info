package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._04Suchen_Einfuegen_Loeschen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComparableGUIStart extends Application {

    @Override
    public void start(Stage pStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("comparableGUI.fxml"));
        Parent root = fxmlLoader.load();
        pStage.setTitle("Comparable GUI");
        pStage.setScene(new Scene(root));
        pStage.show();
    }
}
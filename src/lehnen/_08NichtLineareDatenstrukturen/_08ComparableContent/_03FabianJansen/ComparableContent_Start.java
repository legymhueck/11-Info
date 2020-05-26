package lehnen._08NichtLineareDatenstrukturen._08ComparableContent._03FabianJansen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComparableContent_Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("comparableContent.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

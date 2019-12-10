package lehnen._04Stack._03_Bahnhof_GUI_modified;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage pStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Bahnhof.fxml"));
        pStage.setScene(new Scene(root));
        pStage.show();
    }
}

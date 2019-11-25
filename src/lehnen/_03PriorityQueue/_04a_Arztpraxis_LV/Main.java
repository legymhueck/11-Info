package lehnen._03PriorityQueue._04a_Arztpraxis_LV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage pStage) throws Exception {
        primaryStage = pStage;

        mainWindow();
    }

    public void mainWindow() throws Exception {

        // FXML load
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("arztpraxis.fxml"));

        // AnchorPane (i.e. the root element) is loaded
        AnchorPane pane = loader.load();

        // Controller load
        Controller controller = loader.getController();
        controller.setMain(this);

        // Scene create with root object pane (i.e. the anchor pane)
        Scene scene = new Scene(pane);


        // Stage set
        primaryStage.setScene(scene);
        primaryStage.setTitle("Arztpraxis Instant Healing");
        primaryStage.show();
    }

    // Main method, which only has the launch method for Application
    public static void main(String[] args) {
        launch(args);
    }
}

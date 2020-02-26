package lehnen._05Rekursion._07Theseus._20200226_Hausaufgabe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TheseusStart extends Application {
    private final int width;
    private final int height;
    private final int simulationWidth;
    private final int simulationHeight;

    public TheseusStart() {
        width = 780;
        height = 780;
        simulationWidth = 20;
        simulationHeight = 20;
    }

    @Override
    public void start(Stage pStage) {
        MainView mainView = new MainView(width, height, simulationWidth, simulationHeight);
        Scene scene = new Scene(mainView, width, height + mainView.getToolBarHeight());

        pStage.setScene(scene);
        pStage.setResizable(false);
        pStage.show();

        mainView.draw();
    }
}

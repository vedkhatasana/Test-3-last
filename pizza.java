import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VedantPizzaApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Vedant's Pizza Ordering App");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Vedant's Pizza App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

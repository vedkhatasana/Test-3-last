import javafx.application.Application;
import javafx.stage.Stage;
import view.PizzaOrderPage;

public class VedantPizzaApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new PizzaOrderPage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

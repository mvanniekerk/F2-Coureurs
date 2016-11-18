import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("Click here als Alex deze knop maakt!");

        StackPane root = new StackPane();
        root.getChildren().add(button);

        stage.setTitle("Hello World Application!");
        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}

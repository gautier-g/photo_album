package album;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Parent  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/all.fxml")));
        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle("Album photo");
        stage.setScene(scene);
        stage.show();
    }
}
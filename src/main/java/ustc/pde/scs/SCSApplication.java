package ustc.pde.scs;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ustc.pde.scs.sql.DataBaseConnector;

public class SCSApplication extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/startview.fxml"));
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root, 1920, 1080));
        primaryStage.setTitle("USTC SCS");

        primaryStage.setResizable(false);

        primaryStage.show();

        // test sql connection
        DataBaseConnector connector = new DataBaseConnector();
        connector.getConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}
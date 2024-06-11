package ustc.pde.scs;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ustc.pde.scs.controller.StartViewController;

public class SCSApplication extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ustc/pde/scs/fxml/startview.fxml"));
        Parent root = loader.load();
        //archer
        primaryStage.setScene(new Scene(root, 1920, 1080));
        //hjs
        //primaryStage.setScene(new Scene(root,1500,900));
        primaryStage.setTitle("USTC SCS");

        primaryStage.setResizable(false);
        //primaryStage.setMaximized(true);
        primaryStage.show();

        StartViewController controller = loader.getController();
        controller.initializeController();
    }

    public static void main(String[] args) {
        launch();
    }
}
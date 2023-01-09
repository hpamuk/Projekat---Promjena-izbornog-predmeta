package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        LoginController loginController = new LoginController();
        fxmlLoader.setController(loginController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Prijava za promjenu predmeta");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
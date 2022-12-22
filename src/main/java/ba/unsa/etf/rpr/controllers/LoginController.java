package ba.unsa.etf.rpr.controllers;

// povezi sa fxmlom i dodaj potrebne importe


import ba.unsa.etf.rpr.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class LoginController {
    public TextField fieldUsername;

    // vidi ispravnost za email
    @FXML
    public void initialize() {
        fieldUsername.getStyleClass().add("poljeNijeIspravno");
        fieldUsername.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty()) {
                fieldUsername.getStyleClass().add("poljeNijeIspravno");
            } else {
                fieldUsername.getStyleClass().removeAll("poljeNijeIspravno");
            }
        });
    }


    public void loginClick(ActionEvent actionEvent) throws IOException {
        if(fieldUsername.getText().isEmpty()) {
            return;
        }
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));

        Parent root = loader.load();
        MainController main = loader.getController();
        // ovdje cu postaviti u labeli dobrodosao korisnice
        stage.setTitle("Promjena izbornog predmeta");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public void cancelClick(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();

    }
}

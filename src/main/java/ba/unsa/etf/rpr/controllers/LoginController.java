package ba.unsa.etf.rpr.controllers;

//i dodaj potrebne importe


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class LoginController {
    public TextField usernameField;
    public PasswordField passwordField;

    // vidi sto ne radi initialize
   /* @FXML
    public void initialize() {
        usernameField.getStyleClass().add("poljeNijeIspravno");
        usernameField.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty()) {
                usernameField.getStyleClass().add("poljeNijeIspravno");
            } else {
                usernameField.getStyleClass().removeAll("poljeNijeIspravno");
            }
        });
    }*/
/*
    @FXML
    public void initialize() {
        usernameField.getStyleClass().add("poljeNijeIspravno");
        usernameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.isEmpty()) {
                    usernameField.getStyleClass().add("poljeNijeIspravno");
                } else {
                    usernameField.getStyleClass().removeAll("poljeNijeIspravno");
                }
            }
        });
    }
    */

    public void loginClick(ActionEvent actionEvent) throws IOException {
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prazno polje");
            alert.setHeaderText("Prazan username!");
            alert.setContentText("Morate unijeti svoj username");

            alert.showAndWait();
             return;
        }
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        MainController mainController = new MainController(); // ovo
        loader.setController(mainController);
        Parent root = loader.load();
        mainController.label.setText(mainController.label.getText() + usernameField.getText());
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

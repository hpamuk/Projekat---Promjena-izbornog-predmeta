package ba.unsa.etf.rpr.controllers;

//i dodaj potrebne importe


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


/**
 * The type Login controller.
 */
public class LoginController {
    /**
     * The Username field.
     */
    public TextField usernameField;
    /**
     * The Password field.
     */
    public PasswordField passwordField;

    /**
     * Initialize.
     */
// me radi za crveno
    @FXML
    public void initialize() {

        usernameField.textProperty().addListener((obs, o, n) -> {
//                if (usernameField.getText().isEmpty()) {
//                    usernameField.getStyleClass().removeAll("poljeIspravno");
//                    usernameField.getStyleClass().addAll("poljeNijeIspravno");
//                } else {
//
//                   usernameField.getStyleClass().removeAll("poljeNijeIspravno");
//                    usernameField.getStyleClass().addAll("poljeIspravno");
//                }

        });
    }

    /**
     * Login click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
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

    /**
     * Cancel click.
     *
     * @param actionEvent the action event
     */
    public void cancelClick(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();

    }
}

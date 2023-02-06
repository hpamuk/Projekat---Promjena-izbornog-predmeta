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
     * Login click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void loginClick(ActionEvent actionEvent) throws IOException {
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prazno jedno od polja!");
            alert.setHeaderText("Prazan username ili password!");
            alert.setContentText("Morate unijeti svoj username ili password.");
            alert.showAndWait();
            return;
        }
        if(!((usernameField.getText().equals("mmujic1") && passwordField.getText().equals("123456")) ||
                (usernameField.getText().equals("mmehic1") && passwordField.getText().equals("654321")) ||
                (usernameField.getText().equals("ffatic1") && passwordField.getText().equals("123123")) ||
                (usernameField.getText().equals("sselmic1") && passwordField.getText().equals("321321")))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Zabrana pristupa!");
            alert.setHeaderText("Ne možete pristupiti sistemu!");
            alert.setContentText("Niste korisnik sistema, ili ste pogriješili Vaš username ili password.");
            alert.showAndWait();
            return;
        }
        else if(passwordField.getText().length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pogrešno unesen password!");
            alert.setHeaderText("Prekratak password!");
            alert.setContentText("Vaš password mora imati 6 karaktera.");
            alert.showAndWait();
            return;
        }

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/afterLogin.fxml"));
        AfterLoginController afterLoginController = new AfterLoginController(usernameField.getText()); // ovo
        loader.setController(afterLoginController);
        Parent root = loader.load();
        afterLoginController.wellcomeLabel.setText(afterLoginController.wellcomeLabel.getText() + " " + usernameField.getText() + "!");
        stage.setTitle("Prikaz izbornih predmeta");
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

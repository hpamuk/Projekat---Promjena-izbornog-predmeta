package ba.unsa.etf.rpr.controllers;

//i dodaj potrebne importe


import ba.unsa.etf.rpr.business.OldSubjectManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.exceptions.MyException;
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


public class LoginController {
    public TextField usernameField;
    public PasswordField passwordField;
    private final UserManager userManager = new UserManager();

    public void loginClick(ActionEvent actionEvent) throws IOException, MyException {
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prazno jedno od polja!");
            alert.setHeaderText("Prazan username ili password!");
            alert.setContentText("Morate unijeti svoj username ili password.");
            alert.showAndWait();
            return;
        }
        if(!userManager.searchByName(usernameField.getText(), passwordField.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Zabrana pristupa!");
            alert.setHeaderText("Ne možete pristupiti sistemu!");
            alert.setContentText("Niste korisnik sistema, ili ste pogriješili Vaš username ili password.");
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
        stage.setResizable(false);
        Stage s = (Stage)usernameField.getScene().getWindow();
        s.close();
        stage.show();
    }

    public void cancelClick(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
}

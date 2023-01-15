package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * The type Main controller.
 */
public class MainController {
    /**
     * The Label.
     */
    public Label label;

    /**
     * Submit click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void submitClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/lastOne.fxml"));
        LastController lastController = new LastController(); // ovo
        loader.setController(lastController);
        Parent root = loader.load();
        stage.setTitle("Vaši novi izborni predmeti!");
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

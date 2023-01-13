package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Uspješan zahtjev!");
        alert.setHeaderText(null);
        alert.setContentText("Uspješno ste podnijeli prijavu za promjenu izbornog predmeta!");
        alert.showAndWait();
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

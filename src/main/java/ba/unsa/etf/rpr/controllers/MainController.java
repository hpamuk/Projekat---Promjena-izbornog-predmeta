package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.NewSubjectManager;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.exceptions.MyException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableView<NewSubject> newSubjectTable;
    public TableColumn<NewSubject, String> colNaziv;
    public TableColumn<NewSubject, String>  colNazivProf;
    public TableColumn<NewSubject, Integer>  colbrCasovaSemestralno;
    public TableColumn<NewSubject, Integer>  colbrCasovaSedmicno;

    private final NewSubjectManager newSubjectManager = new NewSubjectManager();

    @FXML
    public void initialize() throws MyException {
        colNaziv.setCellValueFactory(new PropertyValueFactory<NewSubject, String>("naziv"));
        colNazivProf.setCellValueFactory(new PropertyValueFactory<NewSubject, String> ("profesor"));
        colbrCasovaSemestralno.setCellValueFactory(new PropertyValueFactory<NewSubject, Integer> ("brCasovaSemestralno"));
        colbrCasovaSedmicno.setCellValueFactory(new PropertyValueFactory<NewSubject, Integer> ("brCasovaSedmicno"));
        refreshSubjects();
    }

    private void refreshSubjects(){
        try {
            newSubjectTable.setItems(FXCollections.observableList(newSubjectManager.getAll()));
            newSubjectTable.refresh();
        } catch (MyException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }




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

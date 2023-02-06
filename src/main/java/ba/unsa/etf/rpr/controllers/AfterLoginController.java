package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.OldSubjectManager;
import ba.unsa.etf.rpr.dao.OldSubjectsDao;
import ba.unsa.etf.rpr.dao.OldSubjectsDaoSQLImpl;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.exceptions.MyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class AfterLoginController {
    public Label wellcomeLabel;
    public TableView<OldSubject> oldSubjectTable;
    public TableColumn<OldSubject, String> colNaziv;
    public TableColumn<OldSubject, String>  colNazivProf;
    public TableColumn<OldSubject, Integer>  colbrCasovaSemestralno;
    public TableColumn<OldSubject, Integer>  colBrCasovaSedmicno;

    private final OldSubjectManager oldSubjectManager = new OldSubjectManager();
    private String username;
    public AfterLoginController(String name) {
        username = name;
    }

    @FXML
    public void initialize() throws MyException {

        colNaziv.setCellValueFactory(new PropertyValueFactory<OldSubject, String>("naziv"));
        colNazivProf.setCellValueFactory(new PropertyValueFactory<OldSubject, String> ("profesor"));
        colbrCasovaSemestralno.setCellValueFactory(new PropertyValueFactory<OldSubject, Integer> ("brCasovaSemestralno"));
        colBrCasovaSedmicno.setCellValueFactory(new PropertyValueFactory<OldSubject, Integer> ("brCasovaSedmicno"));
        refreshSubjects();
    }

    private void refreshSubjects(){
        try {
            // PROBA AKO POSALJEM NEKI USER TJ STRING
            oldSubjectTable.setItems(FXCollections.observableList(oldSubjectManager.getOdgovarajuce(username)));
            oldSubjectTable.refresh();
        } catch (MyException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }


    public void onActionChange(ActionEvent actionEvent) throws IOException {
        try {
            OldSubject predmetZaPromijeniti = oldSubjectTable.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            MainController mainController = new MainController(predmetZaPromijeniti, username);
            loader.setController(mainController);
            Parent root = loader.load();
            stage.setTitle("Promjena izbornog predmeta");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

            Stage s = (Stage)wellcomeLabel.getScene().getWindow();
            s.close();

            stage.show();
        }catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Greška pri promjeni predmeta");
            alert.setContentText("Morate prvo odabrati predmet");

            alert.showAndWait();
        }

    }


}

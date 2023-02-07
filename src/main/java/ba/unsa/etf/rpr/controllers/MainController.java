package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.NewSubjectManager;
import ba.unsa.etf.rpr.business.OldSubjectManager;
import ba.unsa.etf.rpr.business.UserSubjectManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.domain.UserSubject;
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
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MainController {

    public Label label;
    public TableView<NewSubject> newSubjectTable;
    public TableColumn<NewSubject, String> colNaziv;
    public TableColumn<NewSubject, String>  colNazivProf;
    public TableColumn<NewSubject, Integer>  colbrCasovaSemestralno;
    public TableColumn<NewSubject, Integer>  colbrCasovaSedmicno;
    private final OldSubjectManager oldSubjectManager = new OldSubjectManager();
    private final NewSubjectManager newSubjectManager = new NewSubjectManager();
    private final UserSubjectManager userSubjectManager = new UserSubjectManager();
    private OldSubject oldSubject = null;
    private String username;

    public MainController(OldSubject oldSubject, String username) {
        this.oldSubject = oldSubject;
        this.username = username;
    }

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


    public void onActionPodnesi(ActionEvent actionEvent) throws IOException {
        try {
            NewSubject noviPredmetZaDodati = newSubjectTable.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/lastOne.fxml"));


            // da li da ide u neki manager ??????
            List<UserSubject> predmetiUsera = userSubjectManager.getAll();
            for (UserSubject u : predmetiUsera) {
                if(u.getUsername().equals(username) && u.getNaziv().equals(noviPredmetZaDodati.getNaziv())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Greška pri promjeni predmeta");
                    alert.setContentText("Odabrani predmet vec pohađate i ne možete ga opet odabrati!");
                    alert.showAndWait();
                    return;
                }
            }



            OldSubject noviZaUbaciti = new OldSubject();
            noviZaUbaciti.setId(noviPredmetZaDodati.getId());
            noviZaUbaciti.setProfesor(noviPredmetZaDodati.getProfesor());
            noviZaUbaciti.setBrCasovaSedmicno(noviPredmetZaDodati.getBrCasovaSedmicno());
            noviZaUbaciti.setNaziv(noviPredmetZaDodati.getNaziv());
            noviZaUbaciti.setBrCasovaSemestralno(noviPredmetZaDodati.getBrCasovaSemestralno());
            oldSubjectManager.add(noviZaUbaciti);
            userSubjectManager.deleteByName(username, oldSubject.getNaziv());
            userSubjectManager.addNewUserSubject(username, noviZaUbaciti.getNaziv());
            LastController lastController = new LastController(username);
            loader.setController(lastController);
            Parent root = loader.load();
            stage.setTitle("Vaši novi izborni predmeti!");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            Stage s = (Stage)label.getScene().getWindow();
            s.close();
            stage.show();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Greška pri promjeni predmeta");
            alert.setContentText("Morate prvo odabrati predmet");
            alert.showAndWait();
        }
    }

    public void cancelClick(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

}

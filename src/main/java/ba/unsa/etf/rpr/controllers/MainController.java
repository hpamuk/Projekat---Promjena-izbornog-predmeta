package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.NewSubjectManager;
import ba.unsa.etf.rpr.business.OldSubjectManager;
import ba.unsa.etf.rpr.business.UserSubjectManager;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.OldSubject;
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
 * JavaFX controller
 * @author Hena Pamuk
 */
public class MainController {

    /**
     * The Label.
     */
    public Label label;
    /**
     * The New subject table.
     */
    public TableView<NewSubject> newSubjectTable;
    /**
     * The Col naziv.
     */
    public TableColumn<NewSubject, String> colNaziv;
    /**
     * The Col naziv prof.
     */
    public TableColumn<NewSubject, String>  colNazivProf;
    /**
     * The Colbr casova semestralno.
     */
    public TableColumn<NewSubject, Integer>  colbrCasovaSemestralno;
    /**
     * The Colbr casova sedmicno.
     */
    public TableColumn<NewSubject, Integer>  colbrCasovaSedmicno;
    private final OldSubjectManager oldSubjectManager = new OldSubjectManager();
    private final NewSubjectManager newSubjectManager = new NewSubjectManager();
    private final UserSubjectManager userSubjectManager = new UserSubjectManager();
    private OldSubject oldSubject = null;
    private String username;

    /**
     * Instantiates a new Main controller.
     *
     * @param oldSubject the old subject
     * @param username   the username
     */
    public MainController(OldSubject oldSubject, String username) {
        this.oldSubject = oldSubject;
        this.username = username;
    }

    /**
     * Initialize.
     *
     * @throws MyException the my exception
     */
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
     * On action podnesi.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void onActionPodnesi(ActionEvent actionEvent) throws IOException {
        try {
            NewSubject noviPredmetZaDodati = newSubjectTable.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/lastOne.fxml"));
            if(userSubjectManager.searchByUsernameAndSubject(username,noviPredmetZaDodati.getNaziv())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Gre??ka pri promjeni predmeta");
                alert.setContentText("Odabrani predmet vec poha??ate i ne mo??ete ga opet odabrati!");
                alert.showAndWait();
                return;
            }
            oldSubjectManager.add(noviPredmetZaDodati);
            userSubjectManager.deleteByName(username, oldSubject.getNaziv());
            userSubjectManager.addNewUserSubject(username, noviPredmetZaDodati.getNaziv());
            LastController lastController = new LastController(username);
            loader.setController(lastController);
            Parent root = loader.load();
            stage.setTitle("Va??i novi izborni predmeti!");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            Stage s = (Stage)label.getScene().getWindow();
            s.close();
            stage.show();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Gre??ka pri promjeni predmeta");
            alert.setContentText("Morate prvo odabrati predmet");
            alert.showAndWait();
        }
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

package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.OldSubjectsDao;
import ba.unsa.etf.rpr.dao.OldSubjectsDaoSQLImpl;
import ba.unsa.etf.rpr.domain.OldSubject;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class AfterLoginController {
    public Label wellcomeLabel;
    public TableView<OldSubject> tableViewOldSubjects;
    public TableColumn colNaziv;
    public TableColumn colNazivProf;
    public TableColumn colbrCasovaSemestralno;
    public TableColumn colBrCasovaSedmicno;

    public OldSubjectsDao oldSubjectsDao = OldSubjectsDaoSQLImpl.getInstance();
    public ObservableList<OldSubject> oldSubjectsList;
    @FXML
    public void initialize() {
      //  tableViewOldSubjects.setItems(oldSubjectsList);
        colNaziv.setCellValueFactory(new PropertyValueFactory("naziv"));
        colNazivProf.setCellValueFactory(new PropertyValueFactory("nazivProfesora"));
        colbrCasovaSemestralno.setCellValueFactory(new PropertyValueFactory("brCasovaSemestralno"));
        colBrCasovaSedmicno.setCellValueFactory(new PropertyValueFactory("brCasovaSedmicno"));

    }






    public void changeClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        MainController mainController = new MainController(); // ovo
        loader.setController(mainController);
        Parent root = loader.load();
        stage.setTitle("Promjena izbornog predmeta");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }


}

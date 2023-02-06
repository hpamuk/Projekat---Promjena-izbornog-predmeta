package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.OldSubjectManager;
import ba.unsa.etf.rpr.domain.NewSubject;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.exceptions.MyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class LastController {

    private NewSubject noviPredmet;
    private String username = null;
    private OldSubjectManager oldSubjectManager;
    public ListView<OldSubject> lvNoviPredmeti;
    private ObservableList<OldSubject> predmetiZaListu;
    public LastController(NewSubject noviPredmet) {
        this.noviPredmet = noviPredmet;

    }
    public LastController(String username) {
        try {
            oldSubjectManager = new OldSubjectManager();
            predmetiZaListu = FXCollections.observableArrayList(oldSubjectManager.getOdgovarajuce(username));
            this.username = username;
        }catch (MyException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize() {
        lvNoviPredmeti.setItems(predmetiZaListu);
    }

    public void onActionUredu(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

}

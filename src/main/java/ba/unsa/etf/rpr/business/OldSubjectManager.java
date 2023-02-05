package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.OldSubject;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.domain.UserSubject;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

public class OldSubjectManager {

    public List<OldSubject> getAll() throws MyException {
        return DaoFactory.oldSubjectsDao().getAll();
    }

    public OldSubject getById(int oldSubjectId) throws MyException{
        return DaoFactory.oldSubjectsDao().getById(oldSubjectId);
    }

    public void update(OldSubject q) throws MyException{
        DaoFactory.oldSubjectsDao().update(q);
    }

    public List<OldSubject> getOdgovarajuce(String username) throws MyException {
        UserSubjectManager userSubjectManager = new UserSubjectManager();
        List<UserSubject> listaOdabranih = userSubjectManager.getByUsername(username);
        List<OldSubject> svi = this.getAll();
        List<OldSubject> zaVracanje = new ArrayList<>();
        for (UserSubject u : listaOdabranih) {
            for (OldSubject o : svi) {
                if(u.getNaziv() == o.getNaziv())
                    zaVracanje.add(o);
            }
        }
        return zaVracanje;
    }
}

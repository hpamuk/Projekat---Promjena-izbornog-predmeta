package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class OldSubject implements Idable{
    private int id;
    private String naziv;
    private String nazivProfesora;
    private int brCasovaSemestralno;
    private int brCasovaSedmicno;

    public OldSubject() {
        this.id = 0;
        this.naziv = null;
        this.nazivProfesora = null;
        this.brCasovaSemestralno = 0;
        this.brCasovaSedmicno = 0;
    }
   /*
    public OldSubject(int id, String naziv, String nazivProfesora, int brCasovaSemestralno, int brCasovaSedmicno) {
        this.id = id;
        this.naziv = naziv;
        this.nazivProfesora = nazivProfesora;
        this.brCasovaSemestralno = brCasovaSemestralno;
        this.brCasovaSedmicno = brCasovaSedmicno;
    }*/

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNazivProfesora() {
        return nazivProfesora;
    }

    public void setNazivProfesora(String nazivProfesora) {
        this.nazivProfesora = nazivProfesora;
    }

    public int getBrCasovaSemestralno() {
        return brCasovaSemestralno;
    }

    public void setBrCasovaSemestralno(int brCasovaSemestralno) {
        this.brCasovaSemestralno = brCasovaSemestralno;
    }

    public int getBrCasovaSedmicno() {
        return brCasovaSedmicno;
    }

    public void setBrCasovaSedmicno(int brCasovaSedmicno) {
        this.brCasovaSedmicno = brCasovaSedmicno;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldSubject that = (OldSubject) o;
        return id == that.id && brCasovaSemestralno == that.brCasovaSemestralno && brCasovaSedmicno == that.brCasovaSedmicno && Objects.equals(naziv, that.naziv) && Objects.equals(nazivProfesora, that.nazivProfesora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, nazivProfesora, brCasovaSemestralno, brCasovaSedmicno);
    }

    @Override
    public String toString() {
        return "OldSubject{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", nazivProfesora='" + nazivProfesora + '\'' +
                ", brCasovaSemestralno=" + brCasovaSemestralno +
                ", brCasovaSedmicno=" + brCasovaSedmicno +
                '}';
    }
}

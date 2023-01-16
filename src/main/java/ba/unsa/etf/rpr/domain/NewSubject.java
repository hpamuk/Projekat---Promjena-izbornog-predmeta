package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class NewSubject implements Idable{
    private int id;
    private String naziv;
    private String profesor;
    private int brCasovaSemestralno;
    private int brCasovaSedmicno;

    public NewSubject() {
        this.id = 0;
        this.naziv = null;
        this.profesor = null;
        this.brCasovaSemestralno = 0;
        this.brCasovaSedmicno = 0;
    }

    public NewSubject(int id, String naziv, String nazivProfesora, int brCasovaSemestralno, int brCasovaSedmicno) {
        this.id = id;
        this.naziv = naziv;
        this.profesor = nazivProfesora;
        this.brCasovaSemestralno = brCasovaSemestralno;
        this.brCasovaSedmicno = brCasovaSedmicno;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNazivProfesora() {
        return profesor;
    }

    public void setNazivProfesora(String nazivProfesora) {
        this.profesor = nazivProfesora;
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
        NewSubject that = (NewSubject) o;
        return id == that.id && brCasovaSemestralno == that.brCasovaSemestralno && brCasovaSedmicno == that.brCasovaSedmicno
                && Objects.equals(naziv, that.naziv) && Objects.equals(profesor, that.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, profesor, brCasovaSemestralno, brCasovaSedmicno);
    }

    @Override
    public String toString() {
        return "NewSubject{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", nazivProfesora='" + profesor + '\'' +
                ", brCasovaSemestralno=" + brCasovaSemestralno +
                ", brCasovaSedmicno=" + brCasovaSedmicno +
                '}';
    }
}

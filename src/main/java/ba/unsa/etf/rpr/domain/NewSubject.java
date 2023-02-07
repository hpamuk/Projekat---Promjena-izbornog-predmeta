package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class NewSubject implements Idable{
    private Integer id;
    private String naziv;
    private String profesor;
    private Integer brCasovaSemestralno;
    private Integer brCasovaSedmicno;

    public NewSubject() {
    }

    public NewSubject(Integer id, String naziv, String nazivProfesora, Integer brCasovaSemestralno, Integer brCasovaSedmicno) {
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

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String nazivProfesora) {
        this.profesor = nazivProfesora;
    }

    public int getBrCasovaSemestralno() {
        return brCasovaSemestralno;
    }

    public void setBrCasovaSemestralno(Integer brCasovaSemestralno) {
        this.brCasovaSemestralno = brCasovaSemestralno;
    }

    public int getBrCasovaSedmicno() {
        return brCasovaSedmicno;
    }

    public void setBrCasovaSedmicno(Integer brCasovaSedmicno) {
        this.brCasovaSedmicno = brCasovaSedmicno;
    }

    @Override
    public void setId(Integer id) {
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

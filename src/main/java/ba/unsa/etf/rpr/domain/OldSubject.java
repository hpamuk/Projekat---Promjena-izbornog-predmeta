package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class OldSubject implements Idable{
    private Integer id;
    private String naziv;
    private String profesor;
    private Integer brCasovaSemestralno;
    private Integer brCasovaSedmicno;

    public OldSubject() {

    }

    public OldSubject(Integer id, String naziv, String profesor, Integer brCasovaSemestralno, Integer brCasovaSedmicno) {
        this.id = id;
        this.naziv = naziv;
        this.profesor = profesor;
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

    public void setProfesor(String profesor) {
        this.profesor = profesor;
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
        OldSubject that = (OldSubject) o;
        return id == that.id && brCasovaSemestralno == that.brCasovaSemestralno && brCasovaSedmicno == that.brCasovaSedmicno && Objects.equals(naziv, that.naziv) && Objects.equals(profesor, that.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, profesor, brCasovaSemestralno, brCasovaSedmicno);
    }

    @Override
    public String toString() {
        return "OldSubject{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", profesor='" + profesor + '\'' +
                ", brCasovaSemestralno=" + brCasovaSemestralno +
                ", brCasovaSedmicno=" + brCasovaSedmicno +
                '}';
    }
}

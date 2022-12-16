package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class NewSubject implements Idable{
    private int id;
    private String naziv;
    private String nazivProfesora;
    private int brCasovaSemestralno;
    private int brCasovaSedmicno;


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
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewSubject that = (NewSubject) o;
        return id == that.id && brCasovaSemestralno == that.brCasovaSemestralno && brCasovaSedmicno == that.brCasovaSedmicno && Objects.equals(naziv, that.naziv) && Objects.equals(nazivProfesora, that.nazivProfesora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, nazivProfesora, brCasovaSemestralno, brCasovaSedmicno);
    }

    @Override
    public String toString() {
        return "NewSubject{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", nazivProfesora='" + nazivProfesora + '\'' +
                ", brCasovaSemestralno=" + brCasovaSemestralno +
                ", brCasovaSedmicno=" + brCasovaSedmicno +
                '}';
    }
}

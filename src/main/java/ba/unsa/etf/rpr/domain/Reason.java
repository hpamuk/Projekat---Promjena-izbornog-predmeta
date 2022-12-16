package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Reason implements Idable{
    private int id;
    private String naziv;
    private String opis;

    public Reason() {
        this.id = 0; // vidi kako ces
        naziv = null;
        opis = null;
    }


    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return 0;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reason reason = (Reason) o;
        return id == reason.id && Objects.equals(naziv, reason.naziv) && Objects.equals(opis, reason.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, opis);
    }

    @Override
    public String toString() {
        return "Reason{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
